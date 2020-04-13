package ru.vrn.netcracker.medsys.entities.analyses;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Setter
@Getter
@Entity
@Table(name = "analysis_component")
public class AnalysisComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_component")
    private Long id_component;
    @Column(name = "name")
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Analysis analysis;
    @OneToMany(
            mappedBy = "component",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Collection<AnalysisResult> components;
}
