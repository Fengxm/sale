package com.sale.entity.message.request;

/**
 * 小视频消息
 * 
 * @author fengxiaoming
 * 
 */
public class RequestShortVideoMessage extends RequestMessage {
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
