import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Sat Apr 11 15:39:50 IST 2020
 */



/**
 * @author Rohit
 */
public class Stock extends JFrame {
    /*public Stock(Window owner) {
        super(owner);
        initComponents();
    }*/

    public Stock(){
        initComponents();
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        try{
            Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");
            //String sql="select * from stock_history";
            //PreparedStatement ps=conn.prepareStatement(sql);
            if(conn!=null){
                //Statement st=conn.createStatement();
                //ResultSet rs=st.executeQuery("select * from stock_history");
                Statement st2=conn.createStatement();
                ResultSet rs2=st2.executeQuery("select * from product");
                int i=0;
                while (rs2.next()){
                    //table1
                    table1.getModel().setValueAt(rs2.getString("prodID"),i,0);
                    table1.getModel().setValueAt(rs2.getString("prodType"),i,1);
                    table1.getModel().setValueAt(rs2.getString("prodcat"),i,2);
                    table1.getModel().setValueAt(rs2.getString("prodSCat"),i,3);
                    table1.getModel().setValueAt(rs2.getString("prodQuantity"),i,4);
                    table1.getModel().setValueAt(rs2.getString("prodPrice"),i,5);
                    i++;
                }

            }
        }
        catch (Exception e1){

        }
    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
        for (int i = 0; i < table1.getRowCount(); i++) {
            for(int j = 0; j < table1.getColumnCount(); j++) {
                table1.setValueAt("", i, j);
            }
        }
        try{
            Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");
            //String sql="select * from stock_history";
            //PreparedStatement ps=conn.prepareStatement(sql);
            if(conn!=null){
                //Statement st=conn.createStatement();
                //ResultSet rs=st.executeQuery("select * from stock_history");
                Statement st2=conn.createStatement();
                ResultSet rs2=st2.executeQuery("select * from product where prodQuantity=0");
                int i=0;
                while (rs2.next()){
                    //table1
                    table1.getModel().setValueAt(rs2.getString("prodID"),i,0);
                    table1.getModel().setValueAt(rs2.getString("prodType"),i,1);
                    table1.getModel().setValueAt(rs2.getString("prodcat"),i,2);
                    table1.getModel().setValueAt(rs2.getString("prodSCat"),i,3);
                    table1.getModel().setValueAt(rs2.getString("prodQuantity"),i,4);
                    table1.getModel().setValueAt(rs2.getString("prodPrice"),i,5);
                    i++;
                }

            }
        }
        catch (Exception e2){

        }
    }

    private void button4MouseClicked(MouseEvent e) {
        // TODO add your code here
        for (int i = 0; i < table1.getRowCount(); i++) {
            for(int j = 0; j < table1.getColumnCount(); j++) {
                table1.setValueAt("", i, j);
            }
        }
        try{
            Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");
            //String sql="select * from stock_history";
            //PreparedStatement ps=conn.prepareStatement(sql);
            if(conn!=null){
                //Statement st=conn.createStatement();
                //ResultSet rs=st.executeQuery("select * from stock_history");
                Statement st2=conn.createStatement();
                ResultSet rs2=st2.executeQuery("select * from product where prodQuantity<5");
                int i=0;
                while (rs2.next()){
                    //table1
                    table1.getModel().setValueAt(rs2.getString("prodID"),i,0);
                    table1.getModel().setValueAt(rs2.getString("prodType"),i,1);
                    table1.getModel().setValueAt(rs2.getString("prodcat"),i,2);
                    table1.getModel().setValueAt(rs2.getString("prodSCat"),i,3);
                    table1.getModel().setValueAt(rs2.getString("prodQuantity"),i,4);
                    table1.getModel().setValueAt(rs2.getString("prodPrice"),i,5);
                    i++;
                }

            }
        }
        catch (Exception e2){

        }
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        setVisible(false);
        //conn.close();
        AddStock p = new AddStock();
        p.setVisible(true);
    }

    private void button5MouseClicked(MouseEvent e) {
        // TODO add your code here
        setVisible(false);
        Login p = new Login();
        p.setVisible(true);
    }

    private void button6MouseClicked(MouseEvent e) {
        // TODO add your code here
        try{
            Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");
            //String sql="select * from stock_history";
            //PreparedStatement ps=conn.prepareStatement(sql);
            if(conn!=null){
                Statement st2=conn.createStatement();
                ResultSet rs1=st2.executeQuery("select * from recent_customer");

                int t=0;
                while (rs1.next()){
                    table3.getModel().setValueAt(rs1.getDate("cusDate"),t,0);
                    table3.getModel().setValueAt(rs1.getString("prodID"),t,1);
                    table3.getModel().setValueAt(rs1.getString("prodQuantity"),t,2);
                    table3.getModel().setValueAt(rs1.getString("cusMail"),t,3);
                    t++;
                }
            }
        }
        catch (Exception e1){

        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Rohit
        label1 = new JLabel();
        separator1 = new JSeparator();
        label6 = new JLabel();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        label2 = new JLabel();
        scrollPane3 = new JScrollPane();
        table3 = new JTable();
        button6 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("FURN MART");
        label1.setFont(new Font("Segoe UI", Font.PLAIN, 30));

        //---- label6 ----
        label6.setText("Stock History");
        label6.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- button1 ----
        button1.setText("Add Stock");
        button1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                },
                new String[] {
                    "ProdID", "ProdType", "ProdCat", "SubCat", "Quantity", "Price"
                }
            ));
            scrollPane1.setViewportView(table1);
        }

        //======== scrollPane2 ========
        {

            //---- table2 ----
            table2.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                },
                new String[] {
                    "Date", "ProdID", "ProdType", "Quantity", "Price", "Action"
                }
            ));
            scrollPane2.setViewportView(table2);
        }

        //---- button2 ----
        button2.setText("In stock");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });

        //---- button3 ----
        button3.setText("Out of Stock");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });

        //---- button4 ----
        button4.setText("Near to Empty");
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button4MouseClicked(e);
            }
        });

        //---- button5 ----
        button5.setText("Log out");
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button5MouseClicked(e);
            }
        });

        //---- label2 ----
        label2.setText("Recent Customer");
        label2.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //======== scrollPane3 ========
        {

            //---- table3 ----
            table3.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                },
                new String[] {
                    "Date", "Product ID", "Quantity", "Customer Mail"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Date.class, Object.class, Object.class, Object.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            scrollPane3.setViewportView(table3);
        }

        //---- button6 ----
        button6.setText("View");
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button6MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(scrollPane2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label6)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 832, Short.MAX_VALUE)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(button5)
                                        .addComponent(button1))))
                            .addGap(40, 40, 40))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 1025, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addComponent(label2)
                                        .addGap(66, 66, 66)
                                        .addComponent(button6))
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addComponent(button3)
                                        .addGap(59, 59, 59)
                                        .addComponent(button4)
                                        .addGap(46, 46, 46)
                                        .addComponent(button2))
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1033, GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(459, 459, 459)
                            .addComponent(label1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1082, 1082, 1082)
                            .addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(button5))
                    .addGap(24, 24, 24)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(label6))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button3)
                        .addComponent(button4)
                        .addComponent(button2))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(button6))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                    .addGap(810, 810, 810)
                    .addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        try{
            Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");
            //String sql="select * from stock_history";
            //PreparedStatement ps=conn.prepareStatement(sql);
            if(conn!=null){
                Statement st=conn.createStatement();
                Statement st2=conn.createStatement();
                ResultSet rs=st.executeQuery("select * from stock_history");
                ResultSet rs1=st2.executeQuery("select * from recent_customer");
                int j=0;

                while (rs.next()){
                    //table2
                    table2.getModel().setValueAt(rs.getString("prodate"),j,0);
                    table2.getModel().setValueAt(rs.getString("prodID"),j,1);
                    table2.getModel().setValueAt(rs.getString("prodType"),j,2);
                    table2.getModel().setValueAt(rs.getString("prodQuantity"),j,3);
                    table2.getModel().setValueAt(rs.getString("prodPrice"),j,4);
                    table2.getModel().setValueAt(rs.getString("act"),j,5);
                    j++;
                }

                /*int t=0;
                while (rs1.next()){
                    table3.getModel().setValueAt(rs1.getString("cusDate"),j,0);
                    table3.getModel().setValueAt(rs1.getString("prodID"),j,1);
                    table3.getModel().setValueAt(rs1.getString("prodQuantity"),j,2);
                    table3.getModel().setValueAt(rs1.getString("cusMail"),j,3);
                    t++;
                }*/
            }
        }
        catch (Exception e){

        }
        //this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Stock s= new Stock();
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Rohit
    private JLabel label1;
    private JSeparator separator1;
    private JLabel label6;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JLabel label2;
    private JScrollPane scrollPane3;
    private JTable table3;
    private JButton button6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
