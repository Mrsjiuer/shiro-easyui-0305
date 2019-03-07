package com.test.ssm.dao;

import com.test.ssm.pojo.Game;

import java.util.List;

public interface GameDAOInterfase {
    List<Game> getAllGame(Game game);
    Game getGameById(Integer id);
   void addGame(Game game);
   void updateGame(Game game);
    int deleteGame(Integer id);
}
