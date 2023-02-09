package com.jailsonmc.boilerplate.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> getDevices() {
        return deviceRepository.findAll();
    }

    public Optional<Device> getDevice(Long deviceId) {
        boolean exist = deviceRepository.existsById(deviceId);
        if(!exist) {
            throw new IllegalStateException("Device with id " + deviceId + " does not exists.");
        }
        return deviceRepository.findById(deviceId);
    }

    public void addDevice(Device device) {
        Optional<Device> deviceOptional = deviceRepository.findDeviceByName(device.getName());
        if(deviceOptional.isPresent()) {
            throw new IllegalStateException("device taken");
        }
        device.setId(getNextId());
        deviceRepository.save(device);
    }

    private long getNextId() {
        Device device = deviceRepository.findFirstByOrderByIdDesc();
        if(device == null) {
            return 1L;
        }
        return device.getId() + 1;
    }

    public List<Device> getDevicesByBrand(String brand) {
        return deviceRepository.findDeviceByBrand(brand);
    }
}
