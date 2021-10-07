/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;

/**
 *
 * @author PC
 */
public interface Contrato <CualquierCosa> {
    
    boolean create(CualquierCosa obj);
    public List<CualquierCosa> readAll();
    public CualquierCosa read(CualquierCosa filter);
    public boolean update(CualquierCosa obj);
    public boolean delete(CualquierCosa obj);
}
