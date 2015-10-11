package com.sale.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.sale.entity.RequestTextMessage;
import com.sale.entity.ResponseTextMessage;
import com.sale.util.MessageUtil;
import com.sale.util.SignUtil;

/**
 *
 * @author fengxiaoming
 * 
 */
public class CoreServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 微信加密签名
		String signature = req.getParameter("signature");
		// 时间戳
		String timestamp = req.getParameter("timestamp");
		// 随机数
		String nonce = req.getParameter("nonce");
		// 随机字符串
		String echostr = req.getParameter("echostr");
		PrintWriter out = resp.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
		out.close();
		out = null;

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(MessageUtil.DEFAULT_ENCODING);
		resp.setCharacterEncoding(MessageUtil.DEFAULT_ENCODING);
		resp.setContentType(MessageUtil.DEFAULT_CONTENT_TYPE);

		PrintWriter out = resp.getWriter();
		String reqXml = IOUtils.toString(req.getInputStream(), MessageUtil.DEFAULT_ENCODING);
		RequestTextMessage reqRtm = MessageUtil.getRequestTextMessage(reqXml);
		ResponseTextMessage respMsg = new ResponseTextMessage();
		String msg = "您输入的消息是" + reqRtm.getContent();
		if (MessageUtil.MESSAGE_TEXT.equals(reqRtm.getMsgType())) {
			respMsg.setToUserName(reqRtm.getFromUserName());
			respMsg.setFromUserName(reqRtm.getToUserName());
			respMsg.setMsgType(MessageUtil.MESSAGE_TEXT);
			respMsg.setCreateTime(String.valueOf(new Date().getTime()));
			respMsg.setContent(msg);
			String msgXml = MessageUtil.getResponseTextMessage(respMsg);
			System.out.println(msgXml);
			out.print(msgXml);
		}
		out.close();
	}

}
