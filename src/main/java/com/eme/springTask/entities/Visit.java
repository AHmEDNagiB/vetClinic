package com.eme.springTask.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Visit {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date", nullable = false)
    private Date date;
    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    private Doctor doctorByDoctorId;
    @ManyToOne
    @JoinColumn(name = "clinic_id", referencedColumnName = "id", nullable = false)
    private Clinic clinicByClinicId;
    @ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "id", nullable = false)
    private Pet petByPetId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return id == visit.id &&
                Objects.equals(date, visit.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date);
    }


    public Doctor getDoctorByDoctorId() {
        return doctorByDoctorId;
    }

    public void setDoctorByDoctorId(Doctor doctorByDoctorId) {
        this.doctorByDoctorId = doctorByDoctorId;
    }


    public Clinic getClinicByClinicId() {
        return clinicByClinicId;
    }

    public void setClinicByClinicId(Clinic clinicByClinicId) {
        this.clinicByClinicId = clinicByClinicId;
    }


    public Pet getPetByPetId() {
        return petByPetId;
    }

    public void setPetByPetId(Pet petByPetId) {
        this.petByPetId = petByPetId;
    }
}
