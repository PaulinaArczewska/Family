package pl.pa.family.create.app.domain;

import pl.pa.family.create.app.model.FamilyDTO;
import pl.pa.family.create.app.model.FamilyMemberDTO;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExternalFamilyMemberServiceTest extends ExternalFamilyMemberService {

    private final Map<Integer, FamilyDTO> families = new HashMap<>();

    @Override
    boolean createNewFamilyMember(int familyId, FamilyDTO familyDTO) {

        families.put(familyId, familyDTO);
        return true;
    }

    @Override
    Collection<FamilyMemberDTO> getFamilyMembers(int familyId) {

        return families.entrySet().stream().filter(f -> f.getKey().equals(familyId)).findFirst()
                .map(f -> f.getValue().getFamilyMember()).orElse(Collections.emptyList());
    }
}
