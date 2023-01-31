package pl.pa.family.member.app.domain;

import org.springframework.stereotype.Service;
import pl.pa.family.member.app.error.InvalidFamilyMemberDataException;
import pl.pa.family.member.app.model.FamilyMemberDAO;
import pl.pa.family.member.app.model.FamilyMemberDTO;
import pl.pa.family.member.app.model.FamilyMemberMapper;

import java.util.Collection;

@Service
public class FamilyMemberService {

    private FamilyMemberRepository familyMemberRepository;

    public FamilyMemberService(FamilyMemberRepository familyMemberRepository) {
        this.familyMemberRepository = familyMemberRepository;
    }

    public void createFamilyMember(int familyId, Collection<FamilyMemberDTO> familyMembersDTO) {

        familyMembersDTO.forEach(familyMemberDTO -> {

            if (new FamilyMemberValidator().validateFamilyMember(familyId, familyMemberDTO)) {

                FamilyMemberDAO familyMemberDAO = new FamilyMemberDAO(
                        familyId,
                        familyMemberDTO.getGivenName(),
                        familyMemberDTO.getFamilyName(),
                        familyMemberDTO.getAge());
                familyMemberRepository.save(familyMemberDAO);

            } else throw new InvalidFamilyMemberDataException("Invalid family member data.");
        });
    }

    public Collection<FamilyMemberDTO> searchFamilyMember(int familyId) {

        Collection<FamilyMemberDAO> result = familyMemberRepository.findByFamilyId(familyId);
        return FamilyMemberMapper.map(result);
    }
}



