package com.sale.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

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
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_SHROT_VIDEO = "shortvideo";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_LINK = "link";
	
	
	
	
	/**
	 * 解析xml到map中
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,String> parseXml(HttpServletRequest request) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		// 从request中取得输入流
		StringBuffer sb = new StringBuffer();
		InputStream is = request.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String s = "";
		while ((s = br.readLine()) != null) {
			sb.append(s);
		}
		String xml = sb.toString();

		// 读取输入流
		Document document = null;
		try {
			document = DocumentHelper.parseText(xml);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
		// 得到xml根元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		List<Element> elementList = root.elements();
		// 遍历所有子节点
		for (Element e : elementList) {
			// 对于CDATA区域内的内容，XML解析程序不会处理，而是直接原封不动的输出。
			map.put(e.getName(), e.getText());
		}
		return map;
	}
	
	
	/**
	 * 将实体类转换成xml
	 * @param obj
	 * @param cls
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static <T> String getMessageXml(Object obj,Class<T> cls) throws InstantiationException, IllegalAccessException{
		XStream xstream = new XStream(new DomDriver());
		xstream.alias(ROOT_ELEMENT, cls);
		String xml = xstream.toXML(obj);
		return xml;
	}
	
}
