package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConectaBanco {

    public Statement stm;
    public ResultSet rs;
    public Connection conn;

    private final String driver = "org.mysql.Driver";
    private final String path = "jdbc:mysql://localhost:3306/facerecognition?useSSL=false";
    private final String user = "root";
    private final String pass = "dbpsw123";

    public void conexao() {
        try {
            System.setProperty("jdbc.Driver", driver);
            conn = DriverManager.getConnection(path, user, pass);
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco.");
        }
    }

    public void desconecta() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    public void executaSQL(String SQL) {
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(SQL);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            JOptionPane.showMessageDialog(null, "SQL Error: " + e);
        }
    }
}
