package com.huedye.huedye_admin_panel.repository;

import com.huedye.huedye_admin_panel.model.Clients;
import uow.AddClient;
import uow.EditClient;

import java.util.List;

public interface ClientDAO {

    List<Clients> getAll();

    Clients getClientById(int id);

    int createClient(AddClient client);

    void editClient(EditClient editClient, int id);

    void deleteClient(int id);
}
