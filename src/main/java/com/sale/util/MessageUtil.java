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
	// 获取推送文本消息
	public static RequestTextMessage getRequestTextMessage(String xml) {

		XStream xstream = new XStream(new DomDriver());

		xstream.alias("xml", RequestTextMessage.class);
		xstream.aliasField("ToUserName", RequestTextMessage.class, "toUserName");
		xstream.aliasField("FromUserName", RequestTextMessage.class,
				"fromUserName");
		xstream.aliasField("CreateTime", RequestTextMessage.class, "createTime");
		xstream.aliasField("MsgType", RequestTextMessage.class, "messageType");
		xstream.aliasField("Content", RequestTextMessage.class, "content");
		xstream.aliasField("MsgId", RequestTextMessage.class, "msgId");

		RequestTextMessage requestTextMessage = (RequestTextMessage) xstream
				.fromXML(xml);
		return requestTextMessage;
	}

	// 回复文本消息
	public static String getResponseTextMessage(ResponseTextMessage respMsg) {

		ResponseTextMessage we = new ResponseTextMessage();
		we.setMessageType("text");
		we.setCreateTime(new Long(new Date().getTime()).toString());
		we.setContent(respMsg.getContent());
		we.setToUserName(respMsg.getToUserName());
		we.setFromUserName(respMsg.getFromUserName());
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("xml", ResponseTextMessage.class);
		xstream.aliasField("ToUserName", ResponseTextMessage.class, "toUserName");
		xstream.aliasField("FromUserName", ResponseTextMessage.class,
				"fromUserName");
		xstream.aliasField("CreateTime", ResponseTextMessage.class, "createTime");
		xstream.aliasField("MsgType", ResponseTextMessage.class, "messageType");
		xstream.aliasField("Content", ResponseTextMessage.class, "content");
//		xstream.aliasField("FuncFlag", ResponseTextMessage.class, "funcFlag");
		String xml = xstream.toXML(we);
		return xml;
	}
}
