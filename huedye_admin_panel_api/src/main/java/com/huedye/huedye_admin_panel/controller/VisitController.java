package com.huedye.huedye_admin_panel.controller;


import com.huedye.huedye_admin_panel.model.Clients;
import com.huedye.huedye_admin_panel.model.Procedures;
import com.huedye.huedye_admin_panel.model.Visits;
import com.huedye.huedye_admin_panel.service.ClientServiceImpl;
import com.huedye.huedye_admin_panel.service.VisitServiceImpl;
import com.huedye.huedye_admin_panel.viewModels.ClientDetails;
import com.huedye.huedye_admin_panel.viewModels.ProcedureRow;
import com.huedye.huedye_admin_panel.viewModels.VisitDetails;
import com.huedye.huedye_admin_panel.viewModels.VisitRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uow.AddClient;
import uow.AddVisit;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/visits")
public class VisitController {


    private VisitServiceImpl visitService;

    @Autowired
    public VisitController(VisitServiceImpl visitService) {
        this.visitService = visitService;
    }

    @PostMapping(value = "/addVisit")
    public ResponseEntity<?> create(@RequestBody AddVisit visit) {
        int id = visitService.createVisit(visit);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(value = "/getVisit/{id}")
    public ResponseEntity<VisitDetails> getVisit(@PathVariable(name = "id") int id) {
        Visits visitById = visitService.getVisitById(id);
        List<Procedures> procedures = visitById.getProceduresList();
        List<ProcedureRow> procedureRows = new ArrayList<>();

        for(int i = 0; i < procedures.size(); i++){
            Procedures procedure = procedures.get(i);
            ProcedureRow procedureRow = new ProcedureRow(procedure.getId(), procedure.getConditionBefore(), procedure.getDescription(), procedure.getConditionAfter(), procedure.getComment());
            procedureRows.add(procedureRow);
        }

        VisitDetails visitDetails = new VisitDetails(visitById.getId(), visitById.getVisitDate(), visitById.getCompleted(), visitById.getFinalTitle(), visitById.getCreationTitle(), visitById.getFinalCost(), procedureRows);

        return new ResponseEntity<>(visitDetails, HttpStatus.OK);

    }

}
