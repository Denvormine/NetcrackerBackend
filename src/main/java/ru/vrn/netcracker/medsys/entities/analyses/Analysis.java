package ru.vrn.netcracker.medsys.entities.analyses;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Setter
@Getter
@Entity
@Table(name = "analysis")
public class Analysis {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_analysis")
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @OneToMany(
            mappedBy = "analysis",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Collection<AnalysisComponent> components;
    @OneToMany(
            mappedBy = "analysis",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Collection<AnalysisOrder> orders;

}

//@ElementCollection(targetClass = AnalysisComponent.class)
//@CollectionTable(name = "analysis_components", joinColumns = @JoinColumn(name = "component_id"))
//private Collection<AnalysisComponent> components;
//@ManyToMany(fetch = FetchType.LAZY)
//@JoinTable(name = "analysis_component",joinColumns = @JoinColumn(name = "id_analysis", referencedColumnName = "analysis_id"),
//        inverseJoinColumns = @JoinColumn(name = "component_id", referencedColumnName = "component_id"))
//private Collection<AnalysisComponent> components;