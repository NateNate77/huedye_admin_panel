package com.huedye.huedye_admin_panel.controller;

import com.huedye.huedye_admin_panel.viewModels.ClientDetails;
import com.huedye.huedye_admin_panel.model.Clients;
import com.huedye.huedye_admin_panel.model.Visits;
import com.huedye.huedye_admin_panel.viewModels.ClientRow;
import com.huedye.huedye_admin_panel.viewModels.VisitRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.huedye.huedye_admin_panel.service.ClientServiceImpl;
import uow.AddClient;
import uow.EditClient;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/clients")
public class ClientController {


    private ClientServiceImpl clientService;

    @Autowired
    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<ClientRow>> getAll() {
        List<Clients> clients = clientService.getAll();
        List<ClientRow> clientRows = new ArrayList<>();

        for (int i = 0; i < clients.size(); i++) {
            Clients clientsFromDB = clients.get(i);
            List<Visits> completedVisits = clientsFromDB.getVisitsList() != null && !clientsFromDB.getVisitsList().isEmpty()
                    ? clientsFromDB.getVisitsList().stream().filter(x -> x.getCompleted()).collect(Collectors.toList())
                    : null;
            Date lastVisitDate = completedVisits != null && !completedVisits.isEmpty()
                    ? completedVisits.stream().max(Comparator.comparing(x -> x.getVisitDate())).get().getVisitDate()
                    : null;
            ClientRow client = new ClientRow(clientsFromDB.getId(), clientsFromDB.getName(), clientsFromDB.getPhone(), lastVisitDate, clientsFromDB.getVisitsList().stream().filter(x -> x.getCompleted()).collect(Collectors.toList()).size());
            clientRows.add(client);
            System.out.println(client);
        }

//        return clients != null &&  !clients.isEmpty()
//                ? new ResponseEntity<>(clients, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(clientRows, HttpStatus.OK);

    }

    @GetMapping(value = "/getClient/{id}")
    public ResponseEntity<ClientDetails> getClient(@PathVariable(name = "id") int id) {
        Clients clientById = clientService.getClientById(id);
        List<Visits> visits = clientById.getVisitsList();
        List<VisitRow> visitRows = new ArrayList<>();

        for(int i = 0; i < visits.size(); i++){
            Visits visit = visits.get(i);
            if(!visit.isDeleted()){
                VisitRow visitRow = new VisitRow(visit.getId(), visit.getVisitDate(), visit.getCompleted(), visit.getFinalTitle(), visit.getCreationTitle(), visit.getFinalCost());
                visitRows.add(visitRow);
            }
        }
        List<VisitRow> sortedVisits = visitRows.stream().sorted(Comparator.comparing(x -> x.getId())).collect(Collectors.toList());
        var clientDetails = new ClientDetails(clientById.getId(), clientById.getName(), sortedVisits);

        return new ResponseEntity<>(clientDetails, HttpStatus.OK);

    }

    @PostMapping(value = "/addClient")
    public ResponseEntity<?> create(@RequestBody AddClient client) {
        int id = clientService.createClient(client);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping(value = "/editClient/{id}")
    public ResponseEntity<?> editClient(@RequestBody EditClient editClient, @PathVariable(name = "id") int id) {
        clientService.editClient(editClient, id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteClient/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(name = "id") int id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}
