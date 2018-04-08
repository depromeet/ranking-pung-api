package com.deprommet.mini5.api.naver.news;

import com.deprommet.mini5.api.naver.news.message.NaverNewsDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;

@Service
public class NaverApiNewsFinder implements NewsFinder {
	@Value("${naver.client.id}")
	private String clientId;

	@Value("${naver.client.secret}")
	private String secretId;

	private static final String NAVER_NEWS_URL = "https://openapi.naver.com/v1/search/news.json";
	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public KeywordNews findByKeyword(String keyword) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("X-Naver-Client-Id", clientId);
		headers.set("X-Naver-Client-Secret", secretId);

		HttpEntity<String> entity = new HttpEntity<>(headers);

		URI uri = UriComponentsBuilder.fromUriString(NAVER_NEWS_URL)
			.queryParam("query", keyword)
			.queryParam("display", "1")
			.build()
			.encode()
			.toUri();

		ResponseEntity<NaverNewsDto> respEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, NaverNewsDto.class);
		NaverNewsDto naverNewsDto = respEntity.getBody();

		KeywordNews keywordNews = new KeywordNews();
		keywordNews.setTitle(naverNewsDto.getItems().get(0).getTitle());
		keywordNews.setContent(naverNewsDto.getItems().get(0).getDescription());
		keywordNews.setNewsUrl(naverNewsDto.getItems().get(0).getLink());
		return keywordNews;
	}
}
