package com.huedye.huedye_admin_panel.controller;


import com.huedye.huedye_admin_panel.service.ClientServiceImpl;
import com.huedye.huedye_admin_panel.service.VisitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uow.AddClient;
import uow.AddVisit;

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

}
