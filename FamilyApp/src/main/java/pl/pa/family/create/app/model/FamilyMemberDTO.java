package pl.pa.family.create.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class FamilyMemberDTO {

    @JsonProperty
    private String givenName;
    @JsonProperty
    private String familyName;
    @JsonProperty
    private int age;

    FamilyMemberDTO() {
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getAge() {
        return age;
    }
}
