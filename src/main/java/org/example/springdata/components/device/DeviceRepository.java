package org.example.springdata.components.device;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeviceRepository extends CrudRepository<Device, Long> {
    List<Device> findAllByNameContainingIgnoreCase(String name);
}
