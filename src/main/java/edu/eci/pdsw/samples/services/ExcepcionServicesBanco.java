/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import javax.persistence.PersistenceException;

/**
 *
 * @author 2125509
 */
public class ExcepcionServicesBanco extends Exception {
    	public ExcepcionServicesBanco(String string, PersistenceException ex) {
		// TODO Auto-generated constructor stub
	}

	public ExcepcionServicesBanco(String string) {
		// TODO Auto-generated constructor stub
	}
}
