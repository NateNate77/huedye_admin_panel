package com.huedye.huedye_admin_panel.service;

import com.huedye.huedye_admin_panel.model.Visits;
import com.huedye.huedye_admin_panel.repository.ClientDAOImpl;
import com.huedye.huedye_admin_panel.repository.VisitDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uow.AddVisit;

@Service
public class VisitServiceImpl implements VisitService {

    final
    VisitDAOImpl visitDAO;

    @Autowired
    public VisitServiceImpl(VisitDAOImpl visitDAO) {
        this.visitDAO = visitDAO;
    }

    @Override
    public int createVisit(AddVisit visit) {
        return visitDAO.createVisit(visit);
    }

    @Override
    public Visits getVisitById(int id) {
        return  this.visitDAO.getVisitById(id);
    }
}
