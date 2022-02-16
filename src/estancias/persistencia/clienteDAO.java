package estancias.persistencia;

import estancias.entidades.Cliente;

public final class clienteDAO extends DAO {
    
    public void GuardarCliente(Cliente cliente) throws Exception{
        try{
            if(cliente==null){
                throw new Exception("Debe indicar un cliente");
            }
            String sql = "INSERT INTO clientes(nombre,calle,numero,codigo_postal,ciudad,pais,email)" 
                    + "VALUES + ('" + cliente.getNombre() + "', '" + cliente.getCalle() + "', '" 
                    + cliente.getNumero() + "', '" + cliente.getCodigo_postal() + "', '" + cliente.getCiudad() 
                    + "', '" + cliente.getPais() + "', '" + cliente.getEmail() + "')";
            ModificarBase(sql);
            
        }catch(Exception e){
            throw e;
        }finally{
            DesconectarBase();
        }
    }
    
    public Cliente BuscarClientePorEmail(String email) throws Exception{
        try{
            String sql = "SELECT * FROM clientes WHERE email = '" + email + "'";
            Cliente cliente = null;
            ConsultarBase(sql);
            while(res.next()){
                cliente = new Cliente();
                cliente.setNombre(res.getString(2));
                cliente.setCalle(res.getString(3));
                cliente.setNumero(res.getInt(4));
                cliente.setCodigo_postal(res.getString(5));
                cliente.setCiudad(res.getString(6));
                cliente.setPais(res.getString(7));
                cliente.setEmail(res.getString(8));
            }
            return cliente;
        }catch(Exception e){
            throw e;
        }finally{
            DesconectarBase();
        }
    }
}
