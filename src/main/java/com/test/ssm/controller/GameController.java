package com.test.ssm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.test.ssm.pojo.Game;
import com.test.ssm.service.GameService;
import com.test.ssm.util.JsonUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GameController {
    @Autowired
    private GameService gameService;


    @RequestMapping("list.html")
    public ModelAndView list(Game game,Integer pageNum) {
        if(pageNum==null|| pageNum<1){
            pageNum=1;
        }
        PageInfo<Game> pageInfo = gameService.getAllGame(game,pageNum,2);
        return new ModelAndView("list", "pageInfo", pageInfo);
    }

    @RequestMapping("delete.html")
    public void delete(Integer id, HttpServletResponse response) throws Exception{
        int res = gameService.deleteGame(id);
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

    @RequestMapping("go_update.html")
    public String goUpdate(Integer id, Model model){
        Game game = gameService.getGameById(id);
        model.addAttribute("game",game);
        return "update";
    }

    @RequestMapping("edit.html")
    public String update(Game game,Integer id){
        if(id!=null){
            gameService.updateGame(game);
        }else {
            gameService.addGame(game);
        }
        return "redirect:list.html";
    }
}
