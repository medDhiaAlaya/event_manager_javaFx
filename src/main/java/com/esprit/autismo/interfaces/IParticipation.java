package com.esprit.autismo.interfaces;

import java.util.ArrayList;

public interface IParticipation<E> {
    void addParticipation(E e);
    ArrayList<E> getAllParticippation();
    boolean deleteParticipation(E e);
    void  getParticipationById(E e);

}
