package com.sale.entity.message.response;

/**
 * 回复文本消息
 * 
 * @author fengxiaoming
 * 
 */
public class ResponseTextMessage extends ResponseMessage {
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
