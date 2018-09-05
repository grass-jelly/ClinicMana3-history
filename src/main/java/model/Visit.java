package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Visit {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @ManyToOne
    private Patient patient;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column
    private Time time;
    @Column
    @ElementCollection(
            fetch = FetchType.EAGER
    )
    private List<String> problems;
    @ManyToOne
    private Disease disease;
    @OneToOne(mappedBy = "visit", orphanRemoval = true)
    @JsonIgnore
    private Prescription prescription;
    @OneToOne(mappedBy = "visit", orphanRemoval = true)
    @JsonIgnore
    private LabTest labTest;

    public Prescription getPrescription() {
        return this.prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Disease getDisease() {
        return this.disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Time getTime() {
        return this.time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<String> getProblems() {
        return this.problems;
    }

    public void setProblems(List<String> problems) {
        this.problems = problems;
    }

    public LabTest getLabTest() {
        return labTest;
    }

    public void setLabTest(LabTest labTest) {
        this.labTest = labTest;
    }

    public Visit() {
    }
}
