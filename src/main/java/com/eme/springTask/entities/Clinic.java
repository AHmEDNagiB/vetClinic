package com.eme.springTask.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Clinic {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "address", nullable = false, length = 200)
    private String address;
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @ManyToOne
    @JoinColumn(name = "working_days_id", referencedColumnName = "id", nullable = false)
    private WorkingDays workingDays;
    @ManyToOne
    @JoinColumn(name = "working_hours_id", referencedColumnName = "id", nullable = false)
    private WorkingHours workingHours;


    @OneToMany(mappedBy = "clinic")
    @JsonIgnore
    private Set<Doctor> doctors;

    @OneToMany(mappedBy = "clinic" , cascade = CascadeType.PERSIST)
    private Set<SocialNetworkUrl> socialNetworkUrls;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<SocialNetworkUrl> getSocialNetworkUrls() {
        return socialNetworkUrls;
    }

    public void setSocialNetworkUrls(Set<SocialNetworkUrl> socialNetworkUrls) {
        this.socialNetworkUrls = socialNetworkUrls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clinic clinic = (Clinic) o;
        return id == clinic.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public WorkingDays getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(WorkingDays workingDays) {
        this.workingDays = workingDays;
    }

    public WorkingHours getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(WorkingHours workingHours) {
        this.workingHours = workingHours;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    @PostPersist
    public void PostPersistHandler() {
        if (socialNetworkUrls.size() > 0) {
            for (SocialNetworkUrl snu : socialNetworkUrls) {
                if (snu.getClinic() == null)
                    snu.setClinic(this);
            }
        }
    }
}
