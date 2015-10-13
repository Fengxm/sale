package com.sale.entity.message.request;

import com.sale.entity.message.Message;

/**
 * 接收消息
 * 
 * @author fengxiaoming
 * 
 */
public class RequestMessage extends Message {
	protected long MsgId;

	public long getMsgId() {
		return MsgId;
	}

	public void setMsgId(long msgId) {
		MsgId = msgId;
	}
}
