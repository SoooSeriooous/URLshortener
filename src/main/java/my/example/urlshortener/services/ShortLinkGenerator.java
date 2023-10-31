package my.example.urlshortener.services;

import lombok.AllArgsConstructor;
import my.example.urlshortener.exceptions.AppRuntimeException;
import my.example.urlshortener.model.OriginalUrl;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ShortLinkGenerator {

    private URLValidator urlValidator;

    /**
     * Short url generator
     *
     * @param original container from the user's request for original url
     * @return string of shorten url
     */
    public String generate(OriginalUrl original) {
        var shortenedUrl = "";
        var optOriginal = Optional.ofNullable(original.getOriginal());
        if(optOriginal.isPresent() && urlValidator.validateUrl(optOriginal.get().toLowerCase())) {
            var starIndex = 0;
            var endIndex = 10;
            shortenedUrl = "l/" + UUID.randomUUID().toString().replace("-", "").substring(starIndex, endIndex);

        } else {
            throw new AppRuntimeException("Invalid string for url-shortener");
        }
        return shortenedUrl;
    }
}
