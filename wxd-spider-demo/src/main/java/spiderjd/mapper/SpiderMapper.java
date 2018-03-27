package spiderjd.mapper;

import java.util.List;

import spiderjd.vo.SpiderGoodsInfo;

public interface SpiderMapper {
	public List<SpiderGoodsInfo> queryAll();
	public void insert(SpiderGoodsInfo mod);
	public void delete(Long dbid);
}
