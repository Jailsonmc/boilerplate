package com.jailsonmc.boilerplate.device;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Device {

    @Id
    @SequenceGenerator(
            name = "device",
            sequenceName = "device_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "device_sequence"
    )
    private Long id;
    private String name;
    private String brand;
    private LocalDate CreationTime;
    @Enumerated(EnumType.STRING)
    private List<SupportedOperations> SupportedOperations;

    public Device() {
    }

    public Device(Long id, String name, String brand, List<SupportedOperations> supportedOperations) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        CreationTime = LocalDate.now();
        SupportedOperations = supportedOperations;
    }

    public Device(String name, String brand, List<SupportedOperations> supportedOperations) {
        this.name = name;
        this.brand = brand;
        CreationTime = LocalDate.now();
        SupportedOperations = supportedOperations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getCreationTime() {
        return CreationTime;
    }

    public List<com.jailsonmc.boilerplate.device.SupportedOperations> getSupportedOperations() {
        return SupportedOperations;
    }

    public void setSupportedOperations(List<com.jailsonmc.boilerplate.device.SupportedOperations> supportedOperations) {
        SupportedOperations = supportedOperations;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", CreationTime=" + CreationTime +
                ", SupportedOperations=" + SupportedOperations +
                '}';
    }
}
