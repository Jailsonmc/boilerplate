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

import java.util.ArrayList;
import java.util.List;

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
		Assertions.assertNotNull(this.deviceRepository.findById(1L).get());
	}

    @Test
    @DisplayName("Create Operation")
    public void testCreateOperation() {

        Operation clear = new Operation("CLEAR");
        clear.setId(1L);

        this.operationRepository.save(clear);
        Assertions.assertNotNull(this.operationRepository.findById(1L).get());
    }

}
