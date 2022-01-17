package com.huedye.huedye_admin_panel.repository;

import com.huedye.huedye_admin_panel.model.Clients;
import com.huedye.huedye_admin_panel.model.Materials;
import com.huedye.huedye_admin_panel.utils.HibernateSessionFactoryUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MaterialDAOImpl implements MaterialDAO{
    @Override
    public List<Materials> getAll() {
        List<Materials> materials = (List<Materials>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Materials order by id").list();
        return materials;
    }
}
