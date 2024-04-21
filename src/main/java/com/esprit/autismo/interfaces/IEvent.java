package com.esprit.autismo.interfaces;

import com.esprit.autismo.models.Event;

import java.util.ArrayList;
import java.util.List;

public interface IEvent<E> {
    void addEvent(E e);
    List<E> getAllEvents();
    void deleteEvent(E e);
    void updateEvent(E e);
    Event findEvent(int id);

}
