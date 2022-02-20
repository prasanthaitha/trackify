package com.globaltech.trackify.repository;

import com.globaltech.trackify.pojos.FreqConfig;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FreqConfigRepository extends CrudRepository<FreqConfig, Integer> {

    @Query("SELECT config_data FROM freq_config where device_id=:device_id and version=:version")
    String fetchLatestFreqConfig(@Param("device_id") String deviceId, @Param("version") Integer version);

    @Query("SELECT MAX(version) FROM freq_config where device_id=:device_id")
    Integer fetchLatestVersionForDevice(@Param("device_id") String deviceId);

}
