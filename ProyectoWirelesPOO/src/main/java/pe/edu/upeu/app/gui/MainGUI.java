/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.app.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;


public class MainGUI extends JFrame{
    JMenuBar menuBar;
    JMenu menu1;
    JMenuItem jmI1;
    JMenuItem jmI2; //Agregado
    JTabbedPane jtpane;
    JPanel jp;
    JScrollPane scrollPane;
       public MainGUI() {
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new Dimension(screenSize.width, (screenSize.height) - 36));
        menuBar = new JMenuBar();
        menu1 = new JMenu("Adm. Cliente");     
        jmI2 = new JMenuItem("Adm. Cliente");//Agregado

       
        menu1.add(jmI2);//Agregado
        menuBar.add(menu1);
        menu1 = new JMenu("Manual de Usuario");
        menuBar.add(menu1);
        this.add(menuBar);
        jtpane = new JTabbedPane();//agregado
        MenuItemListener menuItemListener = new MenuItemListener();
        jmI2.addActionListener(menuItemListener);//ecuchar la accion

        this.getContentPane().add(BorderLayout.NORTH, menuBar);
        //this.getContentPane().add(BorderLayout.CENTER, jtpane);
        //this.setVisible(true);
    }
       class MenuItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("pasa por aqui");
            Container contai = MainGUI.this.getContentPane();

            if (e.getSource() == jmI2) {
                System.out.println("Holas");
                jtpane.removeAll();
                MainCliente mc = new MainCliente();
                scrollPane = new JScrollPane(mc);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                jtpane.add("Adm. Cliente", scrollPane);
                //jtpane.add("Prueba", mc);
                //jtpane.add("dd", new JPanel());  
                contai.add(BorderLayout.CENTER, jtpane);
                //contai.remove(jtpane);
                //contai.revalidate();
                contai.invalidate();
                contai.validate();

            }

        }
    }

}
