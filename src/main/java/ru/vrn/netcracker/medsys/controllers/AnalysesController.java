package ru.vrn.netcracker.medsys.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vrn.netcracker.medsys.entities.analyses.AnalysisOrder;
import ru.vrn.netcracker.medsys.entities.dto.analyses.AnalysisDto;
import ru.vrn.netcracker.medsys.entities.dto.analyses.AnalysisOrderDto;
import ru.vrn.netcracker.medsys.entities.dto.mappers.AnalysisDtoManager;
import ru.vrn.netcracker.medsys.services.AnalysesService;
import ru.vrn.netcracker.medsys.services.AnalysisOrderService;

import java.util.ArrayList;

@RestController
@RequestMapping("api/analyses")
public class AnalysesController {
    private final AnalysesService analysesService;
    private final AnalysisOrderService orderService;
    private final ModelMapper mapper;

    @Autowired
    public AnalysesController(AnalysesService service, AnalysisOrderService orderService, ModelMapper modelMapper){
        analysesService = service;
        mapper = modelMapper;
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    @ResponseBody
    public ResponseEntity<Iterable<AnalysisDto>> getAllAnalyses() {
        Iterable<AnalysisOrder> orders = orderService.findAll();

        ArrayList<AnalysisDto> dtoAnalyses = new ArrayList<>();
        for (AnalysisOrder order : orders) {
            dtoAnalyses.add(AnalysisDtoManager.analysisOrderToDto(order));
        }

        return ResponseEntity.ok(dtoOrders);
    }

    @GetMapping("/orders/{id}")
    @ResponseBody
    public ResponseEntity<AnalysisOrderDto> getAnalysisById(@PathVariable Long id) {
        return ResponseEntity.ok(AnalysisDtoManager.analysisOrderToDto(orderService.findById(id).get()));
    }
}

/*    @GetMapping
    @ResponseBody
    public ResponseEntity<Iterable<AnalysisDto>> getAllAnalyses() {
        //get list of dto type
        Type responseListType = new TypeToken<List<AnalysisDto>>(){}.getType();
        return ResponseEntity.ok(mapper.map(analysesService.findAll(), responseListType));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<AnalysisDto> getAnalysis(@PathVariable Long id){
        Optional<Analysis> analysis = analysesService.findById(id);
        if (!analysis.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(mapper.map(analysis.get(), AnalysisDto.class));
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<AnalysisDto> createAnalysis(@RequestBody AnalysisDto newAnalysis){
        Analysis a = analysesService.save(mapper.map(newAnalysis, Analysis.class));
        return ResponseEntity.ok(mapper.map(a, AnalysisDto.class));
    }

    //TODO: Есть сомнения, что можно сделать по другому
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<AnalysisDto> updateAnalysis(@PathVariable Long id, @RequestBody AnalysisDto newAnalysis){
        Optional<Analysis> analysisOptional = analysesService.findById(id);
        if (!analysisOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        newAnalysis.setId(analysisOptional.get().getId());
        Analysis tmp = mapper.map(newAnalysis, Analysis.class);
        return ResponseEntity.ok(mapper.map(analysesService.save(tmp), AnalysisDto.class));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<AnalysisDto> deleteAnalysis(@PathVariable Long id){
        Optional<Analysis> a = analysesService.findById(id);
        if (!a.isPresent()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        analysesService.delete(a.get());
        return ResponseEntity.ok(mapper.map(a.get(), AnalysisDto.class));
    }*/


/*
    AnalysisOrderDto orderDto = new AnalysisOrderDto();
        orderDto.setClientName("Жмышенко Альберт Валерьевич");
                orderDto.setExecutorName("Головач Лена Аркадьевна");

                AnalysisDto analysisDto = new AnalysisDto();
                analysisDto.setName("Анализ крови");
                analysisDto.setDescription("Общий анализ крови на показатели");
                orderDto.setAnalysis(analysisDto);

                AnalysisResultDto resultDto1 = new AnalysisResultDto();
                AnalysisResultDto resultDto2 = new AnalysisResultDto();
                AnalysisResultDto resultDto3 = new AnalysisResultDto();

                resultDto1.setName("Гемоглобин");
                resultDto1.setValue("160");
                resultDto1.setMeasurement("грамм/литр");

                resultDto2.setName("Гематокрит");
                resultDto2.setValue("47.6");
                resultDto2.setMeasurement("%");

                resultDto3.setName("Эритроциты");
                resultDto3.setValue("3.29");
                resultDto3.setMeasurement("10^12/литр");

                ArrayList<AnalysisResultDto> results = new ArrayList<>();
        results.add(resultDto1);
        results.add(resultDto2);
        results.add(resultDto3);
        orderDto.setResults(results);

        ArrayList<AnalysisOrderDto> orders = new ArrayList<>();
        orders.add(orderDto);*/
