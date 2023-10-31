package my.example.urlshortener.services;

import my.example.urlshortener.model.ShortenedUrl;
import org.springframework.stereotype.Service;

@Service
public class ShortenedLinkConverter {
    public ShortenedUrl convertToShortenedUrl(String stringUrl){
        return new ShortenedUrl(stringUrl);
    }
}
