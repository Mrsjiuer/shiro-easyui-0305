package com.test.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.ssm.dao.GameDAOInterfase;
import com.test.ssm.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.ssm.pojo.Game;


@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDAOInterfase gameDAO;

    @Override
    public PageInfo<Game> getAllGame(Game game,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<Game>(gameDAO.getAllGame(game));
    }

    @Override
    public Game getGameById(Integer id) {
        return gameDAO.getGameById(id);
    }

    @Override
    public void addGame(Game game) {
         gameDAO.addGame(game);
    }

    @Override
    public void updateGame(Game game) {
         gameDAO.updateGame(game);
    }

    @Override
    public int deleteGame(Integer id) {
         return gameDAO.deleteGame(id);
    }
}
