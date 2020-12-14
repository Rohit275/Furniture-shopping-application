import com.sun.source.tree.WhileLoopTree;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Thu Apr 16 02:09:58 IST 2020
 */



/**
 * @author Rohit
 */
public class Cart extends JDialog {
    public String mail1,ID;
    static int cnt1;
    public Cart(Window owner) {
        super(owner);
        initComponents();
    }

    public Cart(String mail) {
        // super(owner);
        //quant=qua;
        mail1=mail;
        //ID=id;
        initComponents();
    }

    /*private static  java.sql.Date getCurrentDate(){
        java.util.Date today = new java.util.Date();
        return java.sql.Date(today.getTime());
    }*/
    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here

        try{
            Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from cart");
            //Statement st2=conn.createStatement();
            //ResultSet rs2=st.executeQuery("select * from product");
            if (rs.next()){

                String s1="select * from cart where cusMail='"+mail1+"'";
                PreparedStatement ps1=conn.prepareStatement(s1);
                ResultSet rs1=ps1.executeQuery();

                // System.out.println("Before While");
                // SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
                // java.util.Date dt = sd.p;

                String ins="insert into recent_customer (cnt,prodID,prodQuantity,cusMail) values(?,?,?,?)";
                PreparedStatement prd=conn.prepareStatement(ins);

                // System.out.println("Before While");

                while (rs1.next()){
                   // prd.setTimestamp(1,new java.sql.Timestamp(System.currentTimeMillis()));
                   // System.out.println("After While");
                    cnt1=cnt1+1;
                    prd.setInt(1,cnt1);
                    prd.setString(2,rs1.getString("prodID"));
                    prd.setInt(3,rs1.getInt("prodQuantity"));
                    prd.setString(4,rs1.getString("cusMail"));
                    // System.out.println("after setString");
                    
                    int x1=prd.executeUpdate();
                    String ins1="update recent_customer set cusDate=sysdate where cnt="+cnt1;
                    PreparedStatement dt1=conn.prepareStatement(ins1);
                    dt1.executeUpdate();
                    //System.out.println("after setString2");
                    if (x1!=0){
                        //JOptionPane.showMessageDialog(null,"Added to recent");

                    }else {
                        JOptionPane.showMessageDialog(null,"Something wrong");
                    }
                }
                //String up2="update stock_history set cusMail='"+mail1+"' where prodID="+rs.getString("prodID");
                //PreparedStatement ps3=conn.prepareStatement(up2);
                //ps3.executeUpdate();
                System.out.println("after setString3");
                String up1="update product set prodQuantity= prodQuantity-"+rs.getString("prodQuantity")+",act='Buy' where prodID="+rs.getString("prodID");
                PreparedStatement ps2=conn.prepareStatement(up1);
                int x=ps2.executeUpdate();
                if(x!=0){
                    JOptionPane.showMessageDialog(null,"Your order has been placed...Thanks for shopping");
                    String del="delete from cart where cusMail='"+mail1+"'";
                    PreparedStatement ps=conn.prepareStatement(del);
                    ps.executeUpdate();
                    //String s1="select * from product where prodID= ";
                    setVisible(false);
                    conn.close();
                    ProductPage p = new ProductPage(mail1);
                    p.setVisible(true);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        String id=textField1.getText();
        int sum=0;
        try{
            Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");
            if(conn!=null){
                String del="delete from cart where prodID="+id;
                PreparedStatement ps2=conn.prepareStatement(del);
                ps2.executeUpdate();
                //table1.setModel(new DefaultTableModel(null));
                //table1.getRowCount(0);

                for (int i = 0; i < table1.getRowCount(); i++) {
                    for(int j = 0; j < table1.getColumnCount(); j++) {
                        table1.setValueAt("", i, j);
                    }
                }
                Statement st=conn.createStatement();
                Statement st1=conn.createStatement();
                ResultSet rs=st.executeQuery("select * from cart");
                ResultSet rs1=st1.executeQuery("select * from cart where cusMail='"+mail1+"'");
                //String total="select sum(prodPrice) from cart where cusMail='"+mail1+"'";
                //PreparedStatement ps=conn.prepareStatement(total);
                //ps.executeUpdate();
                while (rs1.next()){
                    sum=sum+rs1.getInt("prodPrice");
                }
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
                    table1.getModel().setValueAt(rs.getString("prodQuantity"),j,7);
                    table1.getModel().setValueAt(rs.getString("prodPrice"),j,8);
                    j++;
                }
                textField2.setText(String.valueOf(sum));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
        setVisible(false);
        //conn.close();
        ProductPage p = new ProductPage(mail1);
        p.setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Rohit
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label4 = new JLabel();
        textField2 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Your Cart");
        label1.setFont(new Font("Segoe UI", Font.PLAIN, 30));

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
                    "Product ID", "Type", "Category", "Sub-Category", "Length", "Height", "Width", "Quantity", "Price"
                }
            ));
            scrollPane1.setViewportView(table1);
        }

        //---- label2 ----
        label2.setText("Remove Item");
        label2.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        //---- label3 ----
        label3.setText("Product ID");
        label3.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- button1 ----
        button1.setText("Remove");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- button2 ----
        button2.setText("Order");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });

        //---- button3 ----
        button3.setText("Back to main");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });

        //---- label4 ----
        label4.setText("Total");
        label4.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label1)
                    .addGap(389, 389, 389))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(button3))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addGap(18, 18, 18)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(button1))
                                .addComponent(label2))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(button2)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addGap(18, 18, 18)
                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
                            .addGap(29, 29, 29))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1)
                            .addContainerGap())))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(210, 210, 210)
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button1))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button3)
                                .addComponent(button2))
                            .addGap(20, 20, 20))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4))
                            .addContainerGap(165, Short.MAX_VALUE))))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        int sum = 0;
        try{
            Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");
            //String sql="select * from stock_history";
            //PreparedStatement ps=conn.prepareStatement(sql);
            if(conn!=null){
                Statement st=conn.createStatement();
                Statement st1=conn.createStatement();
                ResultSet rs=st.executeQuery("select * from cart");
                ResultSet rs1=st1.executeQuery("select * from cart where cusMail='"+mail1+"'");
                //String total="select sum(prodPrice) from cart where cusMail='"+mail1+"'";
                //PreparedStatement ps=conn.prepareStatement(total);
                //ps.executeUpdate();
                while (rs1.next()){
                    sum=sum+rs1.getInt("prodPrice");
                }
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
                    table1.getModel().setValueAt(rs.getString("prodQuantity"),j,7);
                    table1.getModel().setValueAt(rs.getString("prodPrice"),j,8);
                    j++;
                }
                textField2.setText(String.valueOf(sum));
            }
        }
        catch (Exception e){

        }
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Rohit
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label4;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
