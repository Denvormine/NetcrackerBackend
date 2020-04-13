package ru.vrn.netcracker.medsys.entities.dto.mappers;

import ru.vrn.netcracker.medsys.entities.analyses.Analysis;
import ru.vrn.netcracker.medsys.entities.analyses.AnalysisComponent;
import ru.vrn.netcracker.medsys.entities.analyses.AnalysisOrder;
import ru.vrn.netcracker.medsys.entities.analyses.AnalysisResult;
import ru.vrn.netcracker.medsys.entities.dto.analyses.AnalysisComponentDto;
import ru.vrn.netcracker.medsys.entities.dto.analyses.AnalysisDto;
import ru.vrn.netcracker.medsys.entities.dto.analyses.AnalysisOrderDto;
import ru.vrn.netcracker.medsys.entities.dto.analyses.AnalysisResultDto;

import java.util.ArrayList;
import java.util.Collection;


public class AnalysisDtoManager {
    public static AnalysisOrderDto analysisOrderToDto(AnalysisOrder order) {
        AnalysisOrderDto dto = new AnalysisOrderDto();

        dto.setId(order.getId());
        dto.setClientName(order.getClient().getName());
        dto.setExecutorName(order.getExecutor().getName());
        dto.setAnalysis(analysisToDto(order.getAnalysis()));

        Collection<AnalysisResult> results = order.getResults();
        Collection<AnalysisResultDto> dtoResults = new ArrayList<>();
        for (AnalysisResult result : results) {
            dtoResults.add(analysisResultToDto(result));
        }
        dto.setResults(dtoResults);
        return dto;
    }

    public static AnalysisOrder dtoToAnalysisOrder(AnalysisOrderDto dto) {
        return null;
    }

    public static AnalysisDto analysisToDto(Analysis analysis) {
        AnalysisDto dto = new AnalysisDto();
        dto.setId(analysis.getId());
        dto.setName(analysis.getName());
        dto.setDescription(analysis.getDescription());
        return dto;
    }

    public static Analysis dtoToAnalysis(AnalysisDto dto) {
        return null;
    }

    public static AnalysisResultDto analysisResultToDto(AnalysisResult result) {
        AnalysisResultDto dto = new AnalysisResultDto();
        dto.setId(result.getId());
        dto.setName(result.getComponent().getName());
        dto.setMeasurement(result.getMeasurement());
        dto.setValue(result.getValue());
        return dto;
    }

    public static AnalysisResult dtoToAnalysisResult(AnalysisResultDto dto) {
        AnalysisResult result = new AnalysisResult();
        result.setId(dto.getId());
        return null;
    }

    public static AnalysisComponentDto analysisComponentToDto(AnalysisComponent component) {
        return null;
    }

    public static AnalysisComponent dtoToAnalysisComponent(AnalysisComponentDto dto) {
        return null;
    }
}
