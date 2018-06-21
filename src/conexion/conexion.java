package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexion {
    private String user;
    private String pass;
    private String driver;
    private String url;
    
    private Connection cnx;
    
    public static conexion instance;
    
    public synchronized static conexion conectar(){
        if(instance == null)
        {
            return new conexion();
        }
        return instance;
    }
    private conexion(){
        cargarcredenciales();
        
        try{
            Class.forName(this.driver);
            cnx = (Connection) DriverManager.getConnection(this.url, this.user, this.pass);      
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    public void cargarcredenciales(){
        user="root";
        pass="";
        driver="com.mysql.jdbc.Driver";
        url="jdbc:mysql:/localhost/cortolabo";
    }
    public Connection getCnx(){
        return cnx;
    }
    
    public void cerrarconexion()
    {
            instance=null;
    }
}
