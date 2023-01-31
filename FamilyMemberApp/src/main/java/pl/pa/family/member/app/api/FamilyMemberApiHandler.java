package pl.pa.family.member.app.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.pa.family.member.app.error.InvalidFamilyMemberDataException;

@RestControllerAdvice
public class FamilyMemberApiHandler {

    @ExceptionHandler(value = InvalidFamilyMemberDataException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    String invalidFamilyMemberDataException(InvalidFamilyMemberDataException exception) {
        return exception.getMessage();
    }
}
