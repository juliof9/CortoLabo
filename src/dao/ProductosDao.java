/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.conexion;
import interfaces.metodos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.producto;

/**
 *
 * @author LN710Q
 */
public class ProductosDao implements metodos<producto>{
    
    private static final String SQL_INSERT ="INSERT INTO productos(codProducto, precio, nombre, cantidad, tipo, disponibilidad) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE ="UPDATE productos SET codigo =?,precio=?, nombre = ?, cantidad=?, tipo=?, disponibilidad =? WHERE codProducto=?";
    private static final String SQL_DELETE = "DELETE FROM productos WHERE codProducto=?";
    private static final String SQL_READ ="SELECT * FROM productos WHERE codProducto=?";
    private static final String SQL_READALL ="SELECT * FROM productos";

    private static final conexion con=conexion.conectar();
    
    @Override
    public boolean create(producto g) {
        PreparedStatement ps;
        try{
            ps = (PreparedStatement) con.getCnx().prepareStatement(SQL_INSERT);
            ps.setString(1,g.getCodigo());
            ps.setString(2, g.getTipo());
            ps.setInt(3,g.getPrecio());
            ps.setBoolean(4, true);
            if(ps.executeUpdate()> 0){
                return true;
            }           
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(ProductosDao.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            con.cerrarconexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
    
        PreparedStatement ps;
        try{
            ps= (PreparedStatement) con.getCnx().prepareStatement(SQL_DELETE);
            ps.setString(1,key.toString());
            
            if(ps.executeUpdate()> 0){
                return true;
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(ProductosDao.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            con.cerrarconexion();
        }
        return false;
    }

    @Override
    public boolean update(producto c) {
       PreparedStatement ps;
       try{
           System.out.println(c.getCodigo());
           ps=(PreparedStatement) con.getCnx().prepareStatement(SQL_UPDATE);
           ps.setString(1,c.getTipo());
           ps.setInt(2, c.getPrecio());
           ps.setBoolean(3, c.getDisponibilidad());
           ps.setString(4, c.getCodigo());
           if (ps.executeUpdate()>0){
               return true;
           }
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
           Logger.getLogger(ProductosDao.class.getName()).log(Level.SEVERE,null,ex);
       }finally{
           con.cerrarconexion();
       }
       return false;
    }

    @Override
    public producto read(Object key) {
       producto f=null;
       PreparedStatement ps;
       ResultSet rs;
       try{
           ps = (PreparedStatement) con.getCnx().prepareStatement(SQL_READ);
           ps.setString(1,key.toString());
           
           rs=ps.executeQuery();
           while(rs.next()){
               f=new producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getBoolean(6));
           }
           rs.close();
           
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
           Logger.getLogger(ProductosDao.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           con.cerrarconexion();
       }
       return f;
    }

    @Override
    public ArrayList<producto> readAll() {
        ArrayList<producto> all = new ArrayList();
        Statement s;
        ResultSet rs;
        try{
            s = con.getCnx().prepareStatement(SQL_READALL);
            rs = s.executeQuery(SQL_READALL);
            while(rs.next()){
                all.add(new producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getBoolean(6)));
            }
            rs.close();
        } catch(SQLException ex){
            Logger.getLogger(ProductosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all;
    }
}
