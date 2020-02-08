package com.eme.springTask.entities;

import com.eme.springTask.utils.Gender;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Owner {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(columnDefinition = "enum('m','f')", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "address", length = 200)
    private String address;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Pet> petsList;

    public List<Pet> getPetsList() {
        return petsList;
    }

    public void setPetsList(List<Pet> petsList) {
        this.petsList = petsList;
    }

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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return id == owner.id;
    }

    @PostPersist
    public void PostPersistHandler() {
        if (petsList.size() > 0) {
            for (Pet pet : petsList) {
                if (pet.getOwner() == null)
                    pet.setOwner(this);
            }
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", petsList=" + petsList +
                '}';
    }
}
