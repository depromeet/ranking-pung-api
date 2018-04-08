package com.deprommet.mini5.api.naver.image;

import com.deprommet.mini5.api.naver.image.message.NaverImageDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;

@Service
public class NaverApiImageFinder implements ImageFinder {
	@Value("${naver.client.id}")
	private String clientId;

	@Value("${naver.client.secret}")
	private String secretId;

	private static final String NAVER_IMAGE_URL = "https://openapi.naver.com/v1/search/image";
	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public KeywordImage findByKeyword(String keyword) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("X-Naver-Client-Id", clientId);
		headers.set("X-Naver-Client-Secret", secretId);

		HttpEntity<String> entity = new HttpEntity<>(headers);
		URI uri = UriComponentsBuilder.fromUriString(NAVER_IMAGE_URL)
			.queryParam("query", keyword)
			.queryParam("display", "1")
			.build()
			.encode()
			.toUri();

		ResponseEntity<NaverImageDto> respEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, NaverImageDto.class);
		NaverImageDto naverNewsDto = respEntity.getBody();

		KeywordImage keywordImage = new KeywordImage();
		keywordImage.setImageUrl(naverNewsDto.getItems().get(0).getLink());
		return keywordImage;
	}

}
