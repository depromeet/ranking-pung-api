package com.deprommet.mini5.api.naver;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;

@Service
public class NaverNewsFinder {
	private static final String NAVER_NEWS_POSTFIX_URL = "https://search.naver.com/search.naver?where=news&sm=tab_jum&query=";
	private static final String DUMMY_USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36";

	public KeywordNews findNewsByKeyword(String keyword) throws IOException {
		final String newsUrl = NAVER_NEWS_POSTFIX_URL + URLEncoder.encode(keyword, "UTF-8");
		final Document newsDocument = Jsoup.connect(newsUrl)
			.userAgent(DUMMY_USER_AGENT)
			.get();

		final Elements titleElements = newsDocument.select("a._sp_each_title");
		final Elements contentElements = newsDocument.select("#sp_nws1 > dl > dd:nth-child(3)");

		final String title = titleElements.get(0).attr("title");
		final String content = contentElements.get(0).html()
			.replaceAll("<strong class=\"hl\">", "")
			.replaceAll("</strong>", "")
			.replaceAll("캡처&copy;", "")
			.replaceAll("\n", "")
			.replaceAll(" &nbsp;", "")
			.replaceAll(";&quot;", "")
			.replaceAll("&nbsp", "");

		final KeywordNews keywordNews = new KeywordNews();
		keywordNews.setTitle(title);
		keywordNews.setContent(content);
		keywordNews.setNewsUrl(newsUrl);
		return keywordNews;
	}
}
