package com.sale.entity.message.response;

import com.sale.entity.message.Image;

/**
 * 回复图片消息
 * 
 * @author fengxiaoming
 * 
 */
public class ResponseImageMessage extends ResponseMessage {
	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
