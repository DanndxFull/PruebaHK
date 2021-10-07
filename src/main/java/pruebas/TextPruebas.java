/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import conexiones.ConexionMysql;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.ProductoDAO;
import modelo.dao.UsuarioDAO;
import modelo.dto.ProductoDTO;
import modelo.dto.UsuarioDTO;

/**
 *
 * @author PC
 */
public class TextPruebas {

    public static void main(String[] args) {
//        ConexionMysql con = ConexionMysql.getInstance();
//        PreparedStatement psnt = null;
//        ResultSet rs = null;
//        try {
//            psnt = con.getCnn().prepareStatement("SELECT * FROM tb_producto;");
//            rs = psnt.executeQuery();
//            while(rs.next()){
//                System.out.println(rs.getString("nombre_producto"));
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error2 "+ex.getMessage());        
//        }finally{
//            try {
//                if(psnt!=null){
//                psnt.close();
//                }
//                if(rs!=null){
//                rs.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println("Error3 "+ex.getMessage());
//            }            
//            con.CerrarConexion();
//        }
        //text para consulta
        /*ProductoDAO objDAO = new ProductoDAO();
        List<ProductoDTO> lst = objDAO.readAll();
        for (ProductoDTO p : lst) {
            System.out.println(p);
        }*/

        //text para crear
        /*ProductoDTO objDTO = new ProductoDTO("Platanos", "Maduro", 20, 1000);
        if (objDAO.create(objDTO)) {
            System.out.println("Se creo con exito");
        } else {
            System.out.println("No se pudo crear");
        }

        lst = objDAO.readAll();
        for (ProductoDTO p : lst) {
            System.out.println(p);
        }*/
        
        //text leer
        /*ProductoDTO f = new ProductoDTO();
        f.setId_pro(22);
        f = objDAO.read(f);
        if (f != null) {
            System.out.println(f);
        } else {
            System.out.println("No se encontro el registro");
        }*/
        
        //text eliminar
        /*ProductoDTO elim = new ProductoDTO();
        elim.setId_pro(10);
        if(objDAO.delete(elim)){
            System.out.println("Se elimino con exito");
        }else{
            System.out.println("No se pudo eliminar");
        }
        lst = objDAO.readAll();
        for (ProductoDTO p : lst) {
            System.out.println(p);
        }*/
        
        //text actualizar
        /*ProductoDTO act = new ProductoDTO(9,"pasta", "dorian", 20, 1500);
        if(objDAO.update(act)){
            System.out.println("Se actualizo con exito");
        }else{
            System.out.println("No se pudo actualizar");
        }
        lst = objDAO.readAll();
        for (ProductoDTO p : lst) {
            System.out.println(p);
        }*/
        
        
        //text Usuarios
        
        //text leer todo
        UsuarioDAO objDAO = new UsuarioDAO();
        List<UsuarioDTO> lst = objDAO.readAll();
        for (UsuarioDTO p : lst) {
            System.out.println(p);
        }
        
        //text crear
        /*Date d = new Date(2002, 4, 14);
        UsuarioDTO objU = new UsuarioDTO("Daniel", "Mauricio", "Torres", "Martinez", "1000125751", "dmtm1404@gmail.com", "pato", "M", d, 1);
        if(objDAO.create(objU)){
            System.out.println("Se creo el usuario con exito");
        }else{
            System.out.println("No se pudo crear el usuario");
        }*/
        
        //text leer
        /*UsuarioDTO f = new UsuarioDTO();
        f.setId(3);
        f = objDAO.read(f);
        if (f != null) {
            System.out.println(f);
        } else {
            System.out.println("No se encontro el registro");
        }*/
        
        
        //text eliminar
        /*UsuarioDTO elim = new UsuarioDTO();
        elim.setId(11);
        if(objDAO.delete(elim)){
            System.out.println("Se elimino con exito");
        }else{
            System.out.println("No se pudo eliminar");
        }*/
        
        //text actualizar
        /*Date d = new Date(2001, 6, 21);
        UsuarioDTO act = new UsuarioDTO(7,"Maria", "Cadelo","Sanchez","Smith","10582701", "mcss@gmail.com","ganso","F", d, 1);
        if(objDAO.update(act)){
            System.out.println("Se actualizo con exito");
        }else{
            System.out.println("No se pudo actualizar");
        }*/
        
        
        
        lst = objDAO.readAll();
        for (UsuarioDTO p : lst) {
            System.out.println(p);
        }
    }

}
