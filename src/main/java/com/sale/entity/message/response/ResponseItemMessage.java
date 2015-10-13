package com.sale.entity.message.response;

import java.util.List;

import com.sale.entity.message.Item;

/**
 * 回复图文消息
 * 
 * @author fengxiaoming
 * 
 */
public class ResponseItemMessage extends ResponseMessage {
	private List<Item> list;

	public List<Item> getList() {
		return list;
	}

	public void setList(List<Item> list) {
		this.list = list;
	}

}
