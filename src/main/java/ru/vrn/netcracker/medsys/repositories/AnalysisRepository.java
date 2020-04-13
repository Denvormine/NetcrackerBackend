package ru.vrn.netcracker.medsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vrn.netcracker.medsys.entities.analyses.Analysis;

public interface AnalysisRepository extends JpaRepository<Analysis, Long> {
}
