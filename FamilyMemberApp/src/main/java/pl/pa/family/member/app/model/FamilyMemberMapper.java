package pl.pa.family.member.app.model;

import java.util.Collection;
import java.util.stream.Collectors;

public class FamilyMemberMapper {

    public static FamilyMemberDTO map(FamilyMemberDAO familyMemberDAO) {
        return FamilyMemberDTO.builder().
                givenName(familyMemberDAO.getGivenName()).
                familyName(familyMemberDAO.getFamilyName()).
                age(familyMemberDAO.getAge()).build();
    }

    public static Collection<FamilyMemberDTO> map(Collection<FamilyMemberDAO> familyMembersDAO) {
        return familyMembersDAO.stream().map(e -> map(e)).collect(Collectors.toList());
    }
}
