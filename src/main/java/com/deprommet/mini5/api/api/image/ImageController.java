package com.deprommet.mini5.api.api.image;

import com.deprommet.mini5.api.naver.image.ImageFinder;
import com.deprommet.mini5.api.naver.image.KeywordImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ImageController {
	@Autowired
	@Qualifier("naverApiImageFinder")
	private ImageFinder imageFinder;

	@GetMapping("/image/naver/{keyword}")
	public KeywordImage getImageUrl(@PathVariable String keyword) throws Exception {
		return imageFinder.findByKeyword(keyword);
	}
}
