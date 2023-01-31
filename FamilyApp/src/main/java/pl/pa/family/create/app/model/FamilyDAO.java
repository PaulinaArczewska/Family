package pl.pa.family.create.app.model;

import javax.persistence.*;

@Entity
@Table(name = "FamilyDB")
public class FamilyDAO {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "familyName")
    private String familyName;
    @Column(name = "nrOfInfants")
    private int nrOfInfants;
    @Column(name = "nrOfChildren")
    private int nrOfChildren;
    @Column(name = "nrOfAdults")
    private int nrOfAdults;

    public FamilyDAO() {
    }

    public FamilyDAO(int id, String familyName, int nrOfInfants, int nrOfChildren, int nrOfAdults) {

        this.id = id;
        this.familyName = familyName;
        this.nrOfInfants = nrOfInfants;
        this.nrOfChildren = nrOfChildren;
        this.nrOfAdults = nrOfAdults;
    }

    public int getId() {

        return id;
    }

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
}
