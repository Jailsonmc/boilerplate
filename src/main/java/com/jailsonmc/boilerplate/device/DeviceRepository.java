package com.jailsonmc.boilerplate.device;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {

    List<Device> findDevicesByOperationsId(Long operationId);

}
