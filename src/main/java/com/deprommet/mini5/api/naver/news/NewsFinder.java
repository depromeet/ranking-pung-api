package com.deprommet.mini5.api.naver.news;

public interface NewsFinder {
	KeywordNews findByKeyword(String keyword) throws Exception;
}
