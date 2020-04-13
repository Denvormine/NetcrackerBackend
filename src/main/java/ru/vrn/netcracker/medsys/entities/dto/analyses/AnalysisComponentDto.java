package ru.vrn.netcracker.medsys.entities.dto.analyses;

import lombok.Data;

@Data
public class AnalysisComponentDto {
    Long id;
    String name;
    String measurement;
}
