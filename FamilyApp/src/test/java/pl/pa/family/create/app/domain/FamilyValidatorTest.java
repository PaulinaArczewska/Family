package pl.pa.family.create.app.domain;

import org.junit.jupiter.api.*;
import pl.pa.family.create.app.model.FamilyDTO;
import pl.pa.family.create.app.model.FamilyMemberDTO;

import java.util.Collection;
import java.util.List;

public class FamilyValidatorTest {

    private static FamilyValidator familyValidator = new FamilyValidator();

    @Test
    void shouldValidateData() {
        //given
        FamilyMemberDTO familyMember1 = FamilyMemberDTO.builder().givenName("Aleksandra").familyName("Kowalska").age(1).build();
        FamilyMemberDTO familyMember2 = FamilyMemberDTO.builder().givenName("MAria").familyName("Kowalska").age(2).build();
        FamilyMemberDTO familyMember3 = FamilyMemberDTO.builder().givenName("Zbigniew").familyName("Kowalska").age(2).build();
        FamilyMemberDTO familyMember4 = FamilyMemberDTO.builder().givenName("Beata").familyName("Kowalska").age(37).build();
        FamilyMemberDTO familyMember5 = FamilyMemberDTO.builder().givenName("Paweł").familyName("Kowalska").age(38).build();
        FamilyMemberDTO familyMember6 = FamilyMemberDTO.builder().givenName("Michalina").familyName("Kowalska").age(77).build();

        Collection<FamilyMemberDTO> familyMembers = List.of(familyMember1, familyMember2, familyMember3,
                familyMember4, familyMember5, familyMember6);

        FamilyDTO familyDTO = FamilyDTO.builder().
                familyName("Kowalska").
                nrOfInfants(3).
                nrOfChildren(0).
                nrOfAdults(3).
                familyMember(familyMembers).build();
        //then
        Assertions.assertDoesNotThrow(() -> familyValidator.validateFamilyData(familyDTO));
    }
}
