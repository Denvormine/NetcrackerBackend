package ru.vrn.netcracker.medsys.entities.analyses;

import lombok.Data;
import ru.vrn.netcracker.medsys.entities.Client;
import ru.vrn.netcracker.medsys.entities.User;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "analysis_order")
public class AnalysisOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_analysis_order")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Analysis analysis;
    @ManyToOne(fetch = FetchType.LAZY)
    private User client;
    @ManyToOne(fetch = FetchType.LAZY)
    private User executor;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Collection<AnalysisResult> results;
}

//@ElementCollection
//@CollectionTable(name = "analyses", joinColumns = @JoinColumn(name = "id_analysis"))
//private Collection<Analysis> analyses;