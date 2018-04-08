package com.deprommet.mini5.api.naver.news.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NaverNewsDto {
	private List<NaverNewsItem> items;

	public List<NaverNewsItem> getItems() {
		return items;
	}

	public void setItems(List<NaverNewsItem> items) {
		this.items = items;
	}
}
