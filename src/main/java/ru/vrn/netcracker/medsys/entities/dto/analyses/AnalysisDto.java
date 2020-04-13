package ru.vrn.netcracker.medsys.entities.dto.analyses;

import lombok.Data;
import ru.vrn.netcracker.medsys.entities.analyses.AnalysisComponent;

import java.util.Collection;

@Data
public class AnalysisDto {
    private Long id;
    private String name;
    private String description;
}
