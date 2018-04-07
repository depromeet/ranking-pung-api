package com.deprommet.mini5.api.api.news;

import com.deprommet.mini5.api.naver.KeywordNews;
import com.deprommet.mini5.api.naver.NaverNewsFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin("*")
public class NewsController {
	@Autowired
	private NaverNewsFinder naverNewsFinder;

	@GetMapping("/news/naver/{keyword}")
	public KeywordNews findByKeyword(@PathVariable String keyword) throws IOException {
		return naverNewsFinder.findNewsByKeyword(keyword);
	}
}
