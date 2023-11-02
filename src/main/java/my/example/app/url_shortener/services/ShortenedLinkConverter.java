package my.example.app.url_shortener.services;

import my.example.app.url_shortener.model.ShortenedUrl;
import org.springframework.stereotype.Service;

@Service
public class ShortenedLinkConverter {
    public ShortenedUrl convertToShortenedUrl(String stringUrl){
        return new ShortenedUrl(stringUrl);
    }
}
