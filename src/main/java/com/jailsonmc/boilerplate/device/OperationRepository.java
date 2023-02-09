package com.jailsonmc.boilerplate.device;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findOperationsByDevicesId(Long deviceId);
}
