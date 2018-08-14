package io.pivotal.pal.tracker;

import javax.swing.*;
import java.time.LocalDate;
import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    HashMap<Long, TimeEntry> timeEntryMap = new HashMap<>();
    private Long counter = 1L;


    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry createdTimeEntry = new TimeEntry(counter++, timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());

        timeEntryMap.put(createdTimeEntry.getId(), createdTimeEntry);

        return createdTimeEntry;
    }

    public TimeEntry find(long id) {
        return timeEntryMap.get(id);
    }

    public List<TimeEntry> list() {
        //List<TimeEntry> timeEntryList  = new LinkedList<>();

       // List<TimeEntry> timeEntryList = (ArrayList)timeEntryMap.values();


        return new ArrayList<TimeEntry>(timeEntryMap.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {


        TimeEntry updatedTimeEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(),timeEntry.getHours());
        timeEntryMap.put(updatedTimeEntry.getId(), updatedTimeEntry);

        return updatedTimeEntry;
    }

    public void delete(long id) {

        timeEntryMap.remove(id);

    }

    //        Random rand = new Random();
//        long id = rand.nextLong();
//
//        long projectId=0;
//        long userId=0;
//        LocalDate date = null;
//        int hours=0;
//
//
//        TimeEntry timeEnt = new TimeEntry(projectId,userId,date,hours);
//        timeEnt.setProjectId(projectId);
//        timeEnt.setUserId(userId);
//        timeEnt.setDate(date);
//        timeEnt.setHours(hours);
//        timeEntryMap.put(id,timeEnt);
//
//
//        return timeEntryMap.get(id);


    //TimeEntry createdTimeEntry = timeEntryRepository.create(timeEntry);
}
