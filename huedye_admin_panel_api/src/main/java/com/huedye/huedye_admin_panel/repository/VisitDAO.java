package com.huedye.huedye_admin_panel.repository;

import com.huedye.huedye_admin_panel.model.Clients;
import com.huedye.huedye_admin_panel.model.Visits;
import uow.AddClient;
import uow.AddVisit;
import uow.EditVisit;

public interface VisitDAO {

    int createVisit(AddVisit visit);

    Visits getVisitById(int id);

    void editVist(EditVisit editVisit, int id);

    void deleteVisit(int id);
}
