package com.deprommet.mini5.api.api;

import com.deprommet.mini5.api.naver.NaverRealtimeRankFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
public class RankController {
	private Logger log = LoggerFactory.getLogger(RankController.class);

	@Autowired
	private NaverRealtimeRankFinder naverRealtimeRankFinder;

	@RequestMapping("/rank/naver")
	public List<String> getRankFromNaver() {
		try {
			return naverRealtimeRankFinder.findRankKeyword();
		} catch (IOException e) {
			log.warn("Can not find to get nave rank");
			return Collections.emptyList();
		}
	}
}
