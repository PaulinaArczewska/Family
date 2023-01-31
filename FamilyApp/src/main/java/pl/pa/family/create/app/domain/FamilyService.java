package pl.pa.family.create.app.domain;

import pl.pa.family.create.app.error.InvalidFamilyDataException;
import pl.pa.family.create.app.model.FamilyDAO;
import pl.pa.family.create.app.model.FamilyDTO;
import org.springframework.stereotype.Service;
import pl.pa.family.create.app.model.FamilyMapper;
import pl.pa.family.create.app.model.FamilyMemberDTO;

import java.util.Collection;
import java.util.Optional;


@Service
public class FamilyService {

    private FamilyRepository familyRepository;
    private ExternalFamilyMemberService externalFamilyMemberService;

    public FamilyService(FamilyRepository familyRepository, ExternalFamilyMemberService externalFamilyMemberService) {
        this.familyRepository = familyRepository;
        this.externalFamilyMemberService = externalFamilyMemberService;
    }

    public int createFamily(FamilyDTO familyDTO) {

        if (new FamilyValidator().validateFamilyData(familyDTO)) {

            int familyId = FamilyIdGenerator.next();
            if (externalFamilyMemberService.createNewFamilyMember(familyId, familyDTO)) {

                FamilyDAO familyDAO = FamilyMapper.map(familyId, familyDTO);
                familyRepository.save(familyDAO);
                return familyDAO.getId();
            }
        }
        throw new InvalidFamilyDataException("Unexpected erroe from family validator.");
    }

    public FamilyDTO getFamily(int familyId) {

        Optional<FamilyDAO> result = familyRepository.findById(familyId);

        if (result.isPresent()) {
            Collection<FamilyMemberDTO> familyMembers = externalFamilyMemberService.getFamilyMembers(familyId);
            return FamilyMapper.compose(result.get(), familyMembers);
        }
        throw new InvalidFamilyDataException("Invalid family id.");
    }
}


