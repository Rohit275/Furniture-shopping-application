import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.sql.*;
import java.awt.Window;
/*
 * Created by JFormDesigner on Thu Apr 09 19:07:52 IST 2020
 */



/**
 * @author Rohit
 */
public class Login extends JDialog {
    public Login(Window owner) {
        super(owner);
        initComponents();
    }

    public Login() {
        initComponents();
    }

    private void label8MouseClicked(MouseEvent e) {
        // TODO add your code here
        setVisible(false);
        Signup s=new Signup();
        s.setVisible(true);
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        String unmae=textField1.getText();
        String mail=textField2.getText();
        String pass=passwordField1.getText();
        if (unmae.equals("Admin") && pass.equals("admin123")){
            JOptionPane.showMessageDialog(null,"Logged in as administrator");
            this.setVisible(false);
            Stock s=new Stock();
            s.setVisible(true);
        }
        else {
            try{
                Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");
                String sql="select * from customer where cusUsername='"+ textField1.getText()+"' and cusPass='"+ passwordField1.getText()+"' and cusMail='"+ textField2.getText()+"'";
                PreparedStatement ps=conn.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();

                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Login Successful");
                    setVisible(false);
                    conn.close();
                    ProductPage p = new ProductPage(mail);
                    p.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid data");
                }

            }
            catch(Exception e1) {
                System.out.println(e1);
            }
        }
    }

    private void radioButton2MouseClicked(MouseEvent e) {
        // TODO add your code here
        label8.setEnabled(false);
    }

    private void radioButton1MouseClicked(MouseEvent e) {
        // TODO add your code here
        label8.setEnabled(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Rohit
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        label5 = new JLabel();
        button1 = new JButton();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        passwordField1 = new JPasswordField();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();

        //======== this ========
        setBackground(Color.lightGray);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("SIGN-IN");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Segoe UI", Font.PLAIN, 23));

        //---- label2 ----
        label2.setText("USER NAME");
        label2.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label3 ----
        label3.setText("EMAIL\\MOBILE");
        label3.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label4 ----
        label4.setText("PASSWORD");
        label4.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label5 ----
        label5.setIcon(new ImageIcon("C:\\Users\\Rohit\\Downloads\\sign1.jpg"));

        //---- button1 ----
        button1.setText("CONTINUE");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 6f));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- label6 ----
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 2f));

        //---- label7 ----
        label7.setText("New to Furnmart?");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 2f));

        //---- label8 ----
        label8.setText("Create an account here.");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 3f));
        label8.setForeground(new Color(51, 51, 255));
        label8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label8MouseClicked(e);
            }
        });

        //---- radioButton1 ----
        radioButton1.setText("Customer");
        radioButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                radioButton1MouseClicked(e);
            }
        });

        //---- radioButton2 ----
        radioButton2.setText("Admin");
        radioButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                radioButton2MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(127, 127, 127)
                            .addComponent(label5))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(184, 184, 184)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(165, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(168, Short.MAX_VALUE)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(226, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(109, 109, 109)
                    .addComponent(label6)
                    .addContainerGap(439, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(135, 135, 135)
                    .addComponent(label7)
                    .addGap(18, 18, 18)
                    .addComponent(label8)
                    .addContainerGap(86, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4)
                                .addComponent(label3)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(109, 109, 109)
                            .addComponent(radioButton1)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(passwordField1, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                        .addComponent(radioButton2))
                    .addGap(32, 32, 32))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                    .addGap(37, 37, 37)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addGap(8, 8, 8)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(radioButton2)
                        .addComponent(radioButton1))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(38, 38, 38)
                    .addComponent(label6)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label7)
                        .addComponent(label8))
                    .addGap(30, 30, 30)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addGap(19, 19, 19))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        ButtonGroup g1=new ButtonGroup();
        g1.add(radioButton1);
        g1.add(radioButton2);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Login l= new Login();
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Rohit
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label5;
    private JButton button1;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JPasswordField passwordField1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
