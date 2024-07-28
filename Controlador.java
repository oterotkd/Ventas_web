/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Configuracion.GenerarSerie;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.io.IOException; 
import java.util.ArrayList; 
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    int ide;

    Cliente cli = new Cliente();
    ClienteDAO clidao = new ClienteDAO();
    int idcli;

    Producto pro = new Producto();
    ProductoDAO prodao = new ProductoDAO();
    int idpro;

    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item=0, cant;
    int cod;
    String descripcion;
    Double precio, subtotal, totalPagar;//estas son todad las variables que vamos a usar en el formulario RegistrarVenta,jsp

    //instanciomaosla la clase VentaDAO
    VentaDAO vdao = new VentaDAO();
    //Variable para el numero de Serie, estas dos ultimas VentasDAO y numeroserie se necesitan para generar el numero se serie
    String numeroserie;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu == null) {
            response.sendRedirect("index.jsp");
            return;
        }
        /*Redirecciono al Ifreme segun el tipo de Rol del usuario,si es Admin se dirige la jsp 
        principal para el rol del administrador y así segun el caso
         */
        if (menu.equals("Admin")) {
            request.getRequestDispatcher("AdminPrincipal.jsp").forward(request, response);
        }
        if (menu.equals("Almacen")) {
            System.out.println("Redirigiendo a Pagina Principal del Almacenista");  // Mensaje de depuración
            request.getRequestDispatcher("AlmaPrincipal.jsp").forward(request, response);
        }
        if (menu.equals("Caja")) {
            System.out.println("Redirigiendo a PaginaPrincipal  Cajer@");  // Mensaje de depuración           
            request.getRequestDispatcher("CajaPrincipal.jsp").forward(request, response);
        }

        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List<Empleado> lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    // Lógica para agregar un empleado
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTelefono");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUsuario");
                    String rol = request.getParameter("txtRol");/* de esta manera, estas variables están almacenanado 
                    los datos ingresados en estas cajas de texto, luego ejecurtamos el metodo agregar de nuestra varible edao. */

                    //para agregar dentro del objecto estos valores usamos la variable (em) para cada atributo, 
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    em.setRol(rol);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    // Lógica para editar un empleado
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;
                // Lógica para Actualizar un empleado
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTelefono");
                    String est1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUsuario");
                    String rol1 = request.getParameter("txtRol");/* de esta manera, estas variables están almacenanado 
                    los datos ingresados en estas cajas de texto, luego ejecurtamos el metodo agregar de nuestra varible edao. */
                    //para agregar dentro del objecto estos valores usamos la variable (em) para cada atributo, 
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setRol(rol1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    // Lógica para eliminar un empleado
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;
            }
            // Despacha la solicitud a la página JSP después de ejecutar la acción
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if (menu.equals("Cliente")) {

            switch (accion) {
                case "Listar":
                    List<Cliente> lista = clidao.listar();
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    // Lógica para agregar un Cliente
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String dir = request.getParameter("txtDireccion");
                    String est = request.getParameter("txtEstado");
                    /* de esta manera, estas variables están almacenanado 
                    los datos ingresados en estas cajas de texto, luego ejecurtamos el metodo agregar de nuestra varible clidao. */

                    //para agregar dentro del objecto estos valores usamos la variable (cli) para cada atributo, 
                    cli.setDni(dni);
                    cli.setNom(nom);
                    cli.setDireccion(dir);
                    cli.setEstado(est);
                    clidao.agregar(cli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    // Lógica para editar un Cliente
                    idcli = Integer.parseInt(request.getParameter("id"));
                    Cliente cl = clidao.listarId(idcli);
                    request.setAttribute("cliente", cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

                    break;
                // Lógica para Actualizar un Cliente
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String dir1 = request.getParameter("txtDireccion");
                    String est1 = request.getParameter("txtEstado");
                    /* de esta manera, estas variables están almacenanado 
                    los datos ingresados en estas cajas de texto, luego ejecurtamos el metodo agregar de nuestra varible clidao. */

                    //para agregar dentro del objecto estos valores usamos la variable (cli) para cada atributo, 
                    cli.setDni(dni1);
                    cli.setNom(nom1);
                    cli.setDireccion(dir1);
                    cli.setEstado(est1);
                    cli.setIdCliente(idcli);
                    clidao.actualizar(cli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    // Lógica para eliminar un Cliente
                    idcli = Integer.parseInt(request.getParameter("id"));
                    clidao.delete(idcli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
            }
            // Despacha la solicitud a la página JSP después de ejecutar la acción
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }

        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List<Producto> lista = prodao.listar();
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar":
                    // Lógica para agregar un Producto
                    String nom = request.getParameter("txtNombres");
                    double pre = Double.parseDouble(request.getParameter("txtPre"));
                    int stock = Integer.parseInt(request.getParameter("txtStock"));
                    String est = request.getParameter("txtEstado");
                    /* de esta manera, estas variables están almacenanado 
                    los datos ingresados en estas cajas de texto, luego ejecurtamos el metodo agregar de nuestra varible prodao. */

                    //para agregar dentro del objecto estos valores usamos la variable (pro) para cada atributo, 
                    pro.setNom(nom);
                    pro.setPre(pre);
                    pro.setStock(stock);
                    pro.setEstado(est);
                    prodao.agregar(pro);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    // Lógica para editar un Producto
                    idpro = Integer.parseInt(request.getParameter("id"));
                    Producto pr = prodao.listarId(idpro);
                    request.setAttribute("producto", pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;
                // Lógica para Actualizar un Producto
                case "Actualizar":
                    String nom1 = request.getParameter("txtNombres");
                    double pre1 = Double.parseDouble(request.getParameter("txtPre"));
                    int stock1 = Integer.parseInt(request.getParameter("txtStock"));
                    String est1 = request.getParameter("txtEstado");
                    /* de esta manera, estas variables están almacenanado 
                    los datos ingresados en estas cajas de texto, luego ejecurtamos el metodo agregar de nuestra varible clidao. */

                    //para agregar dentro del objecto estos valores usamos la variable (pro) para cada atributo, 
                    pro.setNom(nom1);
                    pro.setPre(pre1);
                    pro.setStock(stock1);
                    pro.setEstado(est1);
                    pro.setIdProducto(idpro);
                    prodao.actualizar(pro);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    // Lógica para eliminar un empleado
                    idpro = Integer.parseInt(request.getParameter("id"));
                    prodao.delete(idpro);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;

            }
            // Despacha la solicitud a la página JSP después de ejecutar la acción
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("NuevaVenta")) {

            switch (accion) {
                case "BuscarCliente":

                    String dni = request.getParameter("codigocliente");//este parametro viene de la caja de texto 
                    cli.setDni(dni);
                    cli = clidao.buscar(dni);
                    request.setAttribute("cl", cli);//("cl") es ekl atributo que enviamos al formulario
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroserie);

                    break;
                case "BuscarProducto":

                    //Capturamos el (id) del producto de esta manera
                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    pro = prodao.buscar(id);//como parametro el (id) que hemos capturado desde la caja de texto, luedo enviamos los datos para que se muestren en el formulario asi;
                    request.setAttribute("producto", pro);//el nombre del atributo es(producto) y todo viene de la variable (pro)
                    request.setAttribute("lista", lista);
                    request.setAttribute("cl", cli);
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "Agregar":
                    v = new Venta();
                    totalPagar = 0.0;
                    item = item + 1;
                    cod = pro.getIdProducto();
                    descripcion = request.getParameter("nombreproducto");
                    precio = Double.valueOf(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cantidad"));
                    subtotal = precio * cant;//todos es tos valores se agregan al objecto venta por medio del formulario
                    v = new Venta();
                    v.setItem(item);
                    v.setIdProducto(cod);
                    v.setDescripcion(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);// despues de agregar a la lista todos los datos del objecto creamos un ciclo for
                    for (int i = 0; i < lista.size(); i++) {
                        // este ciclo recorre todos los datos que hay en la lista para que se almacene la sumatoria de todos los datos 
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);//("totalPagar") es el atributo y (totalPagar) es la variable que va en el foemulario
                    request.setAttribute("lista", lista);
                    request.setAttribute("cl", cli);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "GenerarVenta":
                    item=0;
                    //Actualizar Stock
                    /*esta for va a recorrer la cantidad de registros que tiene agregado el comprovante de pago*/
                    for (int i = 0; i < lista.size(); i++) {
                        Producto prod = new Producto();
                        int cantidad = lista.get(i).getCantidad();
                        int idproducto = lista.get(i).getIdProducto();
                        ProductoDAO proddao = new ProductoDAO();
                        prod = proddao.buscar(idproducto);
                        int Stock_Actualizado = prod.getStock() - cantidad;
                        proddao.actualizarStock(idproducto, Stock_Actualizado);
                    }
                    //Guarda los datos de la venta
                    v.setIdCliente(cli.getIdCliente());
                    v.setIdEmpleado(2);
                    v.setNumSerie(numeroserie);
                    v.setFecha("2024-05-06");
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vdao.guardarVenta(v);
                    //Guardar el detalle de ventas
                    int idv = Integer.parseInt(vdao.IdVentas());

                    for (int i = 0; i < lista.size(); i++) {
                        v = new Venta();
                        v.setId(idv);
                        v.setIdProducto(lista.get(i).getIdProducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleVenta(v);//agregamos todos los datos que estan en la lista
                    }
                    lista = new ArrayList<>();
                    break;
                case "Editar":
                    // Obtener el item a editar
                    int itemEditar = Integer.parseInt(request.getParameter("item"));
                    for (Venta venta : lista) {
                        if (venta.getItem() == itemEditar) {
                            request.setAttribute("ventaEditada", venta);
                            break;
                        }
                    }
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("cl", cli);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "Delete":
                    // Obtener el item a eliminar
                    int itemEliminar = Integer.parseInt(request.getParameter("id"));
                    lista.removeIf(venta -> venta.getItem() == itemEliminar);
                    // Recalcular el total a pagar después de eliminar el item
                    totalPagar = lista.stream().mapToDouble(Venta::getSubtotal).sum();
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("lista", lista);
                    request.setAttribute("cl", cli);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "Cancelar":
                    lista.clear();
                    totalPagar = 0.0;
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("lista", lista);
                    request.setAttribute("cl", cli);
                    request.setAttribute("nserie", numeroserie);
                    break;

                default:
                    v = new Venta();
                    numeroserie = vdao.GenerarSerie();
                    if (numeroserie == null) {
                        numeroserie = "00000001";
                        request.setAttribute("nserie", numeroserie);

                    } else {
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
        
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
