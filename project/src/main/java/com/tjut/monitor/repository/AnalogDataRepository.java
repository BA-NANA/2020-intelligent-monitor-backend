package com.tjut.monitor.repository;

import com.tjut.monitor.entity.AnalogData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnalogDataRepository extends JpaRepository<AnalogData, Integer> {

    @Query(value = "select * from analog_data a where a.monitor_id=?1 ORDER BY RAND() LIMIT 1",
            nativeQuery = true)
    AnalogData findByMonitorIdRandom(Integer id);

}
