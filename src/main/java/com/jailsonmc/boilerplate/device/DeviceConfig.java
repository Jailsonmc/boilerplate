package com.jailsonmc.boilerplate.device;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DeviceConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            DeviceRepository deviceRepository,
            OperationRepository operationRepository
    ) {
        return args -> {

            Operation clear = new Operation("CLEAR");
            Operation call = new Operation("CALL");
            Operation close = new Operation("CLOSE");
            operationRepository.saveAll(
                    List.of(clear, call, close)
            );

            Device gt100 = new Device(
                    "GT-100",
                    "Samsung"
            );
            Device lxt90 = new Device(
                    "LXT-90",
                    "LG"
            );
            deviceRepository.saveAll(
                    List.of(gt100, lxt90)
            );

        };
    }
}
