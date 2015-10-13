package com.sale.entity.message.request;

/**
 * 语音消息
 * 
 * @author fengxiaoming
 * 
 */
public class RequestVoiceMessage extends RequestMessage {
	private String MediaId;
	private String Format;
	private String Recognition;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

}
