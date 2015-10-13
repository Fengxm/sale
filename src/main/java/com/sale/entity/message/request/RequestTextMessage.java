package com.sale.entity.message.request;

import java.util.Map;

/**
 * 文本消息
 * 
 * @author fengxiaoming
 * 
 */
public class RequestTextMessage extends RequestMessage {
	private String Content;

	public RequestTextMessage(Map<String, String> reqMap) {
		this.ToUserName = reqMap.get("ToUserName");
		this.FromUserName = reqMap.get("FromUserName");
		this.CreateTime = Long.valueOf(reqMap.get("CreateTime"));
		this.MsgType = reqMap.get("MsgType");
		this.Content = reqMap.get("Content");
		this.MsgId = Long.valueOf(reqMap.get("MsgId"));
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
