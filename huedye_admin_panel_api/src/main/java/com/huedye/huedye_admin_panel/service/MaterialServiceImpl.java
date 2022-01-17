package com.huedye.huedye_admin_panel.service;

import com.huedye.huedye_admin_panel.model.Materials;
import com.huedye.huedye_admin_panel.repository.ClientDAOImpl;
import com.huedye.huedye_admin_panel.repository.MaterialDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService{

    final
    MaterialDAOImpl materialDAO;

    @Autowired
    public MaterialServiceImpl(MaterialDAOImpl materialDAO) {
        this.materialDAO = materialDAO;
    }

    @Override
    public List<Materials> getAll() {
        return materialDAO.getAll();
    }
}
