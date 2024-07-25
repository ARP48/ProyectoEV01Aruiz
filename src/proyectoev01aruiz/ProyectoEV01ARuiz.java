
package proyectoev01aruiz;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProyectoEV01ARuiz {

    private static Connection cnx;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String usuario="root";
        String password="root";
        String url="jdbc:mysql://localhost:3306/usuarios";
        Connection cx;
        Statement st;
        ResultSet rs;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProyectoEV01ARuiz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            cnx=DriverManager.getConnection(url, usuario, password);
            st=cnx.createStatement();
            //Read
            rs=st.executeQuery("SELECT * FROM PERSONAS");
            rs.next();
            do {
                System.out.println(rs.getInt("ID")+":"+rs.getString("nombre")+":"+rs.getInt("edad"));
                
            } while (rs.next());  
            
            //insert
            st.executeUpdate("INSERT INTO PERSONAS VALUES(9,'Sierra','Frank',15 )");
            rs=st.executeQuery("SELECT * FROM PERSONAS");
            rs.next();
            do {
                System.out.println(rs.getInt("ID")+":"+rs.getString("nombre")+":"+rs.getInt("edad"));
                
            } while (rs.next());  
            
        } catch (SQLException ex) {
            Logger.getLogger(ProyectoEV01ARuiz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
