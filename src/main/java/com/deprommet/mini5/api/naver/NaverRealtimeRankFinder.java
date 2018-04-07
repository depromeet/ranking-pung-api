package com.deprommet.mini5.api.naver;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class NaverRealtimeRankFinder {
	private static final String NAVER_URL = "https://www.naver.com";
	private static final String SELECT_RANK = ".ah_k";

	public List<SearchKeyword> findRankKeyword() throws IOException {
		final Document rankKeyword = Jsoup.connect(NAVER_URL).get();

		if (Objects.isNull(rankKeyword)) {
			return Collections.emptyList();
		}

		final Elements elements = rankKeyword.select(SELECT_RANK);
		final List<SearchKeyword> searchKeywordList = new ArrayList<>();

		for (Element element : elements) {
			final String keyword = element.html();
			final Document imgDoucment = Jsoup.connect(
				"https://search.naver.com/search.naver?where=image&sm=tab_jum&query=" + URLEncoder.encode(keyword, "UTF-8"))
				.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
				.get();
			final Elements imgElements = imgDoucment.select(".thumb > ._img");
			final String imgUrl = imgElements.get(0).attr("data-source");
			final SearchKeyword searchKeyword = new SearchKeyword();
			searchKeyword.setKeyword(keyword);
			searchKeyword.setImgUrl(imgUrl);
			searchKeywordList.add(searchKeyword);
		}

		return searchKeywordList;
	}
}
