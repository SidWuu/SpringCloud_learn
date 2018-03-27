package spiderjd.vo;

public class SpiderGoodsInfo {
	private Long dbid;
	private String goodsId;
	private String goodsName;
	private String imgUrl;
	private String goodsPrice;
	
	public Long getDbid() {
		return dbid;
	}
	public void setDbid(Long dbid) {
		this.dbid = dbid;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	
}
