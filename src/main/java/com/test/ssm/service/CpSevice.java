package com.test.ssm.service;

import com.github.pagehelper.PageInfo;
import com.test.ssm.pojo.Cp;


import java.util.List;


public interface CpSevice {
     PageInfo<Cp> getAllCpPage(String name, Integer pageNum, Integer pageSize);
    List<Cp> getAllCp(String name);
     Cp getCpById(Integer id);
     void addCp(Cp cp);
     void updateCp(Cp cp);
     int deleteCp(Integer id);
}
