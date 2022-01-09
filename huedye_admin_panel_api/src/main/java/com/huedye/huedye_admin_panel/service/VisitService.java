package com.huedye.huedye_admin_panel.service;

import com.huedye.huedye_admin_panel.model.Visits;
import uow.AddClient;
import uow.AddVisit;
import uow.EditVisit;

public interface VisitService {

    int createVisit(AddVisit visit);

    Visits getVisitById(int id);

    void editVisit(EditVisit editVisit, int id);

    void deleteVisit(int id);
}
