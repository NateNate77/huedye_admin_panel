package com.huedye.huedye_admin_panel.repository;

import com.huedye.huedye_admin_panel.model.Clients;
import com.huedye.huedye_admin_panel.model.Visits;
import uow.AddClient;
import uow.AddVisit;

public interface VisitDAO {

    int createVisit(AddVisit visit);

    Visits getVisitById(int id);
}
