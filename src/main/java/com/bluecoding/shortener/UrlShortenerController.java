package com.bluecoding.shortener;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("urls")
public class UrlShortenerController {

    private final UrlShortenerService shortenerService;

    @PostMapping
    public String shortUrl(@RequestBody String url) {
        return this.shortenerService.shortUrl(url);
    }

    @GetMapping
    public Url getLongUrl(@RequestParam("shortUrl") String url) {
        return this.shortenerService.longUrl(url);
    }
}
