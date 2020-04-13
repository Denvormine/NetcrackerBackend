package ru.vrn.netcracker.medsys.entities.analyses;

import lombok.Data;

import javax.persistence.*;
import java.awt.*;
import java.util.Map;

@Data
@Entity
@Table(name = "analysis_result")
public class AnalysisResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_analysis_result")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private AnalysisOrder order;
    @ManyToOne(fetch = FetchType.LAZY)
    private AnalysisComponent component;
    @Column(name = "value")
    private String value;
    @Column(name = "measurement")
    private String measurement;
}
