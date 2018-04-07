package com.deprommet.mini5.api.api.rank;

import com.deprommet.mini5.api.naver.NaverRankFinder;
import com.deprommet.mini5.api.naver.SearchKeyword;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin("*")
public class RankController {
	private Logger log = LoggerFactory.getLogger(RankController.class);

	@Autowired
	private NaverRankFinder naverRankFinder;

	@GetMapping("/rank/naver")
	public List<SearchKeyword> getRankFromNaver() {
		try {
			return naverRankFinder.findRankKeyword();

		} catch (IOException e) {
			log.warn("Can not find to get nave rank");
			return Collections.emptyList();
		}
	}
}
