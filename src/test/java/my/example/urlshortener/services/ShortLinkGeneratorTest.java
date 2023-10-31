package my.example.urlshortener.services;

import my.example.urlshortener.exceptions.AppRuntimeException;
import my.example.urlshortener.model.OriginalUrl;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShortLinkGeneratorTest {

    @Mock
    URLValidator urlValidator;
    @InjectMocks
    ShortLinkGenerator shortLinkGenerator;

    private static final String EXPECTED_MESSAGE = "Invalid string for url-shortener";

    @Test
    @DisplayName("Returns generated short url")
    void generate_shouldReturnGeneratedUrl_whenUrlIsValid(){
        var url = "ya.ru";
        when(urlValidator.validateUrl(anyString())).thenReturn(true);
        var generated = shortLinkGenerator.generate(new OriginalUrl(url));

        Assertions.assertEquals("l/", generated.substring(0, 2));
        Assertions.assertEquals(10, generated.substring(2).length());
    }

    @Test
    @DisplayName("Check exception when url is invalid")
    void generate_shouldThrowException_whenUrlIsInvalid(){
        when(urlValidator.validateUrl(anyString())).thenReturn(false);
        var exception = Assert.assertThrows(AppRuntimeException.class,
                () -> shortLinkGenerator.generate(new OriginalUrl("some-string-for-test")) );

        Assertions.assertEquals(EXPECTED_MESSAGE, exception.getMessage());
    }

    @Test
    @DisplayName("Check exception when url is empty")
    void generate_shouldThrowException_whenOriginalIsEmpty(){
        var exception = Assert.assertThrows(AppRuntimeException.class,
                () -> shortLinkGenerator.generate(new OriginalUrl()));

        Assertions.assertEquals(EXPECTED_MESSAGE, exception.getMessage());

    }

}