package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Date;
import java.util.Set;
import javax.persistence.*;

enum Gender {
    MALE,
    FEMALE;
}

@Entity
public class Patient {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence-generator"
    )
    @SequenceGenerator(name = "sequence-generator", sequenceName = "patient_sequence", allocationSize = 1)
    private int id;

    @Column
    private String name;
    @Column
    private Date dateOfBirth;
    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column
    private String address;
    @OneToMany(
            mappedBy = "patient",
            cascade = {CascadeType.ALL},
            orphanRemoval = true
    )
    @JsonIgnore
    private Set<Visit> visits;

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Visit> getVisits() {
        return this.visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    public Patient() {
    }
}
