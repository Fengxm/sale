package com.sale.entity.message.response;

import com.sale.entity.message.Video;

/**
 * 回复视频消息
 * 
 * @author fengxiaoming
 * 
 */
public class ResponseVideoMessage extends ResponseMessage {
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}
