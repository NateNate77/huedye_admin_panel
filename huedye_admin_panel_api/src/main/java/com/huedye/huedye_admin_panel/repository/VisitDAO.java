package com.huedye.huedye_admin_panel.repository;

import uow.AddClient;
import uow.AddVisit;

public interface VisitDAO {

    int createVisit(AddVisit visit);
}
