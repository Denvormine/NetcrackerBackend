package ru.vrn.netcracker.medsys.entities.dto.analyses;

import lombok.Data;

import java.util.Collection;

@Data
public class AnalysisOrderDto {
    Long id;
    String clientName;
    String executorName;
    AnalysisDto analysis;
    Collection<AnalysisResultDto> results;
}
