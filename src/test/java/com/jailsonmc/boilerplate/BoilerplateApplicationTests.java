package com.jailsonmc.boilerplate;

import com.jailsonmc.boilerplate.device.Device;
import com.jailsonmc.boilerplate.device.DeviceRepository;
import com.jailsonmc.boilerplate.device.Operation;
import com.jailsonmc.boilerplate.device.OperationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BoilerplateApplicationTests {

	@Autowired
    DeviceRepository deviceRepository;

    @Autowired
    OperationRepository operationRepository;
	@Test
	@DisplayName("Create Device")
	public void testCreateDevice() {

		Device device = new Device();
		device.setId(1L);
		device.setName("Device Name");
		device.setBrand("Device Brand");

		this.deviceRepository.save(device);
		Assertions.assertNotNull(this.deviceRepository.findDeviceByName("Device Name"));
	}

    @Test
    @DisplayName("Create Operation")
    public void testCreateOperation() {

        Operation clear = new Operation("OPEN");
        clear.setId(1L);

        this.operationRepository.save(clear);
        Assertions.assertNotNull(this.operationRepository.findOperationByName("OPEN"));
    }

    @Test
    @DisplayName("Read All Devices")
    public void testReadAll() {
        List<Device> devices = deviceRepository.findAll();
        assertTrue(() -> devices.size() > 0);
    }

    @Test
    @DisplayName("Single Device")
    public void testSingleDevice() {
        Optional<Device> deviceOptional = this.deviceRepository.findDeviceByName("GT-100");
        Assertions.assertTrue(() -> {
            return deviceOptional.isPresent();
        });
    }

    @Test
    @DisplayName("Single Device By Brand")
    public void testSingleDeviceByBrand() {
        List<Device> devices = this.deviceRepository.findDeviceByBrand("LG");
        assertTrue(() -> devices.size() > 0);
    }

    @Test
    @DisplayName("Update Device")
    public void testUpdate() {
        Optional<Device> deviceOptional = this.deviceRepository.findDeviceByName("GT-100");
        Device device = (Device)deviceOptional.orElse(null);
        device.setName("GT-101");
        this.deviceRepository.save(device);
        Assertions.assertTrue(() -> {
            return device.getName().equals("GT-101");
        });
    }

    @Test
    @DisplayName("Delete Device")
    public void testDelete() {
        this.deviceRepository.deleteById(2L);
        Optional<Device> deviceOptional = this.deviceRepository.findById(2L);
        Assertions.assertFalse(() -> {
            return deviceOptional.isPresent();
        });
    }

}
