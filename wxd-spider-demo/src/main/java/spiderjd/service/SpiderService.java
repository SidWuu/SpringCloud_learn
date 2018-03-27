package spiderjd.service;

import java.util.Map;

public interface SpiderService {
	/**
	 * 京东爬虫
	 * @param url
	 * @param params
	 */
	public void saveJd(String url, Map<String,String> params);
}
