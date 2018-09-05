package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Prescription {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @OneToOne
    private Visit visit;
    @OneToMany(mappedBy = "prescription")
    @JsonIgnore
    private Set<DrugInfo> drugInfos;

    public Visit getVisit() {
        return this.visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public Prescription() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<DrugInfo> getDrugInfos() {
        return drugInfos;
    }

    public void setDrugInfos(Set<DrugInfo> drugInfos) {
        this.drugInfos = drugInfos;
    }
}
