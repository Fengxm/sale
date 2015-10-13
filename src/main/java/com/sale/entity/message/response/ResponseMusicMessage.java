package com.sale.entity.message.response;

import com.sale.entity.message.Music;

/**
 * 回复音乐消息
 * 
 * @author fengxiaoming
 * 
 */
public class ResponseMusicMessage extends ResponseMessage {
	private Music music;

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

}
