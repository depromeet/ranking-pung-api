package com.deprommet.mini5.api.dto;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;

public class BoardItem {

	@ApiModelProperty(required = true)
	private String content;
	@ApiModelProperty(required = true)
	private String keyWord;
	@ApiModelProperty(required = true)
	private String nickname;

	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "BoardItem [content=" + content + ", keyWord=" + keyWord + ", nickname=" + nickname + "]";
	}

}
