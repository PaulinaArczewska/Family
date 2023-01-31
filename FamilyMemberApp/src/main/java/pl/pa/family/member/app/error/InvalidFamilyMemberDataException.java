package pl.pa.family.member.app.error;

public class InvalidFamilyMemberDataException extends RuntimeException {

    public InvalidFamilyMemberDataException(String message) {
        super(message);
    }
}
