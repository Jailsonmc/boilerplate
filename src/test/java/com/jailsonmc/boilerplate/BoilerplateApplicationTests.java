package com.jailsonmc.boilerplate;

import com.jailsonmc.boilerplate.device.Device;
import com.jailsonmc.boilerplate.device.DeviceRepository;
import com.jailsonmc.boilerplate.device.SupportedOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BoilerplateApplicationTests {

	@Autowired
	DeviceRepository deviceRepository;
	@Test
	@DisplayName("Create Student")
	public void testCreate() {
		Device device = new Device();
		device.setId(1L);
		device.setName("Device Name");
		device.setBrand("Device Brand");
		List<SupportedOperations> supportedOperations = new ArrayList<>();
		supportedOperations.add(SupportedOperations.CALL);
		supportedOperations.add(SupportedOperations.RESET);
		device.setSupportedOperations(supportedOperations);
		this.deviceRepository.save(device);
		Assertions.assertNotNull(this.deviceRepository.findById(1L).get());
	}

}
