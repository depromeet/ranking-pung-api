package com.deprommet.mini5.api.api.rank;

import com.deprommet.mini5.api.naver.NaverRealtimeRankFinder;
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
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class RankController {
	private Logger log = LoggerFactory.getLogger(RankController.class);

	@Autowired
	private NaverRealtimeRankFinder naverRealtimeRankFinder;

	@GetMapping("/rank/naver")
	public List<SearchKeyword> getRankFromNaver() {
		try {
			return naverRealtimeRankFinder.findRankKeyword()
				.stream()
				.limit(20)
				.collect(Collectors.toList());

		} catch (IOException e) {
			log.warn("Can not find to get nave rank");
			return Collections.emptyList();
		}
	}
}
