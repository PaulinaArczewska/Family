package pl.pa.family.member.app.model;

import javax.persistence.*;

@Entity
@Table(name = "FamilyMemberDB")
public class FamilyMemberDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "familyId")
    private int familyId;
    @Column(name = "givenName")
    private String givenName;
    @Column(name = "familyName")
    private String familyName;
    @Column(name = "age")
    private int age;

    FamilyMemberDAO() {
    }

    public FamilyMemberDAO(int familyId, String givenName, String familyName, int age) {
        this.familyId = familyId;
        this.givenName = givenName;
        this.familyName = familyName;
        this.age = age;
    }

    public int getFamilyId() {
        return familyId;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getAge() {
        return age;
    }
}
