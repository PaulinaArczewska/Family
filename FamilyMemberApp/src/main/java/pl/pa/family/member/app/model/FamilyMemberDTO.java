package pl.pa.family.member.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.Objects;

@Builder
public class FamilyMemberDTO {

    @JsonProperty
    private String givenName;
    @JsonProperty
    private String familyName;
    @JsonProperty
    private int age;

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FamilyMemberDTO that = (FamilyMemberDTO) o;

        if (age != that.age) return false;
        if (!Objects.equals(givenName, that.givenName)) return false;
        return Objects.equals(familyName, that.familyName);
    }

    @Override
    public int hashCode() {
        int result = givenName != null ? givenName.hashCode() : 0;
        result = 31 * result + (familyName != null ? familyName.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}
