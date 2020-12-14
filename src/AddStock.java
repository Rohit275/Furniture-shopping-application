import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.*;
/*
 * Created by JFormDesigner on Sat Apr 11 17:49:34 IST 2020
 */



/**
 * @author Rohit
 */
public class AddStock extends JFrame {
    //String category[]={"Office","Home","Industrial"};
    /*public AddStock(Window owner) {
        super(owner);
        initComponents();
    }*/

    public AddStock() {
        initComponents();
    }



    private void radioButton1MouseClicked(MouseEvent e) {
        // TODO add your code here
        textField1.setEnabled(true);
        spinner1.setEnabled(true);
        textField2.setEnabled(false);
        demo.setEnabled(false);
        textField3.setEnabled(false);
        spinner2.setEnabled(false);
        textField5.setEnabled(false);
        textField6.setEnabled(true);
    }

    private void radioButton1StateChanged(ChangeEvent e) {
        // TODO add your code here
    }

    private void radioButton2StateChanged(ChangeEvent e) {
        // TODO add your code here
    }

    private void radioButton2MouseClicked(MouseEvent e) {
        // TODO add your code here
        String hou[]={"Living room","Bed Room"};
        textField1.setEnabled(false);
        spinner1.setEnabled(false);
        textField2.setEnabled(true);
        demo.setEnabled(true);
        textField3.setEnabled(true);
        spinner2.setEnabled(true);
        textField5.setEnabled(true);
        textField6.setEnabled(false);

       // textField5.setText(data);

    }

    private void demoKeyPressed(KeyEvent e) {
        // TODO add your code here

    }

    private void demoMouseClicked(MouseEvent e) {
        // TODO add your code here
        //String data=demo.getItemAt(demo.getSelectedIndex());
        /*if (data.equals("Office")) {
            comboBox1.setEnabled(false);

        }
        else {
            comboBox1.addItem("Living room");
            comboBox1.addItem("Bed room");
            comboBox1.addItem("Dinning room");
        }*/
    }

    private void demoItemStateChanged(ItemEvent e) {
        // TODO add your code here
        String data=demo.getItemAt(demo.getSelectedIndex());
        if (data.equals("Office")) {
            comboBox1.setEnabled(false);

        }
        else if(data.equals("House")) {
            comboBox1.setEnabled(true);
            comboBox1.addItem("Living room");
            comboBox1.addItem("Bed room");
            comboBox1.addItem("Dinning room");
        }
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        String id=textField2.getText();
        String type=textField3.getText();
        int quan= (int) spinner2.getValue();
        int price = Integer.parseInt(textField5.getText());
        String cat=demo.getItemAt(demo.getSelectedIndex());
        String scat=null;
        scat= (String) comboBox1.getItemAt(comboBox1.getSelectedIndex());
        int len= (int) spinner3.getValue();
        int hei= (int) spinner4.getValue();
        int wid= (int) spinner5.getValue();
        try{
            Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");
            String insert="insert into product values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(insert);
            ps.setString(1,id);
            ps.setString(2,type);
            ps.setString(3,cat);
            ps.setString(4,scat);
            ps.setInt(5,quan);
            ps.setInt(6,len);
            ps.setInt(7,hei);
            ps.setInt(8,wid);
            ps.setInt(9,price);
            ps.setString(10, "Insert");
            int x=ps.executeUpdate();
            if (x!=0){
                JOptionPane.showMessageDialog(null,"Successfully inserted");
                setVisible(false);
                conn.close();
                Stock p = new Stock();
                p.setVisible(true);
            }else {
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            //conn.close();
        }
        catch (Exception e1){
            System.out.println(e1);
       }

    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
        String id1=textField1.getText();
        int quant3;
        int quan2= (int) spinner1.getValue();
        int price2 = Integer.parseInt(textField6.getText());
        try{
            Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");
            String up1="update product set prodQuantity="+quan2+"+prodQuantity,prodPrice="+price2+",act='Update' where prodID="+id1;
            String up2="update stock_history set prodQuantity="+quan2+"where prodID="+id1;
            PreparedStatement ps1=conn.prepareStatement(up1);
            PreparedStatement ps2=conn.prepareStatement(up2);
            int x=ps1.executeUpdate();
            ps2.executeUpdate();
            if (x!=0){
                JOptionPane.showMessageDialog(null,"Successfully inserted");
            }else {
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }

            /*String update="update product set prodPrice=? where prodID="+id1;
            String insert="update product set prodQuantity=? where prod";
            PreparedStatement ps=conn.prepareStatement(insert);
            PreparedStatement ps1=conn.prepareStatement(update);
            Statement st=conn.createStatement();
            //Statement st2=conn.createStatement();
            //st2.executeQuery(update);

            ResultSet rs1 =st.executeQuery("select prodQuantity from product where prodID="+id1);
            quant3=quan2+(rs1.getInt("prodQuantity"));
            ps.setInt(1,quant3);
            ps1.setInt(1, Integer.parseInt("prodPrice"));
            int x=ps.executeUpdate();
            if (x!=0){
                JOptionPane.showMessageDialog(null,"Successfully inserted");
            }else {
                JOptionPane.showMessageDialog(null,"Something wrong");
            }*/
        }
        catch (Exception e2){

        }
    }

    private void button4MouseClicked(MouseEvent e) {
        // TODO add your code here
        setVisible(false);
        Stock p = new Stock();
        p.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Rohit
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        spinner1 = new JSpinner();
        spinner2 = new JSpinner();
        textField5 = new JTextField();
        label8 = new JLabel();
        label9 = new JLabel();
        demo = new JComboBox<>();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        label10 = new JLabel();
        textField6 = new JTextField();
        label1 = new JLabel();
        comboBox1 = new JComboBox();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        spinner3 = new JSpinner();
        spinner4 = new JSpinner();
        label14 = new JLabel();
        spinner5 = new JSpinner();
        button1 = new JButton();
        button2 = new JButton();
        label16 = new JLabel();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label2 ----
        label2.setText("Product ID");
        label2.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label3 ----
        label3.setText("Quantity");
        label3.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label4 ----
        label4.setText("Product ID");
        label4.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label5 ----
        label5.setText("Product Type");
        label5.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label6 ----
        label6.setText("Quantity");
        label6.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label7 ----
        label7.setText("Unit Price");
        label7.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label8 ----
        label8.setText("Rs.");

        //---- label9 ----
        label9.setText("Product Category");
        label9.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- demo ----
        demo.setModel(new DefaultComboBoxModel<>(new String[] {
            "Office",
            "House"
        }));
        demo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                demoKeyPressed(e);
            }
        });
        demo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                demoMouseClicked(e);
            }
        });
        demo.addItemListener(e -> demoItemStateChanged(e));

        //---- radioButton1 ----
        radioButton1.setText("Add Existing Item");
        radioButton1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        radioButton1.addChangeListener(e -> radioButton1StateChanged(e));
        radioButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                radioButton1MouseClicked(e);
            }
        });

        //---- radioButton2 ----
        radioButton2.setText("Add New Item");
        radioButton2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        radioButton2.addChangeListener(e -> radioButton2StateChanged(e));
        radioButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                radioButton2MouseClicked(e);
            }
        });

        //---- label10 ----
        label10.setText("Unit Price");
        label10.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label1 ----
        label1.setText("Sub-Category");
        label1.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label11 ----
        label11.setText("Dimension");
        label11.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label12 ----
        label12.setText("Length");

        //---- label13 ----
        label13.setText("Height");

        //---- label14 ----
        label14.setText("Width");

        //---- button1 ----
        button1.setText("Cancel");

        //---- button2 ----
        button2.setText("Add");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });

        //---- label16 ----
        label16.setText("Rs.");

        //---- button3 ----
        button3.setText("Add");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });

        //---- button4 ----
        button4.setText("Back to Main");
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button4MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label4)
                            .addGap(43, 43, 43)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(label10)
                            .addGap(100, 100, 100)
                            .addComponent(label16))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(label3))
                            .addGap(33, 33, 33)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(spinner1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
                            .addGap(48, 48, 48)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label11, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                    .addGap(56, 56, 56)
                                    .addComponent(label12))
                                .addComponent(label9)))
                        .addComponent(radioButton1)
                        .addComponent(radioButton2)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label5)
                                        .addComponent(label6))
                                    .addGap(18, 18, 18))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(button1)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label7)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label8)))
                                    .addGap(4, 4, 4)))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(spinner2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(72, 72, 72)
                                    .addComponent(button4)))))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                            .addComponent(button2)
                            .addGap(65, 65, 65))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(textField6, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(comboBox1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(demo, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(spinner3, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(label13)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(spinner4, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(button3)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label14)
                                            .addGap(18, 18, 18)
                                            .addComponent(spinner5, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))))
                            .addGap(0, 45, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(102, 102, 102)
                    .addComponent(radioButton1)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textField1)
                        .addComponent(label10)
                        .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label16))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(spinner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button3))
                    .addGap(67, 67, 67)
                    .addComponent(radioButton2)
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(demo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label9))
                            .addGap(20, 20, 20)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label5)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label1)
                                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                            .addGap(32, 32, 32)
                            .addComponent(label6))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(spinner2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinner3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinner4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label14)
                            .addComponent(label13, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinner5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label12)
                            .addComponent(label11)))
                    .addGap(23, 23, 23)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label7)
                        .addComponent(label8)
                        .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(75, 75, 75)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2)
                        .addComponent(button4))
                    .addGap(183, 183, 183))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        //JComboBox cb=new JComboBox(category);
        //cb.setBounds(450, 350,90,20);
        //cb.setVisible(true);
        ButtonGroup g1=new ButtonGroup();
        g1.add(radioButton1);
        g1.add(radioButton2);
        textField1.setEnabled(false);
        spinner1.setEnabled(false);
        textField2.setEnabled(false);
        demo.setEnabled(false);
        textField3.setEnabled(false);
        spinner2.setEnabled(false);
        textField5.setEnabled(false);
        textField6.setEnabled(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        AddStock a=new AddStock();
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Rohit
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JTextField textField5;
    private JLabel label8;
    private JLabel label9;
    private JComboBox<String> demo;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JLabel label10;
    private JTextField textField6;
    private JLabel label1;
    private JComboBox comboBox1;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JLabel label14;
    private JSpinner spinner5;
    private JButton button1;
    private JButton button2;
    private JLabel label16;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
