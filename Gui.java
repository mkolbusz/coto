package krawczyk.imageviewer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Gui extends JFrame {

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem item1;
    private JFileChooser fileChooser;
    private String directory;

    public Gui() {
        super("Image Metadata Viewer");

        //menu
        menuBar = new JMenuBar();
        menu = new JMenu("Open");
        item1 = new JMenuItem("Directory");
        MenuActionListener handler = new MenuActionListener();
        item1.addActionListener(handler);
        menu.add(item1);
        menuBar.add(menu);
        add(menuBar, BorderLayout.NORTH);
    }

    //menu directory action listener
    private class MenuActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(item1)) {
                fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int response = fileChooser.showOpenDialog(menu);
                if (response == JFileChooser.APPROVE_OPTION) {
                    directory = fileChooser.getSelectedFile().toString();
                    System.out.println(directory);
                }
            }
        }
    }

}
