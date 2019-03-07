package com.test.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.ssm.dao.CpDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.ssm.pojo.Cp;
import com.test.ssm.service.CpSevice;

import java.util.List;

@Service
public class CpServiceImpl implements CpSevice {

    @Autowired
    private CpDAO cpDAO;

    @Override
    public PageInfo<Cp> getAllCpPage(String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<Cp>(cpDAO.getAllCp(name));
    }

    @Override
    public List<Cp> getAllCp(String name) {

        return cpDAO.getAllCp(name);
    }

    @Override
    public Cp getCpById(Integer id) {
        return cpDAO.getCpById(id);
    }

    @Override
    public void addCp(Cp cp) {
        cpDAO.addCp(cp);
    }

    @Override
    public void updateCp(Cp cp) {
        cpDAO.updateCp(cp);
    }

    @Override
    public int deleteCp(Integer id) {
        return cpDAO.deleteCp(id);
    }
}
