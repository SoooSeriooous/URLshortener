package my.example.app.url_shortener.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class ShortenedUrl {
    private String link;
}
