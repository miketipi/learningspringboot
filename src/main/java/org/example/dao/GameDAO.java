package org.example.dao;

import org.example.entity.Game;

import java.util.List;

public interface GameDAO {
    List<Game> getAll();
    Game getGameById(int id);
}
