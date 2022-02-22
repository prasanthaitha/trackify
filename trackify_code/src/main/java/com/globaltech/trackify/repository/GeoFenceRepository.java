package com.globaltech.trackify.repository;

import com.globaltech.trackify.pojos.GeoFence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoFenceRepository extends CrudRepository<GeoFence, Integer> {
}
