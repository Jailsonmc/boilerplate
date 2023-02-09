package com.jailsonmc.boilerplate.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/device")
public class DeviceController {

    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/getDevices")
    public List<Device> getDevices() {
        return this.deviceService.getDevices();
    }

    @GetMapping("/getDevice/{deviceId}")
    public Optional<Device> getDevice(@PathVariable("deviceId") Long deviceId) {
        return this.deviceService.getDevice(deviceId);
    }

    @GetMapping
    public List<Device> getDevicesByBrand(@RequestParam(required = true) String brand) {
        return deviceService.getDevicesByBrand(brand);
    }

    @PostMapping
    public void addDevice(@RequestBody Device device) {
        deviceService.addDevice(device);
    }

    @DeleteMapping(path = "{deviceId}")
    public void deleteDevice(@PathVariable("deviceId") Long deviceId) {
        deviceService.deleteDevice(deviceId);
    }

    @PutMapping(path = "{deviceId}")
    public void updateDevice(
            @PathVariable("deviceId") Long deviceId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String brand
    ) {
        deviceService.updateService(deviceId, name, brand);
    }

}
