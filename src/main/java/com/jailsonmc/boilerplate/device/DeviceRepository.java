package com.jailsonmc.boilerplate.device;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    List<Device> findDevicesByOperationsId(Long operationId);

    @Query("SELECT d FROM Device d WHERE d.name = ?1")
    Optional<Device> findDeviceByName(String name);

}
