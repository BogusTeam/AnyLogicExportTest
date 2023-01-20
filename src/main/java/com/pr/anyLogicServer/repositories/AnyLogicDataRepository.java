package com.pr.anyLogicServer.repositories;

import com.pr.anyLogicServer.models.AnyLogicData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnyLogicDataRepository extends JpaRepository<AnyLogicData, Long> {
    @Query("SELECT data FROM AnyLogicData data WHERE data.scenario_number = :scenario_number")
    List<AnyLogicData> findByScenario_number(int scenario_number);

    @Query("SELECT data.scenario_number FROM AnyLogicData data GROUP BY data.scenario_number HAVING COUNT(data.scenario_number) > 0")
    List<Integer> selectAllScenarioNumbers();
}
