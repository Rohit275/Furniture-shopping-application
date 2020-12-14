import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.Window;
import java.sql.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Thu Apr 09 19:36:42 IST 2020
 */



/**
 * @author Rohit
 */
public class ProductPage extends JFrame {
    public String mail,ID;
    /*public ProductPage(Window owner) {
        super(owner);
        initComponents();
    }*/

    public ProductPage() {
        initComponents();
    }
    public ProductPage(String mail1) {
        mail=mail1;
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        String id=textField1.getText();
        ID=id;
        int quan= (int) spinner1.getValue();
        //mail="rohit@gmail.com";
        int quan1;
        int price;
        int price1;
        try{
            Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");
            //Statement st1=conn.createStatement();
            //Statement st2=conn.createStatement();
            String insert1="insert into cart values(?,?,?,?,?,?,?,?,?,?)";
            String st="select * from product where prodID= '"+id+"'";

            //String up2="update stock_history set prodQuantity="+quan2+"where prodID="+id1;
            PreparedStatement ps1=conn.prepareStatement(st);
            PreparedStatement ps=conn.prepareStatement(insert1);
            ResultSet rs=ps1.executeQuery();
            while(rs.next()){
                quan1=rs.getInt("prodQuantity");
                price=rs.getInt("prodPrice");
               // System.out.println(quan1);
                //System.out.println(price);
                price1= price * quan;
                quan1=quan1-quan;
                ps.setString(1,mail);
                ps.setString(2,id);
                ps.setString(3,rs.getString("prodType"));
                //System.out.println("Product Type: "+rs.getString("prodType"));
                ps.setString(4,rs.getString("prodCat"));
                ps.setString(5,rs.getString("prodSCat"));
                ps.setInt(6,rs.getInt("prodLength"));
                ps.setInt(7,rs.getInt("prodHeight"));
                ps.setInt(8,rs.getInt("prodWidth"));
                ps.setInt(9,quan);
                ps.setInt(10,price1);
                int x=ps.executeUpdate();
                if (x!=0){
                    JOptionPane.showMessageDialog(null,"Added to your cart");

                }else {
                    JOptionPane.showMessageDialog(null,"Something wrong");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        //setVisible(false);
        Cart p = new Cart(mail);
        p.setVisible(true);
    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
        this.setVisible(false);
        Login p = new Login();
        p.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Rohit
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        spinner1 = new JSpinner();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label4 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                },
                new String[] {
                    "Product ID", "Type", "Category", "Sub-Category", "length", "Width", "Height", "Price", "Quantity"
                }
            ));
            scrollPane1.setViewportView(table1);
        }

        //---- label1 ----
        label1.setText("Choose Your Product");
        label1.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label2 ----
        label2.setText("Product ID");

        //---- label3 ----
        label3.setText("Quantity");

        //---- spinner1 ----
        spinner1.setModel(new SpinnerNumberModel(1, 1, null, 1));

        //---- button1 ----
        button1.setText("Add to cart");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- button2 ----
        button2.setText("View Cart");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });

        //---- button3 ----
        button3.setText("Log-Out");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });

        //---- label4 ----
        label4.setText("Furn Mart");
        label4.setFont(new Font("Segoe UI", Font.PLAIN, 28));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(471, 471, 471)
                            .addComponent(label4)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 451, Short.MAX_VALUE)
                            .addComponent(button3))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE)))
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addContainerGap(995, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(label2))
                            .addGap(28, 28, 28)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                .addComponent(spinner1, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                            .addGap(206, 206, 206)
                            .addComponent(button1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
                            .addComponent(button2)
                            .addGap(165, 165, 165))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button3)
                        .addComponent(label4))
                    .addGap(74, 74, 74)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(label1)
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(spinner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addContainerGap(24, Short.MAX_VALUE))
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
                ResultSet rs=st.executeQuery("select * from product");

                int j=0;
                while (rs.next()){
                    //table2
                    table1.getModel().setValueAt(rs.getString("prodID"),j,0);
                    table1.getModel().setValueAt(rs.getString("prodType"),j,1);
                    table1.getModel().setValueAt(rs.getString("prodCat"),j,2);
                    table1.getModel().setValueAt(rs.getString("prodSCat"),j,3);
                    table1.getModel().setValueAt(rs.getString("prodLength"),j,4);
                    table1.getModel().setValueAt(rs.getString("prodHeight"),j,5);
                    table1.getModel().setValueAt(rs.getString("prodWidth"),j,6);
                    table1.getModel().setValueAt(rs.getString("prodPrice"),j,7);
                    table1.getModel().setValueAt(rs.getString("prodQuantity"),j,8);
                    j++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        ProductPage s=new ProductPage();
        //System.out.println("Program starts main");
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Rohit
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JSpinner spinner1;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
