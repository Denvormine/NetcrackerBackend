package ru.vrn.netcracker.medsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vrn.netcracker.medsys.entities.analyses.Analysis;
import ru.vrn.netcracker.medsys.entities.analyses.AnalysisOrder;

public interface AnalysisOrderRepository extends JpaRepository<AnalysisOrder, Long> {
}
