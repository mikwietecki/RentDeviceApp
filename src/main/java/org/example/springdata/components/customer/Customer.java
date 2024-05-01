package org.example.springdata.components.customer;


import jakarta.persistence.*;
import org.example.springdata.components.device.Device;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(length = 11)
    private String pesel;
    @Column(name = "id_number", length = 10)
    private String idNumber;
    @ManyToMany(mappedBy = "customers")
    private List<Device> rentDevice = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public List<Device> getRentDevice() {
        return rentDevice;
    }

    public void setRentDevice(List<Device> rentDevice) {
        this.rentDevice = rentDevice;
    }
}
