package my.example.app.url_shortener.repositories;

import my.example.app.url_shortener.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Long> {
}