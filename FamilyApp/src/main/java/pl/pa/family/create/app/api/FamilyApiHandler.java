package pl.pa.family.create.app.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import pl.pa.family.create.app.error.InvalidFamilyDataException;

@RestControllerAdvice
public class FamilyApiHandler {

    @ExceptionHandler(value = InvalidFamilyDataException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    String invalidFamilyDataException(InvalidFamilyDataException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(value = HttpClientErrorException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    String httpClientErrorException(HttpClientErrorException exception) {
        return exception.getMessage();
    }

}
