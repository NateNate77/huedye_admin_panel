package com.huedye.huedye_admin_panel.repository;

import com.huedye.huedye_admin_panel.model.Clients;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.huedye.huedye_admin_panel.utils.HibernateSessionFactoryUtil;
import uow.AddClient;

import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO {

    public List<Clients> getAll() {
        List<Clients> clients = (List<Clients>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Clients").list();
        return clients;
    }

    public Clients getClientById(int id) {
        Clients clientById = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Clients.class, id);

        return clientById;
    }

    @Override
    public int createClient(AddClient client) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Clients newClient = new Clients();
        newClient.setName(client.getName());
        newClient.setPhone(client.getPhone());

        session.save(newClient);

        session.getTransaction().commit();

        return newClient.getId();

    }
}
