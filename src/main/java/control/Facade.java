/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import modelo.dao.ProductoDAO;
import modelo.dto.ProductoDTO;

/**
 *
 * @author PC
 */
public class Facade {

    public Facade() {
    }

        
    public List<ProductoDTO> listarProductos() {
        ProductoDAO objDAO = new ProductoDAO();
        return objDAO.readAll();
    }

}
