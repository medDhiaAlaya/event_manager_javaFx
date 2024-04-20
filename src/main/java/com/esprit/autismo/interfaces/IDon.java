package com.esprit.autismo.interfaces;

import java.util.ArrayList;

public interface IDon <D>{

    void addDon(D d);
    void deleteDon(D d);
    void updateDon(D d);
    ArrayList<D> getDons();

}
