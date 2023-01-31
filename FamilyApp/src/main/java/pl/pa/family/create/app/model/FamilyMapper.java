package pl.pa.family.create.app.model;

import java.util.Collection;

public class FamilyMapper {

    private FamilyMapper() {
    }

    public static FamilyDTO map(FamilyDAO familyDAO) {

        return FamilyDTO.builder().
                familyName(familyDAO.getFamilyName()).
                nrOfInfants(familyDAO.getNrOfInfants()).
                nrOfChildren(familyDAO.getNrOfInfants()).
                nrOfAdults(familyDAO.getNrOfAdults()).build();
    }

    public static FamilyDAO map(int familyId, FamilyDTO familyDTO) {

        return new FamilyDAO(
                familyId,
                familyDTO.getFamilyName(),
                familyDTO.getNrOfInfants(),
                familyDTO.getNrOfChildren(),
                familyDTO.getNrOfAdults());
    }

    public static FamilyDTO compose(FamilyDAO familyDAO, Collection<FamilyMemberDTO> members){

        return FamilyDTO.builder().
                familyName(familyDAO.getFamilyName()).
                nrOfInfants(familyDAO.getNrOfInfants()).
                nrOfChildren(familyDAO.getNrOfChildren()).
                nrOfAdults(familyDAO.getNrOfAdults()).
                familyMember(members).build();
    }
}
