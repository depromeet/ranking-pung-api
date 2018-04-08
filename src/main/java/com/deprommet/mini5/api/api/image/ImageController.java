package com.deprommet.mini5.api.api.image;

import com.deprommet.mini5.api.naver.KeywordImage;
import com.deprommet.mini5.api.naver.NaverImageFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ImageController {
    @Autowired
    private NaverImageFinder naverImageFinder;

    @GetMapping("/image/naver/{keyword}")
    public KeywordImage findByKeyword(@PathVariable String keyword) throws IOException {
        return naverImageFinder.findImageUrlByKeyword(keyword);
    }
}
