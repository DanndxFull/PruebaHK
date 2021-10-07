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
import modelo.dto.UsuarioDTO;

/**
 *
 * @author PC
 */
public class UsuarioDAO implements Contrato<UsuarioDTO> {
    private static final String SQL_READALL = "SELECT * FROM tb_usuario;";
    private static final String SQL_INSERT = "INSERT INTO tb_usuario "
            + "(nombre1,nombre2,apellido1,apellido2,n_identificacion,correo,clave,sexo,fecha_nac,estado) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?);";
    private static final String SQL_READ = "SELECT * FROM tb_usuario WHERE id=?;";
    private static final String SQL_DELETE = "DELETE FROM tb_usuario WHERE id=?;";
    private static final String SQL_UPDATE = "UPDATE tb_usuario SET "
            + "nombre1=?,nombre2=?,apellido1=?,apellido2=?,n_identificacion=?,correo=?,clave=?,sexo=?,fecha_nac=?,estado=? WHERE id=?;";
    private final ConexionMysql con = ConexionMysql.getInstance();

    @Override
    public boolean create(UsuarioDTO obj) {
        PreparedStatement psnt = null;
        
        try{
            psnt = con.getCnn().prepareStatement(SQL_INSERT);
            psnt.setString(1, obj.getNombre1());
            psnt.setString(2, obj.getNombre2());
            psnt.setString(3, obj.getApellido1());
            psnt.setString(4, obj.getApellido2());
            psnt.setString(5, obj.getN_identificacion());
            psnt.setString(6, obj.getCorreo());
            psnt.setString(7, obj.getClave());
            psnt.setString(8, obj.getSexo());
            psnt.setDate(9, obj.getFecha_nac());
            psnt.setInt(10, obj.getEstado());
            int r = psnt.executeUpdate();
            System.out.println(r);
            if(r>0){
                return true;
            }
        }catch(SQLException ex){
            System.out.println("Error insertar usuario: "+ex.getMessage());
        }finally{
            if(psnt!=null){
                try {
                    psnt.close();
                } catch (SQLException ex) {
                    System.out.println("Error 13: "+ex.getMessage());
                }
            }
            con.CerrarConexion();
        }
        
    return false;    
    }

    @Override
    public List<UsuarioDTO> readAll() {
        List<UsuarioDTO> lst = null;

        PreparedStatement psnt = null;
        ResultSet rs = null;

        try {
            lst = new ArrayList<UsuarioDTO>();
            psnt = con.getCnn().prepareStatement(SQL_READALL);
            rs = psnt.executeQuery();
            while (rs.next()) {
                UsuarioDTO obj = new UsuarioDTO(rs.getInt("id"),rs.getString("nombre1"),rs.getString("nombre2"),
                        rs.getString("apellido1"),rs.getString("apellido2"),rs.getString("n_identificacion"),
                        rs.getString("correo"),rs.getString("clave"),rs.getString("sexo"),rs.getDate("fecha_nac"),
                        rs.getInt("estado"));
                lst.add(obj);
            }
        } catch (SQLException ex) {
            System.out.println("Error 14: "+ex.getMessage());
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
    public UsuarioDTO read(UsuarioDTO filter) {
        UsuarioDTO objU = null;
        PreparedStatement psnt = null;
        ResultSet rs = null;
        try {
            psnt = con.getCnn().prepareStatement(SQL_READ);
            psnt.setInt(1, filter.getId());
            rs = psnt.executeQuery();
            if (rs.next()) {
                objU = new UsuarioDTO(rs.getInt("id"),rs.getString("nombre1"),rs.getString("nombre2"),
                        rs.getString("apellido1"),rs.getString("apellido2"),rs.getString("n_identificacion"),
                        rs.getString("correo"),rs.getString("clave"),rs.getString("sexo"),rs.getDate("fecha_nac"),
                        rs.getInt("estado"));
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

        return objU;
    }

    @Override
    public boolean update(UsuarioDTO obj) {
        PreparedStatement psnt = null;
        try {
            psnt = con.getCnn().prepareStatement(SQL_UPDATE);
            psnt.setString(1, obj.getNombre1());
            psnt.setString(2, obj.getNombre2());
            psnt.setString(3, obj.getApellido1());
            psnt.setString(4, obj.getApellido2());
            psnt.setString(5, obj.getN_identificacion());
            psnt.setString(6, obj.getCorreo());
            psnt.setString(7, obj.getClave());
            psnt.setString(8, obj.getSexo());
            psnt.setDate(9, obj.getFecha_nac());
            psnt.setInt(10, obj.getEstado());
            psnt.setInt(11, obj.getId());
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
    public boolean delete(UsuarioDTO obj) {
        PreparedStatement psnt = null;

        try {
            psnt = con.getCnn().prepareStatement(SQL_DELETE);
            psnt.setInt(1, obj.getId());
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
