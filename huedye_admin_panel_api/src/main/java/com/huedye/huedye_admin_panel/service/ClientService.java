package com.huedye.huedye_admin_panel.service;

import com.huedye.huedye_admin_panel.model.Clients;
import uow.AddClient;

import java.util.List;

public interface ClientService {

    List<Clients> getAll();


    Clients getClientById(int id);

    int createClient(AddClient client);
}
