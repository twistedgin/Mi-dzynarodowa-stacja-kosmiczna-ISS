package database.dao;

import database.entity.UpcomingEvent;

import java.util.List;

public interface UpcomingEventDao {

    void save(UpcomingEvent upcomingEvent);   //C U
    UpcomingEvent findById(Long id);          //R
    List<UpcomingEvent> findAll();            //R
    void deleteById(Long id);                 //D
}
