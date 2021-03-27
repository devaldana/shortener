package com.bluecoding.shortener;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrlShortenerHelperTest {

    @Test
    void encode() {
        var expectedShortUrl = UrlShortenerHelper.encode(0);
        Assertions.assertThat(expectedShortUrl).isEqualTo("a");

        expectedShortUrl = UrlShortenerHelper.encode(1);
        Assertions.assertThat(expectedShortUrl).isEqualTo("b");

        expectedShortUrl = UrlShortenerHelper.encode(2);
        Assertions.assertThat(expectedShortUrl).isEqualTo("c");
    }

    @Test
    void decode() {
    }
}