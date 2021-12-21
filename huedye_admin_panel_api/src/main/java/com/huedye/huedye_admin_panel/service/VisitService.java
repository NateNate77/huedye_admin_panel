package com.huedye.huedye_admin_panel.service;

import com.huedye.huedye_admin_panel.model.Visits;
import uow.AddClient;
import uow.AddVisit;

public interface VisitService {

    int createVisit(AddVisit visit);

    Visits getVisitById(int id);
}
