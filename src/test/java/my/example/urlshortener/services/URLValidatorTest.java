package my.example.urlshortener.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class URLValidatorTest {

    @Test
    @DisplayName("Valid url test")
    void validateUrl_shouldReturnTrue_whenUrlIsValid() {
        var validUrlList = List.of(
                "www.ya.ru",
                "ya.ru",
                "http://ya.ru",
                "https://www.ya.ru",
                "http://api.test.me",
                "https://google.us.edi?34535/534534?dfg=g&fg",
                "gskinner.com/products/spl",
                "http://RegExr.com?2rjl6"
        );
        URLValidator urlValidator = new URLValidator();

        assertTrue(urlValidator.validateUrl(validUrlList.get(0)));
        assertTrue(urlValidator.validateUrl(validUrlList.get(1)));
        assertTrue(urlValidator.validateUrl(validUrlList.get(2)));
        assertTrue(urlValidator.validateUrl(validUrlList.get(3)));
        assertTrue(urlValidator.validateUrl(validUrlList.get(4)));
        assertTrue(urlValidator.validateUrl(validUrlList.get(5)));
        assertTrue(urlValidator.validateUrl(validUrlList.get(6)));
        assertTrue(urlValidator.validateUrl(validUrlList.get(7)));
    }

    @Test
    @DisplayName("Invalid url test")
    void validateUrl_shouldReturnFalse_whenUrlIsNotValid() {
        var stringList = List.of(
                "some-string-for-test",
                "some string for test",
                "Some-string/for/test."
        );
        URLValidator urlValidator = new URLValidator();

        assertFalse(urlValidator.validateUrl(stringList.get(0)));
        assertFalse(urlValidator.validateUrl(stringList.get(1)));
        assertFalse(urlValidator.validateUrl(stringList.get(2)));
    }
}