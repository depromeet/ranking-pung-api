package com.deprommet.mini5.api.naver.image.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NaverImageDto {
	private List<NaverImageItem> items;

	public List<NaverImageItem> getItems() {
		return items;
	}

	public void setItems(List<NaverImageItem> items) {
		this.items = items;
	}
}
