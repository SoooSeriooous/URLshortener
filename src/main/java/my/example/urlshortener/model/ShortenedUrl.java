package my.example.urlshortener.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class ShortenedUrl {
    private String link;
}
