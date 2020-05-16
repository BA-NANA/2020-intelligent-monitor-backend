package com.tjut.monitor.repository;

import com.tjut.monitor.entity.RealTimeData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealTimeDataRepository extends JpaRepository<RealTimeData, Integer> {

    Page<RealTimeData> findAll(Pageable pageable);

}
