package in.foxlogic.gsmswitch.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.foxlogic.gsmswitch.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {

	Device findBySerialNumber(Long serialNumber);

}
