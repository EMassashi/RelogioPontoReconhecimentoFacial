package controller;

import util.ConectaBanco;
import model.ModelTable;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class ChecklistController {

    ConectaBanco conecta = new ConectaBanco();

    public void fillTable(String SQL, JTable tabela) {
        String id = null;

        conecta.conexao();
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"ID", "", "Date", "Name", "Function", "Phone"};
        conecta.executaSQL(SQL);
        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{
                    conecta.rs.getString("c.id"),
                    "",
                    conecta.rs.getString("c.date"),
                    conecta.rs.getString("p.first_name") + " " + conecta.rs.getString("p.last_name"),
                    conecta.rs.getString("p.office"),
                    conecta.rs.getString("p.phone_number"),});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(rootPane, "Lista de Cadastro Vazia!");
        } finally {
            conecta.desconecta();
        }

        ModelTable modelo = new ModelTable(dados, Colunas);
        tabela.setModel((TableModel) modelo);
        //tabela.getColumnModel().getColumn(0).setCellRenderer(new ChecklistController.ImageRenderer());
        tabela.getColumnModel().getColumn(1).setMaxWidth(0);
        tabela.getColumnModel().getColumn(1).setMinWidth(0);
        tabela.getColumnModel().getColumn(2).setMaxWidth(999);
        tabela.getColumnModel().getColumn(2).setMinWidth(150);
        tabela.getColumnModel().getColumn(3).setMinWidth(150);
        tabela.getColumnModel().getColumn(4).setMinWidth(125);
        tabela.getColumnModel().getColumn(5).setMinWidth(150);
        tabela.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tabela.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    class ImageRenderer implements TableCellRenderer {

        public JLabel lbl = new JLabel();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            try {
                Object text = table.getValueAt(row, 1);
                File image = new File("C:\\photos\\person." + text + ".1.jpg");
                String path = image.getAbsolutePath();
                ImageIcon i = new ImageIcon(new ImageIcon(String.valueOf(path)).getImage().getScaledInstance(lbl.getWidth() + 50, lbl.getHeight() + 50, Image.SCALE_SMOOTH));
                lbl.setIcon(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return lbl;
        }
    }

}
