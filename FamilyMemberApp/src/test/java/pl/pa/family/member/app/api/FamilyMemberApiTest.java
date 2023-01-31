package pl.pa.family.member.app.api;

import org.junit.jupiter.api.*;
import org.springframework.http.ResponseEntity;
import pl.pa.family.member.app.domain.FamilyMemberRepository;
import pl.pa.family.member.app.domain.FamilyMemberRepositoryInMemory;
import pl.pa.family.member.app.domain.FamilyMemberService;
import pl.pa.family.member.app.error.InvalidFamilyMemberDataException;
import pl.pa.family.member.app.model.FamilyMemberDTO;

import java.util.Collection;
import java.util.Collections;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FamilyMemberApiTest {

    private static FamilyMemberRepository familyMemberRepository = new FamilyMemberRepositoryInMemory();
    private static FamilyMemberService familyMemberService = new FamilyMemberService(familyMemberRepository);
    private static FamilyMemberApi familyMemberApi = new FamilyMemberApi(familyMemberService);

    @Test
    @Order(1)
    void shouldCreateNewFamilyMember() {
        //given
        FamilyMemberDTO familyMember = FamilyMemberDTO.builder().
                givenName("Adam").
                familyName("Kowalski").
                age(35).build();
        familyMemberApi.createFamilyMember(1, Collections.singletonList(familyMember));
        //when
        ResponseEntity<Collection<FamilyMemberDTO>> result = familyMemberApi.searchFamilyMember(1);
        Collection<FamilyMemberDTO> expected = result.getBody();
        //then
        Assertions.assertTrue(expected.contains(familyMember));
        Assertions.assertEquals(1, expected.size());
    }

    @Test
    @Order(4)
    void shouldAddSecondFamilyMemberWithTheSameFamilyId() {
        //given
        FamilyMemberDTO familyMember1 = FamilyMemberDTO.builder().
                givenName("Joanna").
                familyName("Kowalska").
                age(33).build();
        familyMemberApi.createFamilyMember(1,Collections.singletonList(familyMember1));
        //when
        ResponseEntity<Collection<FamilyMemberDTO>> result = familyMemberApi.searchFamilyMember(1);
        Collection<FamilyMemberDTO> expected = result.getBody();
        //then
        Assertions.assertTrue(expected.contains(familyMember1));
        Assertions.assertEquals(2, expected.size());
    }

    @Test
    @Order(5)
    void shouldNotAddFamilyMemberWithInvalidFamilyId() {
        //given
        FamilyMemberDTO familyMember2 = FamilyMemberDTO.builder().
                givenName("Ewa").
                familyName("Nowakowska").
                age(22).build();
        //then
        Assertions.assertThrows(InvalidFamilyMemberDataException.class, () -> {
            familyMemberApi.createFamilyMember(-22,Collections.singletonList(familyMember2));
        });
    }

    @Test
    @Order(6)
    void shouldNotAddFamilyMemberWithInvalidGivenName() {
        //given
        FamilyMemberDTO familyMember3 = FamilyMemberDTO.builder().
                givenName("").
                familyName("Kowalska").
                age(67).build();
        //then
        Assertions.assertThrows(InvalidFamilyMemberDataException.class, () -> {
            familyMemberApi.createFamilyMember(2, Collections.singletonList(familyMember3));
        });
    }

    @Test
    @Order(7)
    void shouldNotAddFamilyMemberWithInvalidFamilyName() {
        //given
        FamilyMemberDTO familyMember4 = FamilyMemberDTO.builder().
                givenName("Kamil").
                familyName(null).
                age(15).build();
        //then
        Assertions.assertThrows(InvalidFamilyMemberDataException.class, () -> {
            familyMemberApi.createFamilyMember(2, Collections.singletonList(familyMember4));
        });
    }

    @Test
    @Order(8)
    void shouldNotAddFamilyMemberWithInvalidFamilyAge() {
        //given
        FamilyMemberDTO familyMember5 = FamilyMemberDTO.builder().
                givenName("Karolina").
                familyName("Andrzejewska").
                age(-33).build();
        //then
        Assertions.assertThrows(InvalidFamilyMemberDataException.class, () -> {
            familyMemberApi.createFamilyMember(6, Collections.singletonList(familyMember5));
        });
    }

    @Test
    @Order(2)
    void shouldSearchFamilyMember() {
        //when
        ResponseEntity<Collection<FamilyMemberDTO>> result = familyMemberApi.searchFamilyMember(1);
        Collection<FamilyMemberDTO> expected = result.getBody();
        //then
        Assertions.assertEquals(1, expected.size());
    }

    @Test
    @Order(3)
    void shouldNotSearchFamilyMemberIfMemberNotExist() {
        //when
        ResponseEntity<Collection<FamilyMemberDTO>> result = familyMemberApi.searchFamilyMember(999);
        Collection<FamilyMemberDTO> expected = result.getBody();
        //then
        Assertions.assertEquals(0, expected.size());
    }
}
