package com.sale.entity.message.response;

import com.sale.entity.message.Voice;

/**
 * 回复语音消息
 * 
 * @author fengxiaoming
 * 
 */
public class ResponseVoiceMessage extends ResponseMessage {
	private Voice voice;

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

}
