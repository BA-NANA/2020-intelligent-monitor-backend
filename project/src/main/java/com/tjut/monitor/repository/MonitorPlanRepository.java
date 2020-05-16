package com.tjut.monitor.repository;

import com.tjut.monitor.entity.MonitorPlan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorPlanRepository extends JpaRepository<MonitorPlan, Integer> {

    Page<MonitorPlan> findAll(Pageable pageable);

}
