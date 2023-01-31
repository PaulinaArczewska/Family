package pl.pa.family.create.app.domain;

import pl.pa.family.create.app.error.InvalidFamilyDataException;
import pl.pa.family.create.app.model.FamilyDTO;

public class FamilyValidator {

    public boolean validateFamilyData(FamilyDTO familyDTO) {

        if (familyDTO.getFamilyName() != null && !familyDTO.getFamilyName().equals("")) {

            if (isEqualsNrOfInfants(familyDTO) && isEqualsNrOfChildren(familyDTO)
                    && isEqualsNrOfAdults(familyDTO)) {
                return true;

            } else throw new InvalidFamilyDataException("Invalid number of family members.");

        } else throw new InvalidFamilyDataException("Invalid family name");
    }

    /**
     * zlicza i sprawdza czy liczba NrOfInfants jest równa z NrOfInfants z createFamilyDTO
     * @param familyDTO parametr walidowany
     * @return true jeżeli NrOfInfants przeszło pozytywnie walidację
     */
    private boolean isEqualsNrOfInfants(FamilyDTO familyDTO) {

        long nrOfInfantsFromList = familyDTO.getFamilyMember().stream().
                filter(e -> FamilyMemberType.isInfant(e.getAge())).count();

        return nrOfInfantsFromList == familyDTO.getNrOfInfants();
    }

    /**
     * zlicza i sprawdza czy liczba NrOfChildren jest równa z NrOfChildren z createFamilyDTO
     * @param familyDTO parametr walidowany
     * @return true jeżeli NrOfChildren przeszło pozytywnie walidację
     */
    //zlicza i sprawdza czy liczba NrOfChildren jest równa z NrOfChildren z createFamilyDTO
    private boolean isEqualsNrOfChildren(FamilyDTO familyDTO) {

        long nrOfChildrenFromList = familyDTO.getFamilyMember().stream().
                filter(e -> FamilyMemberType.isChild(e.getAge())).count();

        return nrOfChildrenFromList == familyDTO.getNrOfChildren();
    }

    /**
     * zlicza i sprawdza czy liczba NrOfChildren jest równa z NrOfChildren z createFamilyDTO
     * @param familyDTO parametr walidowany
     * @return true jeżeli NrOfAdults przeszło pozytywnie walidację
     */

    //zlicza i sprawdza czy liczba NrOfAdults jest równa z NrOfAdults z createFamilyDTO
    private boolean isEqualsNrOfAdults(FamilyDTO familyDTO) {

        long nrOfAdultsFromList = familyDTO.getFamilyMember().stream().
                filter(e -> FamilyMemberType.idAdult(e.getAge())).count();
        return nrOfAdultsFromList == familyDTO.getNrOfAdults();
    }
}

