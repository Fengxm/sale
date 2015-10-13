package com.sale.entity.message.request;

/**
 * 图片消息
 * 
 * @author fengxiaoming
 * 
 */
public class RequestImageMessage extends RequestMessage {
	private String PicUrl;
	private String MediaId;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
