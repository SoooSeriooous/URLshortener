package my.example.app.url_shortener.controllers;

import lombok.AllArgsConstructor;
import my.example.app.exceptions.AppRuntimeException;
import my.example.app.url_shortener.model.OriginalUrl;
import my.example.app.url_shortener.model.ShortenedUrl;
import my.example.app.url_shortener.services.ShortLinkGenerator;
import my.example.app.url_shortener.services.ShortenedLinkConverter;
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
