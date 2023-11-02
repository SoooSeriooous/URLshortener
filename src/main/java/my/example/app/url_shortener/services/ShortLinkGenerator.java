package my.example.app.url_shortener.services;

import lombok.AllArgsConstructor;
import my.example.app.exceptions.AppRuntimeException;
import my.example.app.url_shortener.entities.Url;
import my.example.app.url_shortener.model.OriginalUrl;
import my.example.app.url_shortener.repositories.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ShortLinkGenerator {

    private UrlRepository urlRepository;
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
            shortenedUrl = UUID.randomUUID().toString().replace("-", "").substring(starIndex, endIndex);
            saveUrls(optOriginal.get().toLowerCase(), shortenedUrl);
        } else {
            throw new AppRuntimeException("Invalid string for url-shortener");
        }
        return "l/" + shortenedUrl;
    }

    private void saveUrls(String originalUrl, String shortenedUrl) {
        var url = new Url();
        url.setUrl(originalUrl);
        url.setShortUrl(shortenedUrl);

        urlRepository.save(url);
    }
}
