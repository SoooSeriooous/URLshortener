package my.example.urlshortener.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class URLValidator {
    private static final String URL_VALIDATION_REGEX =
            "[(http(s)?)://(www.)?a-zA-Z0-9@:%._+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_+.~#?&//=]*)";

    /**
     * Check if the passed string is matched to the correct URL format
     * @param stringUrl string to validate
     * @return true - passed string matches format, false - passed string doesn't match.
     */
    public boolean validateUrl(String stringUrl){
        return stringUrl.matches(URL_VALIDATION_REGEX);
    }
}
