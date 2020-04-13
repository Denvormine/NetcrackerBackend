package ru.vrn.netcracker.medsys.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vrn.netcracker.medsys.entities.analyses.Analysis;
import ru.vrn.netcracker.medsys.entities.analyses.AnalysisOrder;
import ru.vrn.netcracker.medsys.repositories.AnalysisOrderRepository;
import ru.vrn.netcracker.medsys.repositories.AnalysisRepository;

import java.util.Optional;

@Service
@Slf4j
public class AnalysisOrderService {
    private final AnalysisOrderRepository orderRepository;

    @Autowired
    public AnalysisOrderService(AnalysisOrderRepository repository){
        orderRepository = repository;
    }

    public Optional<AnalysisOrder> findById(Long id){
        return orderRepository.findById(id);
    }

    public Iterable<AnalysisOrder> findAll(){
        return orderRepository.findAll();
    }

    public AnalysisOrder save(AnalysisOrder a) {
        return orderRepository.save(a);
    }

    public Iterable<AnalysisOrder> saveAll(Iterable<AnalysisOrder> a){
        return orderRepository.saveAll(a);
    }


    public void delete(AnalysisOrder a){
        orderRepository.delete(a);
    }
}
