import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import org.jdatepicker.impl.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/*
 * Created by JFormDesigner on Sat Apr 11 11:54:11 IST 2020
 */



/**
 * @author Rohit
 */
public class Signup extends JDialog {
    public String reportDate,Mail,Pass,Mob;
    String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
    static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    static boolean isValidMob(String mob){
        String regex ="(0/91)?[7-9][0-9]{9}";
        return mob.matches(regex);
    }

    public static boolean isStringOnlyAlphabet(String str)
    {
        return ((str != null)
                && (!str.equals(""))
                && (str.chars().allMatch(Character::isLetter)));
    }


    public Signup(Window owner) {
        super(owner);
        initComponents();
    }

    public Signup() {
        initComponents();
        System.out.println("Program starts constructor");
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        String name = textField1.getText();
        String mail = textField2.getText();
        String mob = textField3.getText();
        String reportDate = null;
        String ad = textField5.getText();
        String loc = textField6.getText();
        String cit = textField7.getText();
        char gen;
        String pass=passwordField1.getText();
        if (!isValid(mail)){
           // JOptionPane.showMessageDialog("Please enter a valid email id for UserName");
            JOptionPane.showMessageDialog(null,"Please enter a valid email id for UserName");
        }
        else{
            Mail=mail;
        }
        if (!isValidMob(mob)){
            JOptionPane.showMessageDialog(null,"Please enter a valid mobile number(only 10 numbers)");
        }
        else{
            Mob=mob;
        }

        String unmae= textField4.getText();
        if (radioButton3.isSelected()){
            gen = 'M';
        }
        else if (radioButton4.isSelected()){
            gen = 'F';
        }
        else{
            gen = 'T';
        }

        if (!pass.matches(pattern)){
            JOptionPane.showMessageDialog(null, "Your password must contain atleast 8 characters with atleast one uppercase,lowercase and special character");
        }
        else{
            if (pass.equals(passwordField2.getText())){
                Pass=pass;
                try{
                    Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");
                    String insert="insert into customer values(?,?,?,?,?,?,?,?,?)";
                    PreparedStatement ps=conn.prepareStatement(insert);
                    ps.setString(1,name);
                    ps.setString(2,Mail);
                    ps.setString(3,Mob);
                    ps.setString(4,ad);
                    ps.setString(5,loc);
                    ps.setString(6,cit);
                    ps.setString(7, String.valueOf(gen));
                    // ps.setString(5,reportDate);
                    ps.setString(8,unmae);
                    ps.setString(9, String.valueOf(Pass));
                    //ResultSet x=ps.executeQuery();
                    int x=ps.executeUpdate();
                    if (x!=0){
                        JOptionPane.showMessageDialog(null,"Successfully added");
                        setVisible(false);
                        conn.close();
                        ProductPage p = new ProductPage(mail);
                        p.setVisible(true);
                    }else {
                        JOptionPane.showMessageDialog(null,"Something wrong");
                    }
                }
                catch(Exception e1){
                    System.out.println(e1);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Incorrect Password");
            }
        }
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        this.setVisible(false);
        Login s=new Login();
        s.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Rohit
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label9 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        passwordField1 = new JPasswordField();
        passwordField2 = new JPasswordField();
        radioButton3 = new JRadioButton();
        radioButton4 = new JRadioButton();
        radioButton5 = new JRadioButton();
        button1 = new JButton();
        label8 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        textField5 = new JTextField();
        textField6 = new JTextField();
        textField7 = new JTextField();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Sign Up");
        label1.setFont(new Font("Segoe UI", Font.PLAIN, 28));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label2 ----
        label2.setText("Name");
        label2.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label3 ----
        label3.setText("Mail ID");
        label3.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label4 ----
        label4.setText("Mobile");
        label4.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label5 ----
        label5.setText("Gender");
        label5.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label6 ----
        label6.setText("User Name");
        label6.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label7 ----
        label7.setText("Password");
        label7.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label9 ----
        label9.setText("Confirm Password");
        label9.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- radioButton3 ----
        radioButton3.setText("Male");

        //---- radioButton4 ----
        radioButton4.setText("Female");

        //---- radioButton5 ----
        radioButton5.setText("Trans Gender");

        //---- button1 ----
        button1.setText("Signup");
        button1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- label8 ----
        label8.setText("Address");
        label8.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label10 ----
        label10.setText("Location");
        label10.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label11 ----
        label11.setText("City");
        label11.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- button2 ----
        button2.setText("Cancel");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(label4)
                                    .addComponent(label3))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label5)
                                        .addComponent(label6)
                                        .addComponent(label7)
                                        .addComponent(label9)))
                                .addComponent(button1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(radioButton3)
                                            .addGap(18, 18, 18)
                                            .addComponent(radioButton4)
                                            .addGap(18, 18, 18)
                                            .addComponent(radioButton5))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(label8)
                                                .addComponent(label10)
                                                .addComponent(label11))))
                                    .addGap(38, 38, 38)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textField6, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                        .addComponent(textField7, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                        .addComponent(textField5, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(554, 554, 554)
                            .addComponent(button2))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(316, 316, 316)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(108, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                    .addGap(36, 36, 36)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label8)
                        .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label10)
                        .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label11)
                        .addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5)
                                .addComponent(radioButton3)
                                .addComponent(radioButton4)
                                .addComponent(radioButton5))
                            .addGap(83, 83, 83)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6)
                                .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(25, 25, 25)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label7)
                                .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label9)
                                .addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 349, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button2)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))))
                    .addGap(27, 27, 27))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        ButtonGroup g1= new ButtonGroup();
        g1.add(radioButton3);
        g1.add(radioButton4);
        g1.add(radioButton5);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Rohit
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label9;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JButton button1;
    private JLabel label8;
    private JLabel label10;
    private JLabel label11;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        Signup s=new Signup();
        System.out.println("Program starts main");
    }

}
