package com.bluecoding.shortener;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class UrlShortenerService {

    private final UrlRepository urlRepository;

    public String shortUrl(final String url) {
        return urlRepository.findByUrl(url)
                            .map(found -> UrlShortenerHelper.encode(found.getId()))
                            .orElse(this.persisUrl(url));
    }

    private String persisUrl(final String url) {
        final var newUrl = new Url();
        newUrl.setUrl(url);
        final var id = this.urlRepository.save(newUrl).getId();
        return UrlShortenerHelper.encode(id);
    }

    public Url longUrl(final String shortUrl) {
        final var id = UrlShortenerHelper.decode(shortUrl);
        return urlRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Url not found"));
    }
}
