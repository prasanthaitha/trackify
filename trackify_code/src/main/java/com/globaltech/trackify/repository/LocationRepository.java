package com.globaltech.trackify.repository;

import com.globaltech.trackify.pojos.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LocationRepository extends CrudRepository<Location, Integer> {

    @Query("SELECT * FROM location where device_id=:device_id ORDER BY updated_ts LIMIT 1")
    Location fetchLatestLocation(@Param("device_id") String deviceId);

//    List<Article> findByTitle(String title);
//    List<Article> findDistinctByCategory(String category);
//    List<Article> findByTitleAndCategory(String title, String category);
//
//    @Query("SELECT a FROM Article a WHERE a.title=:title and a.category=:category")
//    List<Article> fetchArticles(@Param("title") String title, @Param("category") String category);

}
