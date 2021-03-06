package com.deprommet.mini5.api.naver.rank;

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
import java.util.stream.Collectors;

@Service
public class NaverRankFinder {
	private static final String NAVER_URL = "https://www.naver.com";
	private static final String SELECT_RANK = ".ah_k";

	public List<RankKeyword> findRankKeyword() throws IOException {
		final Document rankKeyword = Jsoup.connect(NAVER_URL).get();

		if (Objects.isNull(rankKeyword)) {
			return Collections.emptyList();
		}

		final Elements elements = rankKeyword.select(SELECT_RANK);
		final List<RankKeyword> rankKeywordList = new ArrayList<>();

		for (Element element : elements) {
			final String keyword = element.html();
			final RankKeyword searchKeyword = new RankKeyword();
			searchKeyword.setKeyword(keyword);
			rankKeywordList.add(searchKeyword);
		}

		return rankKeywordList.stream()
			.limit(20) // 중복으로 40개가 나오기 때문에 20까지의 limit를 추가한다.
			.collect(Collectors.toList());
	}
}
