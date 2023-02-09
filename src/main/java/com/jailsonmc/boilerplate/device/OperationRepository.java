package com.jailsonmc.boilerplate.device;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findOperationsByDevicesId(Long deviceId);

    @Query("SELECT s FROM Operation s WHERE s.name = ?1")
    Optional<Operation> findOperationByName(String name);

}
