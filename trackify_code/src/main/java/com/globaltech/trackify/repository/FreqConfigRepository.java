package com.globaltech.trackify.repository;

import com.globaltech.trackify.pojos.FreqConfig;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FreqConfigRepository extends CrudRepository<FreqConfig, Integer> {

    @Query(value = "select config_data from freq_config where device_id=:device_id and version=:version", nativeQuery = true)
    String fetchLatestFreqConfig(@Param("device_id") String deviceId, @Param("version") Integer version);

    @Query(value = "select MAX(version) FROM freq_config where device_id=:device_id", nativeQuery = true)
    Integer fetchLatestVersionForDevice(@Param("device_id") String deviceId);

    List<FreqConfig> findByDeviceIdAndVersion(String deviceId, Integer version);

    List<FreqConfig> findByDeviceId(String deviceId);
}
