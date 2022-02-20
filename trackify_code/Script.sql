
-- Creating location table
create table location(
   location_id INT NOT NULL AUTO_INCREMENT,
   device_id VARCHAR(255) NOT NULL,
   updated_ts TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   location VARCHAR(255) NOT NULL,
   speed float,
   PRIMARY KEY (location_id)
);


-- Creating geo_fences table
create table geo_fences(
   geo_fence_id INT NOT NULL AUTO_INCREMENT,
   geo_fence_name VARCHAR(255) NOT NULL,
   location_p1 VARCHAR(255) NOT NULL,
   location_p2 VARCHAR(255) NOT NULL,
   location_p3 VARCHAR(255) NOT NULL,
   location_p4 VARCHAR(255) NOT NULL,
   dc_num INT NOT NULL,
   updated_ts TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (geo_fence_id)
);


-- Creating freq_config table
create table freq_config(
   config_id INT NOT NULL AUTO_INCREMENT,
   device_id VARCHAR(255) NOT NULL,
   version INT NOT NULL,
   config_data nvarchar(4000),
   updated_ts TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (config_id)
);