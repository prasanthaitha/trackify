package com.globaltech.trackify.pojos;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "geo_fences")
public class GeoFence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "geo_fence_id")
    private Integer geoFenceId;

    @Column(name = "geo_fence_name")
    private String geoFenceName;

    @Column(name = "location_p1")
    private String locationP1;

    @Column(name = "location_p2")
    private String locationP2;

    @Column(name = "location_p3")
    private String locationP3;

    @Column(name = "location_p4")
    private String locationP4;

    @Column(name = "dc_num")
    private Integer dcNum;

    @Column(name = "updated_ts")
    private Timestamp updatedTs;

    public Integer getGeoFenceId() {
        return geoFenceId;
    }

    public void setGeoFenceId(Integer geoFenceId) {
        this.geoFenceId = geoFenceId;
    }

    public String getGeoFenceName() {
        return geoFenceName;
    }

    public void setGeoFenceName(String geoFenceName) {
        this.geoFenceName = geoFenceName;
    }

    public String getLocationP1() {
        return locationP1;
    }

    public void setLocationP1(String locationP1) {
        this.locationP1 = locationP1;
    }

    public String getLocationP2() {
        return locationP2;
    }

    public void setLocationP2(String locationP2) {
        this.locationP2 = locationP2;
    }

    public String getLocationP3() {
        return locationP3;
    }

    public void setLocationP3(String locationP3) {
        this.locationP3 = locationP3;
    }

    public String getLocationP4() {
        return locationP4;
    }

    public void setLocationP4(String locationP4) {
        this.locationP4 = locationP4;
    }

    public Integer getDcNum() {
        return dcNum;
    }

    public void setDcNum(Integer dcNum) {
        this.dcNum = dcNum;
    }

    public Timestamp getUpdatedTs() {
        return updatedTs;
    }

    public void setUpdatedTs(Timestamp updatedTs) {
        this.updatedTs = updatedTs;
    }
}
