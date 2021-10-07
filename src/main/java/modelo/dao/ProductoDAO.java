/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexiones.ConexionMysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dto.ProductoDTO;

/**
 *
 * @author PC
 */
public class ProductoDAO implements Contrato<ProductoDTO> {

    private static final String SQL_READALL = "SELECT * FROM tb_producto;";
    private static final String SQL_INSERT = "INSERT INTO tb_producto "
            + "(nombre_producto, descripcion_producto, unidades, valor) "
            + "VALUES (?,?,?,?);";
    private static final String SQL_READ = "SELECT * FROM tb_producto WHERE id_producto = ?;";
    private static final String SQL_DELETE = "DELETE FROM tb_producto WHERE id_producto = ?;";
    private static final String SQL_UPDATE = "UPDATE tb_producto SET "
            + "nombre_producto=?, descripcion_producto=?, unidades=?, valor=? WHERE id_producto = ?;";
    private final ConexionMysql con = ConexionMysql.getInstance();

    public ProductoDAO() {
    }

    @Override
    public boolean create(ProductoDTO obj) {

        PreparedStatement psnt = null;

        try {
            psnt = con.getCnn().prepareStatement(SQL_INSERT);
            psnt.setString(1, obj.getNombre_pro());
            psnt.setString(2, obj.getNombre_pro());
            psnt.setInt(3, obj.getUnidades_pro());
            psnt.setInt(4, obj.getValor_pro());
            int r = psnt.executeUpdate();
            System.out.println("Respuesta:" + r);
            if (r > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error 5 " + ex.getMessage());
        } finally {
            if (psnt != null) {
                try {
                    psnt.close();
                } catch (SQLException ex) {
                    System.out.println("Error 6 " + ex.getMessage());
                }
            }
            con.CerrarConexion();
        }
        return false;
    }

    @Override
    public List<ProductoDTO> readAll() {
        List<ProductoDTO> lst = null;

        PreparedStatement psnt = null;
        ResultSet rs = null;

        try {
            lst = new ArrayList<ProductoDTO>();
            psnt = con.getCnn().prepareStatement(SQL_READALL);
            rs = psnt.executeQuery();
            while (rs.next()) {
                ProductoDTO obj = new ProductoDTO(rs.getInt("id_producto"), rs.getString("nombre_producto"), rs.getString("descripcion_producto"), rs.getInt("unidades"), rs.getInt("valor"));
                lst.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (psnt != null) {
                    psnt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error4 " + ex.getMessage());
            }
            con.CerrarConexion();
        }

        return lst;
    }

    @Override
    public ProductoDTO read(ProductoDTO filter) {
        ProductoDTO objP = null;

        PreparedStatement psnt = null;
        ResultSet rs = null;
        try {
            psnt = con.getCnn().prepareStatement(SQL_READ);
            psnt.setInt(1, filter.getId_pro());
            rs = psnt.executeQuery();
            if (rs.next()) {
                objP = new ProductoDTO(rs.getInt("id_producto"), rs.getString("nombre_producto"), rs.getString("descripcion_producto"),
                        rs.getInt("unidades"), rs.getInt("valor"));
            }
        } catch (SQLException ex) {
            System.out.println("Error7 " + ex.getMessage());
        } finally {
            try {
                if (psnt != null) {
                    psnt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error8 " + ex.getMessage());
            }
            con.CerrarConexion();
        }

        return objP;
    }

    @Override
    public boolean update(ProductoDTO obj) {
        
        PreparedStatement psnt = null;
        try {
            psnt = con.getCnn().prepareStatement(SQL_UPDATE);
            psnt.setString(1, obj.getNombre_pro());
            psnt.setString(2, obj.getDescripcion_pro());
            psnt.setInt(3, obj.getUnidades_pro());
            psnt.setInt(4, obj.getValor_pro());
            psnt.setInt(5, obj.getId_pro());
            int res = psnt.executeUpdate();
            if(res>0){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error11 "+ex.getMessage());
        }finally{
            try {
                if(psnt!=null){
                psnt.close();
                }                
            } catch (SQLException ex) {
                System.out.println("Error12 "+ex.getMessage());
            }
            con.CerrarConexion();
        }
     return false;   
    }

    @Override
    public boolean delete(ProductoDTO obj) {

        PreparedStatement psnt = null;

        try {
            psnt = con.getCnn().prepareStatement(SQL_DELETE);
            psnt.setInt(1, obj.getId_pro());
            int rest = psnt.executeUpdate();
            if (rest > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error9 " + ex.getMessage());
        } finally {
            try {
                if (psnt != null) {
                    psnt.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error10 " + ex.getMessage());
            }
            con.CerrarConexion();
        }

        return false;
    }

}
