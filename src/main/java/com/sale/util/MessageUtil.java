package com.sale.util;

import java.util.Date;

import com.sale.entity.RequestTextMessage;
import com.sale.entity.ResponseTextMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *
 * @author fengxiaoming
 * 
 */
public class MessageUtil {
	
	public static final String DEFAULT_ENCODING = "utf-8";
	public static final String DEFAULT_CONTENT_TYPE = "application/xml";
	public static final String ROOT_ELEMENT = "xml";
	public static final String MESSAGE_TEXT = "text";
	
	// 获取推送文本消息
	public static RequestTextMessage getRequestTextMessage(String xml) {

		XStream xstream = new XStream(new DomDriver());

		xstream.alias(ROOT_ELEMENT, RequestTextMessage.class);
		xstream.aliasField("ToUserName", RequestTextMessage.class, "ToUserName");
		xstream.aliasField("FromUserName", RequestTextMessage.class,
				"FromUserName");
		xstream.aliasField("CreateTime", RequestTextMessage.class, "CreateTime");
		xstream.aliasField("MsgType", RequestTextMessage.class, "MsgType");
		xstream.aliasField("Content", RequestTextMessage.class, "Content");
		xstream.aliasField("MsgId", RequestTextMessage.class, "MsgId");

		RequestTextMessage requestTextMessage = (RequestTextMessage) xstream
				.fromXML(xml);
		return requestTextMessage;
	}

	// 回复文本消息
	public static String getResponseTextMessage(ResponseTextMessage respMsg) {
		XStream xstream = new XStream(new DomDriver());
		xstream.alias(ROOT_ELEMENT, ResponseTextMessage.class);
		String xml = xstream.toXML(respMsg);
		return xml;
	}
}
