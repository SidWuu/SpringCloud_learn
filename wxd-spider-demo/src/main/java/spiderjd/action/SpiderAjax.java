package spiderjd.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spiderjd.service.SpiderService;

@Controller
@RequestMapping("sprderAjax/*")
public class SpiderAjax {
	
	private static String BASE_URL="https://search.jd.com/Search";
	@Autowired
	private SpiderService spiderService;
	
	@RequestMapping("saveJd.do")
	@ResponseBody
	public ModelMap saveJd(){
		ModelMap modelMap=new ModelMap();
		System.out.println("----------开始爬虫----------"); 
		Date startDate = new Date(); 
		// 使用现线程池提交任务 
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		//引入countDownLatch进行线程同步，使主线程等待线程池的所有任务结束，便于计时 
		CountDownLatch countDownLatch = new CountDownLatch(100);
		for(int i=0;i<50;i++){
			Map<String, String> params=new HashMap<String, String>();
			params.put("keyword", "手机");
			params.put("enc", "utf-8");
			params.put("wc", "手机");
			params.put("page", i+"");
			executorService.submit(new Runnable() {
				public void run() {
					spiderService.saveJd(BASE_URL, params);
					countDownLatch.countDown();
				}
			});
		}
		try {
			countDownLatch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		executorService.shutdown();
		Date endDate=new Date();
		System.out.println("----------爬虫结束----------");
		System.out.println("耗时:"+(endDate.getTime()-startDate.getTime())+"ms");
		return modelMap;
	}
}
