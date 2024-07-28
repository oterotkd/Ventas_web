/*
 *Esta clase esta relaciaonada con la base de datos, este metodo se ejecutará 
con la orden del controlador*/
package Modelo;

import Configuracion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Empleado validar(String user, String dni) {
        Empleado em = new Empleado();
        String sql = "select * from empleado where User=? and Dni=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));//con estos datos va a funcionar; pero si queremnos traer todos los datos de la tabla 
                //entonces:
                em.setTel(rs.getString("Telefono"));
                em.setNom(rs.getString("Nombres"));
                em.setRol(rs.getString("Rol"));
            }

        } catch (Exception e) {
        }
        return em;
    }
    //Operaciones CRUD
    
    //Metodo Listar
    public List listar(){
        //Necesitamos un a variable de tipo String para la Consulta SQL
        String sql="select * from empleado";    
        List<Empleado>lista=new ArrayList<>(); 
       
        //Luego se necesita un try-catch
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                em.setRol(rs.getString(7));
                //Todo el objecto l o agregamos a la variable lista
                lista.add(em);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    //Metodo Agregar

    public int agregar(Empleado em) {
        //Necesitamos una variable de tipo String para la Consulta SQL
        String sql="insert into empleado(Dni,Nombres,Telefono,Estado,User, Rol)values(?,?,?,?,?,?)";  
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,em.getDni());
            ps.setString(2,em.getNom());
            ps.setString(3,em.getTel());
            ps.setString(4,em.getEstado());
            ps.setString(5,em.getUser());
            ps.setString(6,em.getRol());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }

        return r;
    }
    //MEtodo para listar ID
    public Empleado listarId(int id){
        Empleado emp=new Empleado();
        String sql="select * from empleado where IdEmpleado="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();            
            while (rs.next()){
                emp.setDni(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setTel(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
                emp.setRol(rs.getString(7));
            }
        } catch (Exception e) {
        }
        return emp;
    }

    //metodo Editar
    public int actualizar(Empleado em) {
        //Necesitamos un a variable de tipo String para la Consulta SQL
        String sql="update empleado set Dni=?,Nombres=?, Telefono=?,Estado=?,User=?,Rol=? Where IdEmpleado=?";  
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,em.getDni());
            ps.setString(2,em.getNom());
            ps.setString(3,em.getTel());
            ps.setString(4,em.getEstado());
            ps.setString(5,em.getUser());
            ps.setString(6,em.getRol());
            ps.setInt(7, em.getId());
           
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return r;
    }

    //Metodo Delete
    public void delete(int id) {
        String sql="delete from empleado Where IdEmpleado="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);           
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }
}
