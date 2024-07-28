/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Configuracion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    //Metodo Buscar
    public Producto buscar(int id){
        Producto p=new Producto();//instanciamos la clase producto
        String sql="select *from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setIdProducto(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPre(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return p;
    }
    //Metodo Actualizar stock
    public int actualizarStock( int id, int stock){        
        String sql="update producto set Stock=? Where IdProducto=?";        
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    //Metodo Listar
    public List listar() {
        //Necesitamos un a variable de tipo String para la Consulta SQL
        String sql = "select * from producto";
        List<Producto> lista = new ArrayList<Producto>();

        //Luego se necesita un try-catch
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setIdProducto(rs.getInt(1));
                pro.setNom(rs.getString(2));
                pro.setPre(rs.getDouble(3));
                pro.setStock(rs.getInt(4));
                pro.setEstado(rs.getString(5));

                //Todo el objecto l o agregamos a la variable lista
                lista.add(pro);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    //Metodo Agregar

    public int agregar(Producto pro) {
        //Necesitamos un a variable de tipo String para la Consulta SQL
        String sql = "insert into producto(Nombres,Precio, Stock, Estado) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);            
            ps.setString(1, pro.getNom());
            ps.setDouble(2, pro.getPre());
            ps.setInt(3, pro.getStock());
            ps.setString(4, pro.getEstado());
            ps.executeUpdate();

        } catch (Exception e) {
        }

        return r;
    }

    //MEtodo para listar ID
    public Producto listarId(int id) {
        Producto pro=new Producto();
        String sql = "select * from producto where IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                pro.setNom(rs.getString(2));
                pro.setPre(rs.getDouble(3));
                pro.setStock(rs.getInt(4));
                pro.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return pro;
    }

    //metodo Editar
    public int actualizar(Producto pro) {
        //Necesitamos un a variable de tipo String para la Consulta SQL
        String sql = "update producto set Nombres=?, Precio=?,Stock=?, Estado=? Where IdProducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNom());
            ps.setDouble(2, pro.getPre());
            ps.setInt(3, pro.getStock());
            ps.setString(4, pro.getEstado());
            ps.setInt(5, pro.getIdProducto());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    //Metodo Delete
    public void delete(int id) {
        String sql = "delete from producto Where IdProducto=" + id;
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

}
