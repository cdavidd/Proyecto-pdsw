package edu.eci.pdsw.samples.services;

import javax.persistence.PersistenceException;

public class ExcepcionServicesBanco extends Exception {
    
    public ExcepcionServicesBanco(String string, PersistenceException ex) {
            // TODO Auto-generated constructor stub     
    }

    public ExcepcionServicesBanco(String string) {
            // TODO Auto-generated constructor stub
            super(string);
    }
}
