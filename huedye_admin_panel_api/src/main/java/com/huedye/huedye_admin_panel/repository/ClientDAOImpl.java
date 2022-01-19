package com.huedye.huedye_admin_panel.repository;

import com.huedye.huedye_admin_panel.model.Clients;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.huedye.huedye_admin_panel.utils.HibernateSessionFactoryUtil;
import uow.AddClient;
import uow.EditClient;

import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO {

    public List<Clients> getAll() {
        List<Clients> clients = (List<Clients>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Clients where isdeleted = false order by id").list();
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
        session.close();

        return newClient.getId();

    }

    @Override
    public void editClient(EditClient editClient, int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Clients clientById = session.get(Clients.class, id);
        session.beginTransaction();
        clientById.setName(editClient.getName());
        clientById.setPhone(editClient.getPhone());
        session.update(clientById);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void deleteClient(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Clients clientById = session.get(Clients.class, id);
        session.beginTransaction();
        clientById.setDeleted(true);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Clients> searchClient(String search) {
        String queryString = "From Clients where lower(name) like :searchPhrase or lower(phone) like :searchPhrase order by id";
        Query sqlQuery = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery(queryString);
        sqlQuery.setParameter("searchPhrase", "%" + search.toLowerCase() + "%");
        List<Clients> clients = (List<Clients>)  sqlQuery.list();
        return clients;
    }
}
