package inventarisbarang;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class koneksi {
    public static Connection setKoneksi() {
        String konString = "jdbc:mysql://localhost:3306/db_inventaris_gudang";
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(konString, "root", "");
            System.out.println("Koneksi Berhasil");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Koneksi Gagal");
        } catch (SQLException ex){
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Koneksi Gagal");
        }
        return conn;
    }
    
    public static int execute(String SQL){
        int status = 0;
        Connection conn = setKoneksi();
        try {
            Statement st = conn.createStatement();
            status = st.executeUpdate(SQL);
        } catch (SQLException ex){
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    public static ResultSet executeQuery(String SQL){
        ResultSet rs = null;
        Connection conn = setKoneksi();
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(SQL);
        } catch (SQLException ex){
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
