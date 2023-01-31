package pl.pa.family.create.app.api;

import org.junit.jupiter.api.*;
import pl.pa.family.create.app.domain.*;
import pl.pa.family.create.app.model.FamilyDTO;
import pl.pa.family.create.app.model.FamilyMemberDTO;

import java.util.Collection;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FamilyApiTest {

    private static FamilyRepository familyRepository = new FamilyRepositoryInMemory();
    private static ExternalFamilyMemberService externalFamilyMemberService = new ExternalFamilyMemberServiceTest();
    private static FamilyService familyService = new FamilyService(familyRepository, externalFamilyMemberService);
    private static FamilyApi familyApi = new FamilyApi(familyService);

    @Test
    @Order(1)
    void shouldCreateFamily() {
        //given
        FamilyMemberDTO familyMember1 = FamilyMemberDTO.builder().givenName("Anna").familyName("Nowak").age(1).build();
        FamilyMemberDTO familyMember2 = FamilyMemberDTO.builder().givenName("Katarzyna").familyName("Nowak").age(5).build();
        FamilyMemberDTO familyMember3 = FamilyMemberDTO.builder().givenName("Adam").familyName("Nowak").age(7).build();
        FamilyMemberDTO familyMember4 = FamilyMemberDTO.builder().givenName("Beata").familyName("Nowak").age(8).build();
        FamilyMemberDTO familyMember5 = FamilyMemberDTO.builder().givenName("Sławomir").familyName("Nowak").age(45).build();
        FamilyMemberDTO familyMember6 = FamilyMemberDTO.builder().givenName("Bożena").familyName("Nowak").age(40).build();

        Collection<FamilyMemberDTO> familyMembers = List.of(familyMember1, familyMember2, familyMember3,
                familyMember4, familyMember5, familyMember6);

        FamilyDTO familyDTO = FamilyDTO.builder().
                familyName("Nowak").
                nrOfInfants(1).
                nrOfChildren(3).
                nrOfAdults(2).
                familyMember(familyMembers).build();
        int familyId = familyApi.createFamily(familyDTO);
        //when
        FamilyDTO result = familyApi.getFamily(familyId);
        //then
        Assertions.assertEquals(6, result.getFamilyMember().size());
        Assertions.assertEquals("Nowak", result.getFamilyName());
        Assertions.assertEquals(1, result.getNrOfInfants());
        Assertions.assertEquals(3, result.getNrOfChildren());
        Assertions.assertEquals(2, result.getNrOfAdults());
    }

    @Test
    @Order(2)
    public void shouldGetFamily() {
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

        int familyId = familyApi.createFamily(familyDTO);
        //when
        FamilyDTO result = familyApi.getFamily(familyId);
        //then
        Assertions.assertNotNull(familyApi.getFamily(familyId));
    }
}
