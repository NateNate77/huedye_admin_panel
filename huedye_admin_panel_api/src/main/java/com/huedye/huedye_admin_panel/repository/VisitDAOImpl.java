package com.huedye.huedye_admin_panel.repository;

import com.huedye.huedye_admin_panel.model.Clients;
import com.huedye.huedye_admin_panel.model.Visits;
import com.huedye.huedye_admin_panel.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import uow.AddVisit;
import uow.EditVisit;

import java.util.Date;

@Repository
public class VisitDAOImpl implements VisitDAO{

    @Override
    public int createVisit(AddVisit visit) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Visits newVisit = new Visits();
        Clients client = new Clients();
        client.setId(visit.getClientId());
        newVisit.setClient(client);
        newVisit.setVisitDate(visit.getDate());
        newVisit.setCreationDate(new Date());
        newVisit.setCreationTitle(visit.getTitle());
        newVisit.setCreationCost(visit.getCost());

        session.save(newVisit);

        session.getTransaction().commit();

        return newVisit.getId();
    }

    @Override
    public Visits getVisitById(int id) {
        Visits visitById = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Visits.class, id);

        return visitById;
    }

    @Override
    public void editVist(EditVisit editVisit, int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Visits visitById = session.get(Visits.class, id);
        session.beginTransaction();
        visitById.setVisitDate(editVisit.getDate());
        visitById.setCreationTitle(editVisit.getTitle());
        visitById.setFinalTitle(editVisit.getTitle());
        session.update(visitById);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteVisit(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Visits visitById = session.get(Visits.class, id);
        session.beginTransaction();
        visitById.setDeleted(true);
        session.update(visitById);
        session.getTransaction().commit();
        session.close();
    }
}
