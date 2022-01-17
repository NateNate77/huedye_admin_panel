package com.huedye.huedye_admin_panel.controller;

import com.huedye.huedye_admin_panel.model.Clients;
import com.huedye.huedye_admin_panel.model.Materials;
import com.huedye.huedye_admin_panel.model.Visits;
import com.huedye.huedye_admin_panel.service.ClientServiceImpl;
import com.huedye.huedye_admin_panel.service.MaterialServiceImpl;
import com.huedye.huedye_admin_panel.viewModels.ClientRow;
import com.huedye.huedye_admin_panel.viewModels.MaterialRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/materials")
public class MaterialController {

    private MaterialServiceImpl materialService;

    @Autowired
    public MaterialController(MaterialServiceImpl materialService) {
        this.materialService = materialService;
    }

    @GetMapping(value = "/getMaterials")
    public ResponseEntity<List<MaterialRow>> getAll() {
        List<Materials> materials = materialService.getAll();
        List<MaterialRow> materialRows = new ArrayList<>();

          for (int i = 0; i < materials.size(); i++) {
              Materials materialsFromDB = materials.get(i);
              MaterialRow materialRow = new MaterialRow(materialsFromDB.getId(), materialsFromDB.getBrand().getName(), materialsFromDB.getName(), materialsFromDB.getCost(), materialsFromDB.getAmount());
              materialRows.add(materialRow);
          }

        return new ResponseEntity<>(materialRows, HttpStatus.OK);

    }
}
