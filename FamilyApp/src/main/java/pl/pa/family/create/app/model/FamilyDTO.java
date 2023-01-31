package pl.pa.family.create.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.Collection;
import java.util.List;

@Builder
public class FamilyDTO {

    @JsonProperty
    private String familyName;
    @JsonProperty
    private int nrOfInfants;
    @JsonProperty
    private int nrOfChildren;
    @JsonProperty
    private int nrOfAdults;
    @JsonProperty
    private Collection<FamilyMemberDTO> familyMember;

    public String getFamilyName() {
        return familyName;
    }

    public int getNrOfInfants() {
        return nrOfInfants;
    }

    public int getNrOfChildren() {
        return nrOfChildren;
    }

    public int getNrOfAdults() {
        return nrOfAdults;
    }

    public Collection<FamilyMemberDTO> getFamilyMember() {
        return familyMember;
    }

}
