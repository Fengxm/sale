package com.sale.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/xml");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		/*Scanner scanner = new Scanner(req.getInputStream());
		StringBuffer sb = new StringBuffer(100);
		while (scanner.hasNextLine()) {
			sb.append(scanner.nextLine());

		}
		System.out.println(sb);*/
		
		/*try {
			Map<String, String> map = RequestXML2Map.parseXml(req);
			System.out.println(map.toString());
			String content = map.get("Content");
			System.out.println(content);
			if("d".equals(content)){
				long time = System.currentTimeMillis();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String date = dateFormat.format(time);
				out.print("今天是：" + date);
			}else{
				out.print("Hello World!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
		}*/
		String reqXml = IOUtils.toString(req.getInputStream(),"utf-8");
		RequestTextMessage rtm = MessageUtil.getRequestTextMessage(reqXml);
		String content = rtm.getContent();
		ResponseTextMessage respMsg = new ResponseTextMessage();
		if("d".equals(content)){
			long time = System.currentTimeMillis();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String date = dateFormat.format(time);
			respMsg.setContent("今天是：" + date);
			out.print(MessageUtil.getResponseTextMessage(respMsg));
		}else{
			respMsg.setContent("Hello World!");
			out.print(MessageUtil.getResponseTextMessage(respMsg));
		}
	}

}
