package com.deprommet.mini5.api.naver;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class NaverRealtimeRankFinder {
	private static final String NAVER_URL = "https://www.naver.com";
	private static final String SELECT_RANK = ".ah_k";

	public List<String> findRankKeyword() throws IOException {
		final Document document = Jsoup.connect(NAVER_URL).get();

		if (Objects.isNull(document)) {
			return Collections.emptyList();
		}

		final Elements elements = document.select(SELECT_RANK);
		final List<String> keywordList = new ArrayList<>();
		for (Element element : elements) {
			keywordList.add(element.html());
		}

		return keywordList;
	}
}
