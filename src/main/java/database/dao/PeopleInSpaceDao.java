package database.dao;

import database.entity.PeopleInSpace;

import java.util.List;

public interface PeopleInSpaceDao {

    void save(PeopleInSpace peopleInSpace);   //C U
    PeopleInSpace findById(Long id);          //R
    List<PeopleInSpace> findAll();            //R
    void deleteById(Long id);                 //D
}

