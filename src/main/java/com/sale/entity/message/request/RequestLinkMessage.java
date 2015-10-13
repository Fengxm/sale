package com.sale.entity.message.request;

/**
 * 链接消息
 * 
 * @author fengxiaoming
 * 
 */
public class RequestLinkMessage extends RequestMessage {
	private String Title;
	private String Description;
	private String Url;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

}
