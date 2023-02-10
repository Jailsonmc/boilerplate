package com.jailsonmc.boilerplate.device;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "brand")
    private String brand;
    @Column(name = "CreationTime")
    private LocalDate creationTime;

    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
        })
    @JoinTable(name="supported_operations",
        joinColumns = { @JoinColumn(name = "device_id")},
        inverseJoinColumns = { @JoinColumn(name = "operation_id")})
    private Set<Operation> operations = new HashSet<>();

    public Device() {
        this.creationTime = LocalDate.now();
    }

    public Device(String name, String brand) {
        this.name = name;
        this.brand = brand;
        this.creationTime = LocalDate.now();
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
        return creationTime;
    }

    public void setCreationTime(LocalDate creationTime) {
        this.creationTime = creationTime;
    }

    public void addOperation(Operation operation) {
        this.operations.add(operation);
        operation.getDevices().add(this);
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public void removeOperation(long operationId) {
        Operation operation = this.operations.stream().filter(
                o -> o.getId() == operationId
        ).findFirst().orElse(null);
        if (operation != null) {
            this.operations.remove(operation);
            operation.getDevices().remove(this);
        }
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", CreationTime=" + creationTime +
                ", SupportedOperations=" + operations +
                '}';
    }
}
