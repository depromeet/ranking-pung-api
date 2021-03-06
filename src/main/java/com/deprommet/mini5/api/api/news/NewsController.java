package com.deprommet.mini5.api.api.news;

import com.deprommet.mini5.api.naver.news.KeywordNews;
import com.deprommet.mini5.api.naver.news.NewsFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class NewsController {
	@Autowired
	@Qualifier("naverApiNewsFinder")
	private NewsFinder newsFinder;

	@GetMapping("/news/naver/{keyword}")
	public KeywordNews findByKeyword(@PathVariable String keyword) throws Exception {
		return newsFinder.findByKeyword(keyword);
	}
}
