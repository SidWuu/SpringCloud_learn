package spiderjd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spiderjd.dao.SpiderDao;
import spiderjd.service.SpiderService;
import spiderjd.util.HttpClientUtil;
import spiderjd.vo.SpiderGoodsInfo;

import com.alibaba.fastjson.JSON;

@Service("spiderService")
public class SpiderServiceImpl implements SpiderService{

	private static String HTTPS="https:";
	@Autowired
	private SpiderDao spiderDao;
	
	@Override
	public void saveJd(String url, Map<String, String> params) {
		String html=HttpClientUtil.sendGet(url, params, null);
		if(StringUtils.isNotBlank(html)){
			List<SpiderGoodsInfo> list=parseGoods(html);
			for(SpiderGoodsInfo mod:list){
				//保存
				spiderDao.saveJd(mod);
			}
		}
	}
	
	private List<SpiderGoodsInfo> parseGoods(String html){
		List<SpiderGoodsInfo> list=new ArrayList<SpiderGoodsInfo>();
		
		Document doc=Jsoup.parse(html);
		Elements eles=doc.select("ul[class=gl-warp clearfix]").select("li[class=gl-item]");
		int index=0;
		for(Element ele:eles){
			SpiderGoodsInfo mod=new SpiderGoodsInfo();
			mod.setGoodsId(ele.attr("data-sku"));
			mod.setGoodsName(ele.select("div [class=p-name p-name-type-2]").select("em").text());
			mod.setGoodsPrice(ele.select("div[class=p-price]").select("strong").select("i").text());
			mod.setImgUrl(HTTPS+ele.select("div[class=p-img]").select("a").select("img").attr("src"));
			list.add(mod);
			System.out.println(JSON.toJSONString(mod));
			if(index++ ==9){
				break;
			}
		}
		return list;
	}
	
}
