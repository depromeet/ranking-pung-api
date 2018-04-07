package com.deprommet.mini5.api.api.rank;

import com.deprommet.mini5.api.naver.NaverImage;
import com.deprommet.mini5.api.naver.NaverImageFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin("*")
public class ImageController {
	private Logger log = LoggerFactory.getLogger(RankController.class);

	@Autowired
	private NaverImageFinder naverImageFinder;

	@GetMapping("/image/naver/{keyword}")
	public NaverImage getImageUrl(@PathVariable String keyword) {
		try {
			return naverImageFinder.findImageUrlByKeywrod(keyword);
		} catch (IOException e) {
			NaverImage emptyImage = new NaverImage();
			emptyImage.setImageUrl("");
			return emptyImage;
		}
	}
}
