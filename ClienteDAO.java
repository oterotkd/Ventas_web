package Modelo;

import Configuracion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    //Metodo para buscar el cliente en le formulario Generar Venta
    public Cliente buscar(String dni){
        Cliente cli=new Cliente();
        String sql="select * from cliente where Dni="+dni;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
              cli.setIdCliente(rs.getInt(1));
              cli.setDni(rs.getString(2));
              cli.setNom(rs.getString(3));
              cli.setDireccion(rs.getString(4));
              cli.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }   
        return cli;
    }
    
    
    //OPERACIONES CRUD
    //Metodo Listar
    public List listar() {
        //Necesitamos un a variable de tipo String para la Consulta SQL
        String sql = "select * from cliente";
        List<Cliente> lista = new ArrayList<Cliente>();

        //Luego se necesita un try-catch
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setIdCliente(rs.getInt(1));
                cli.setDni(rs.getString(2));
                cli.setNom(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setEstado(rs.getString(5));

                //Todo el objecto l o agregamos a la variable lista
                lista.add(cli);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    //Metodo Agregar

    public int agregar(Cliente cli) {
        //Necesitamos un a variable de tipo String para la Consulta SQL
        String sql = "insert into cliente(Dni,Nombres,Direccion,Estado)values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNom());
            ps.setString(3, cli.getDireccion());
            ps.setString(4, cli.getEstado());
            ps.executeUpdate();

        } catch (Exception e) {
        }

        return r;
    }

    //MEtodo para listar ID
    public Cliente listarId(int id) {
        Cliente cli = new Cliente();
        String sql = "select * from cliente where IdCliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setDni(rs.getString(2));
                cli.setNom(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return cli;
    }

    //metodo Editar
    public int actualizar(Cliente cli) {
        //Necesitamos un a variable de tipo String para la Consulta SQL
        String sql = "update cliente set Dni=?,Nombres=?, Direccion=?,Estado=? Where IdCliente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNom());
            ps.setString(3, cli.getDireccion());
            ps.setString(4, cli.getEstado());
            ps.setInt(5, cli.getIdCliente());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    //Metodo Delete
    public void delete(int id) {
        String sql = "delete from cliente Where IdCliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

}
