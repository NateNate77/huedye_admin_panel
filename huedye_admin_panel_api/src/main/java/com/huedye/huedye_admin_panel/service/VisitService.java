package com.huedye.huedye_admin_panel.service;

import com.huedye.huedye_admin_panel.model.Visits;
import uow.*;

public interface VisitService {

    int createVisit(AddVisit visit);

    Visits getVisitById(int id);

    void editVisit(EditVisit editVisit, int id);

    void deleteVisit(int id);

    int addProcedure(AddProcedure addProcedure);

    void deleteProcedure(int id);

    void editProcedure(EditProcedure editProcedure, int id);
}
