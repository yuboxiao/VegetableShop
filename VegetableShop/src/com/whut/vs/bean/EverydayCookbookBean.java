package com.whut.vs.bean;

/*** 
 * @author xiongbin
 * @date 2016-3-18
 * @description 每日菜谱实体类
 */
public class EverydayCookbookBean {

	private String cookbookImageUrl;
	private String cookbookName;
	private String cookbookWeight;
	private String cookbookPrice;
	
	
	/***
	 * getter 和  setter 方法区
	 */
	public String getCookbookImageUrl() {
		return cookbookImageUrl;
	}
	public void setCookbookImageUrl(String cookbookImageUrl) {
		this.cookbookImageUrl = cookbookImageUrl;
	}
	public String getCookbookName() {
		return cookbookName;
	}
	public void setCookbookName(String cookbookName) {
		this.cookbookName = cookbookName;
	}
	public String getCookbookWeight() {
		return cookbookWeight;
	}
	public void setCookbookWeight(String cookbookWeight) {
		this.cookbookWeight = cookbookWeight;
	}
	public String getCookbookPrice() {
		return cookbookPrice;
	}
	public void setCookbookPrice(String cookbookPrice) {
		this.cookbookPrice = cookbookPrice;
	}
	
}
