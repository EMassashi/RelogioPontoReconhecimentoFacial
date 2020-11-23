package controller;

import view.Login;
import view.MenuAdmin;
import view.MenuUser;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import util.ConectaBanco;
import java.sql.SQLException;

public class LoginController {
    ConectaBanco conecta = new ConectaBanco();

    private final Login view;

    public LoginController(Login view) {
        this.view = view;
    }

    public void login(JComboBox combo_user, JPasswordField txt_pass, JLabel message_txt) {
        conecta.conexao();
        try {
            conecta.executaSQL("SELECT * FROM login WHERE username='" + combo_user.getSelectedItem() + "'");
            conecta.rs.first();
            if (conecta.rs.getString("password").equals(txt_pass.getText())) {
                if(conecta.rs.getInt("isadmin") == 0){
                    new MenuUser().setVisible(true);
                    System.out.println("logou como usuario");
                    view.dispose();
                }else {
                    if(conecta.rs.getInt("isadmin") == 1) {
                        new MenuAdmin().setVisible(true);
                        System.out.println("logou como admin");
                        view.dispose();
                    }
                }
            }else{
                message_txt.setText("Senha inválida!");
                message_txt.setForeground(new Color(202, 66, 66));
            }
        } catch (NullPointerException | SQLException ex) {
            message_txt.setText("Usuário não existe!");
            message_txt.setForeground(new Color(202, 66, 66));
        }
        conecta.desconecta();
    }
}
