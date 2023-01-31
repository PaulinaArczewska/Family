package pl.pa.family.member.app.domain;

import pl.pa.family.member.app.model.FamilyMemberDTO;

public class FamilyMemberValidator {

    /**
     * walidacja wszystkich parametrów danego członka rodziny
     * @param familyMemberDTO obiekt walidowany
     * @return true, jeżeli obiekt przeszedł pozytywnie walidację
     */
    boolean validateFamilyMember(int familyId, FamilyMemberDTO familyMemberDTO) {
        return (validateFamilyId(familyId) &&
                validateGivenName(familyMemberDTO.getGivenName()) &&
                validateFamilyName(familyMemberDTO.getFamilyName()) &&
                validateAge(familyMemberDTO.getAge()));
    }

    /**
     * walidacja familyId
     * @param familyId parametr walidowany
     * @return true, jeżeli familyId przeszło pozytywnie walidację
     */
    private boolean validateFamilyId(int familyId) {
        return familyId >= 0;
    }

    /**
     * walidacja givenName
     * @param givenName parametr walidowany
     * @return true, jeżeli givenName przeszło pozytywnie walidację
     */
    private boolean validateGivenName(String givenName) {
        return givenName != null && !givenName.equals("");
    }

    /**
     * walidacja familyName
     * @param familyName parametr walidowany
     * @return true jeżeli familyName przeszło pozytywnie walidację
     */
    private boolean validateFamilyName(String familyName) {
        return familyName != null && !familyName.equals("");
    }

    /**
     * walidacja age
     * @param age parametr walidowany
     * @return true jeżeli age przeszło pozytywnie walidację
     */
    private boolean validateAge(int age) {
        return age >= 0;
    }
}
