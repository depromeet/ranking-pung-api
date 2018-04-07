package com.deprommet.mini5.api.naver;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;

@Service
public class NaverImageFinder {
	private static final String NAVER_SEARCH_IMAGE_POSTFIX_URL = "https://search.naver.com/search.naver?where=image&sm=tab_jum&query=";
	private static final String DUMMY_USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36";

	public KeywordImage findImageUrlByKeyword(String keyword) throws IOException {
		final Document imgDocument = Jsoup.connect(
			NAVER_SEARCH_IMAGE_POSTFIX_URL + URLEncoder.encode(keyword, "UTF-8"))
			.userAgent(DUMMY_USER_AGENT)
			.get();

		final Elements imgElements = imgDocument.select(".thumb > ._img");
		final String imgUrl = imgElements.get(0).attr("data-source");
		final KeywordImage keywordImage = new KeywordImage();
		keywordImage.setImageUrl(imgUrl);
		return keywordImage;
	}
}
