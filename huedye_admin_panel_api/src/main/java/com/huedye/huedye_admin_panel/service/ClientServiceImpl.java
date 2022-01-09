package com.huedye.huedye_admin_panel.service;

import com.huedye.huedye_admin_panel.model.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huedye.huedye_admin_panel.repository.ClientDAOImpl;
import uow.AddClient;
import uow.EditClient;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    final
    ClientDAOImpl clientDAO;

    @Autowired
    public ClientServiceImpl(ClientDAOImpl clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public List<Clients> getAll() {
        return clientDAO.getAll();
    }

    public Clients getClientById(int id){
        return clientDAO.getClientById(id);
    }

    @Override
    public int createClient(AddClient client) {
        return clientDAO.createClient(client);
    }

    @Override
    public void editClient(EditClient editClient, int id) {
        clientDAO.editClient(editClient, id);
    }

    @Override
    public void deleteClient(int id) {
        clientDAO.deleteClient(id);
    }
}
