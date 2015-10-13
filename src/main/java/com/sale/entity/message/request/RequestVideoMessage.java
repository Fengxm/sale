package com.sale.entity.message.request;

/**
 * 视频消息
 * 
 * @author fengxiaoming
 * 
 */
public class RequestVideoMessage extends RequestMessage {
	private String MediaId;
	private String ThumbMediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

}
