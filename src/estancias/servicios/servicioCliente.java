package estancias.servicios;

import estancias.entidades.Cliente;
import estancias.persistencia.clienteDAO;
import java.util.Scanner;

public class servicioCliente {
    
    Scanner scan = new Scanner(System.in);
    private clienteDAO dao;

    public servicioCliente() {
        dao = new clienteDAO();
    }
    
    public void crearCliente() throws Exception{
        try{
            Cliente cliente = new Cliente();
            System.out.println("----INGRESO NUEVO CLIENTE----");
            System.out.println("Email: "); String email = scan.next();
            while(dao.BuscarClientePorEmail(email)!=null){
                System.out.println("El cliente con email " + email + " ya existe. ");
            }
            cliente.setEmail(email);
            System.out.print("Nombre: "); cliente.setNombre(scan.next());
            System.out.print("Calle: "); cliente.setCalle(scan.next());
            System.out.print("Número: "); cliente.setNumero(scan.nextInt());
            System.out.print("Código postal: "); cliente.setCodigo_postal(scan.next());
            System.out.print("Ciudad: "); cliente.setCiudad(scan.next());
            System.out.print("País: "); cliente.setPais(scan.next());
            dao.GuardarCliente(cliente);
        }catch(Exception e){
            throw e;
        }
    }
}
