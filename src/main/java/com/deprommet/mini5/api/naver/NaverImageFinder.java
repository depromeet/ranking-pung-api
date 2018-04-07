package com.deprommet.mini5.api.naver;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;

@Service
public class NaverImageFinder {
	public NaverImage findImageUrlByKeywrod(String keyword) throws IOException {
		final Document imgDoucment = Jsoup.connect(
			"https://search.naver.com/search.naver?where=image&sm=tab_jum&query=" + URLEncoder.encode(keyword, "UTF-8"))
			.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
			.get();

		final Elements imgElements = imgDoucment.select(".thumb > ._img");
		final String imgUrl = imgElements.get(0).attr("data-source");
		final NaverImage naverImage = new NaverImage();
		naverImage.setImageUrl(imgUrl);
		return naverImage;
	}
}
