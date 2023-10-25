package my.example.urlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestUrLshortenerApplication {

    public static void main(String[] args) {
        SpringApplication.from(UrLshortenerApplication::main).with(TestUrLshortenerApplication.class).run(args);
    }

}
