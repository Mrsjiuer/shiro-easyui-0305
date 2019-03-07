package com.test.ssm.service;

import com.github.pagehelper.PageInfo;
import com.test.ssm.pojo.Game;


public interface GameService {
     PageInfo<Game> getAllGame(Game game, Integer pageNum, Integer pageSize);
     Game getGameById(Integer id);
     void addGame(Game game);
     void updateGame(Game game);
     int deleteGame(Integer id);
}
