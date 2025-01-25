package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GameDAOImpl implements GameDAO {

    private EntityManager entityManager;

    @Autowired
    public GameDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Game> getAll() {
        TypedQuery<Game> theQuery = entityManager.createQuery("select s FROM Game s", Game.class);
        return theQuery.getResultList();
    }

    @Override
    public Game getGameById(int id) {
        return entityManager.find(Game.class, id);
    }
}
