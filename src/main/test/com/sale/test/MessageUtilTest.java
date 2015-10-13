package com.sale.test;

import org.junit.Test;

import com.sale.entity.message.Message;
import com.sale.util.MessageUtil;

/**
 *
 * @author fengxiaoming
 * 
 */
public class MessageUtilTest {

	@Test
	public void testGetMessageXml() {
		Message msg = new Message();
		msg.setCreateTime(11111000);
		msg.setFromUserName("a");
		msg.setMsgType(MessageUtil.MESSAGE_TEXT);
		msg.setToUserName("b");
		try {
			System.out.println(MessageUtil.getMessageXml(msg, Message.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
