package pl.pa.family.create.app.api;

import org.springframework.web.bind.annotation.*;
import pl.pa.family.create.app.domain.FamilyService;
import pl.pa.family.create.app.model.FamilyDTO;

@RestController
public class FamilyApi {

    private FamilyService familyService;

    public FamilyApi(FamilyService familyService) {
        this.familyService = familyService;
    }


    @RequestMapping(value = "/family", method = RequestMethod.POST)
    public int createFamily(@RequestBody FamilyDTO familyDTO) {
        return familyService.createFamily(familyDTO);
    }

    @RequestMapping(value = "/family/{familyId}", method = RequestMethod.GET)
    public FamilyDTO getFamily(@PathVariable int familyId) {
        return familyService.getFamily(familyId);
    }
}
