package com.globaltech.trackify.pojos;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "freq_config")
public class FreqConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "config_id")
    private Integer configId;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "version")
    private Integer version;

    @Column(name = "config_data")
    private String configData;

    @Column(name = "updated_ts")
    private Timestamp updatedTs;

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getConfigData() {
        return configData;
    }

    public void setConfigData(String configData) {
        this.configData = configData;
    }

    public Timestamp getUpdatedTs() {
        return updatedTs;
    }

    public void setUpdatedTs(Timestamp updatedTs) {
        this.updatedTs = updatedTs;
    }
}
