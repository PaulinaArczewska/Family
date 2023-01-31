package pl.pa.family.member.app.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pa.family.member.app.domain.FamilyMemberService;
import pl.pa.family.member.app.model.FamilyMemberDTO;

import java.text.CollationKey;
import java.util.Collection;
import java.util.List;

@RestController
public class FamilyMemberApi {

    private FamilyMemberService familyMemberService;

    public FamilyMemberApi(FamilyMemberService familyMemberService) {

        this.familyMemberService = familyMemberService;
    }

    @RequestMapping(value = "/familyMembers/{familyId}", method = RequestMethod.POST)
    public ResponseEntity<Void> createFamilyMember(@PathVariable int familyId, @RequestBody Collection<FamilyMemberDTO> familyMembersDTO) {

        familyMemberService.createFamilyMember(familyId, familyMembersDTO);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/familyMembers/{familyId}", method = RequestMethod.GET)
    public ResponseEntity<Collection<FamilyMemberDTO>> searchFamilyMember(@PathVariable int familyId) {

        Collection<FamilyMemberDTO> result = familyMemberService.searchFamilyMember(familyId);
        return ResponseEntity.ok(result);
    }
}
