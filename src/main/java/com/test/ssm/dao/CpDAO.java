package com.test.ssm.dao;

import com.test.ssm.pojo.Cp;

import java.util.List;

public interface CpDAO {
    List<Cp> getAllCp(String name);
    Cp getCpById(Integer id);
   void addCp(Cp cp);
   void updateCp(Cp cp);
    int deleteCp(Integer id);
}
