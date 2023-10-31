package my.example.urlshortener.controllers;

import lombok.AllArgsConstructor;
import my.example.urlshortener.exceptions.AppRuntimeException;
import my.example.urlshortener.model.OriginalUrl;
import my.example.urlshortener.model.ShortenedUrl;
import my.example.urlshortener.services.ShortLinkGenerator;
import my.example.urlshortener.services.ShortenedLinkConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ShortLinkGeneratorController {

    private ShortLinkGenerator shortLinkGenerator;
    private ShortenedLinkConverter shortenedLinkConverter;

    @PostMapping("/generate")
    ResponseEntity<ShortenedUrl> generate(@RequestBody OriginalUrl original) throws AppRuntimeException {
        String link = shortLinkGenerator.generate(original);
        return ResponseEntity.ok(shortenedLinkConverter.convertToShortenedUrl(link));
    }
}
