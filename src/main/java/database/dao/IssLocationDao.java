package database.dao;

import database.entity.IssLocation;

import java.util.List;

public interface IssLocationDao {//CRUD

        void save(IssLocation isslocation); //C U
        IssLocation findById(Long id); //R
        List<IssLocation> findAll(); //R
        void deleteById(Long id); //D


    }

