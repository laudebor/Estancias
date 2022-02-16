package estancias.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {
    
    protected Connection con = null;
    protected ResultSet res = null;
    protected Statement stm = null;
    
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "estancias_exterior";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    
    
    public void ConectarBase() throws ClassNotFoundException, SQLException{
        try{
            Class.forName(DRIVER);
            String url = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            con = DriverManager.getConnection(url, USER, PASSWORD);
        }catch(ClassNotFoundException | SQLException e){
            throw e;
        }
    }
    
    public void DesconectarBase() throws Exception{
        try{
            if(con!=null){
                con.close();
            }
            if(res!=null){
                res.close();
            }
            if(stm!=null){
                stm.close();
            }
        }catch(Exception e){
            throw e;
        }
    }
    
    public void ModificarBase(String sql) throws Exception{
        try{
            ConectarBase();
            stm = con.createStatement();
            stm.executeUpdate(sql);
            
        }catch(Exception e){
            throw e;
        }finally{
            DesconectarBase();
        }
    }
    
    public void ConsultarBase(String sql) throws Exception{
        try{
            ConectarBase();
            stm = con.createStatement();
            res = stm.executeQuery(sql);
        }catch(Exception e){
            throw e;
        }finally{
            DesconectarBase();
        }
    }
    
}
