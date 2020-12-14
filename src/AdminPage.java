import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Sat Apr 11 13:18:17 IST 2020
 */



/**
 * @author Rohit
 */
public class AdminPage extends JDialog {
    public AdminPage(Window owner) {
        super(owner);
        initComponents();
    }
    public AdminPage() {
       // super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Rohit
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menu2 = new JMenu();
        menuItem4 = new JMenuItem();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        scrollPane2 = new JScrollPane();
        textArea2 = new JTextArea();
        scrollPane3 = new JScrollPane();
        textArea3 = new JTextArea();
        label4 = new JLabel();
        label5 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== menuBar1 ========
        {
            menuBar1.setFont(new Font("Segoe UI", Font.PLAIN, 18));

            //======== menu1 ========
            {
                menu1.setText("View");
                menu1.setFont(new Font("Segoe UI", Font.PLAIN, 18));

                //---- menuItem1 ----
                menuItem1.setText("Product Page");
                menuItem1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("Stock");
                menuItem2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                menu1.add(menuItem2);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("Add");
                menu2.setFont(new Font("Segoe UI", Font.PLAIN, 18));

                //---- menuItem4 ----
                menuItem4.setText("New Stock");
                menuItem4.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                menu2.add(menuItem4);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setText("Recents");
        label1.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        //---- label2 ----
        label2.setText("Out of Stock");
        label2.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        //---- label3 ----
        label3.setText("Near to Empty");
        label3.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(textArea2);
        }

        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(textArea3);
        }

        //---- label5 ----
        label5.setText("Furn Mart");
        label5.setFont(new Font("Segoe UI", Font.PLAIN, 28));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(559, 559, 559)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label5)
                                .addComponent(label4)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                                .addComponent(label1))))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2)
                        .addComponent(label3)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane3))
                    .addGap(33, 33, 33))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(label5)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(label4)
                    .addGap(22, 22, 22)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(label2))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label3)
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane3)))
                    .addContainerGap(52, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        AdminPage a= new AdminPage();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Rohit
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenu menu2;
    private JMenuItem menuItem4;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JScrollPane scrollPane2;
    private JTextArea textArea2;
    private JScrollPane scrollPane3;
    private JTextArea textArea3;
    private JLabel label4;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
