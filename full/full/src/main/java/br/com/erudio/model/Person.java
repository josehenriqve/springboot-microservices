package br.com.erudio.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private static final long serialVersionID = 1L;
    private long Id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    public Person() {

    }

    public long getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String genter) {
        this.gender = genter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return getId() == person.getId() && getFirstName() == person.getFirstName() && getLastName() == person.getLastName() && getAddress() == person.getAddress() && getGender() == person.getGender();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getAddress(), getGender());
    }
}




