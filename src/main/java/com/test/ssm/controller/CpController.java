package com.test.ssm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.test.ssm.pojo.Cp;
import com.test.ssm.service.CpSevice;
import com.test.ssm.util.JsonUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CpController {
    @Autowired
    private CpSevice cpSevice;

    @RequestMapping("listCp.html")
    public ModelAndView list(String name) {
       List<Cp> cps = cpSevice.getAllCp(name);
        return new ModelAndView("listCp", "cps", cps);
    }

    @RequestMapping("deleteCp.html")
    public void delete(Integer id, HttpServletResponse response) throws Exception{
        int res = cpSevice.deleteCp(id);
        Map<String, Object> result = new HashMap<String,Object>();
        result.put("res", res);
        System.out.println(res);
        result.put("message", res > 0 ? "删除成功" : "删除失败");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(JsonUtil.getJSON(result));
        writer.flush();
        writer.close();

    }

    @RequestMapping("go_updateCp.html")
    public String goUpdate(Integer id, Model model){
        Cp cp = cpSevice.getCpById(id);
        model.addAttribute("cp",cp);
        return "updateCp";
    }

    @RequestMapping("editCp.html")
    @ResponseBody
    public String update(Cp cp) {
            cpSevice.updateCp(cp);
            return "ok";
    }
    @RequestMapping("addCp.html")
    @ResponseBody
    public String add(Cp cp) {
        cpSevice.addCp(cp);
        return "save";

    }
    @RequestMapping("listCpEasyui.html")
    public String page(){
        return "listCpEasyui";
    }
    @RequestMapping("table.html")
    @ResponseBody
    public Map<String,Object> cp(String name, Integer page, Integer rows){
        Map<String,Object> result=new HashMap<String, Object>();
        PageInfo<Cp> pageInfo=cpSevice.getAllCpPage(name,page,rows);
        result.put("total",pageInfo.getTotal());//一共多少条
        result.put("rows",pageInfo.getList());
        return result;
    }
}
