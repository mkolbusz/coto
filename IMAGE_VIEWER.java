package krawczyk.imageviewer;

import java.awt.BorderLayout;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class IMAGE_VIEWER {

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.setSize(1366, 600);
        gui.setVisible(true);

        /*String path = "/home/karol/Pobrane/IMG_20150828_160132.jpg";
        Picture test = new Picture(path);
        String meta = "<html>" + test.getMetaData().replaceAll("\n", "<br>") + "<html>";
        meta = meta.replaceAll("\\[.*?\\]", "");
        System.out.println(meta);*/

 /*String path = "/home/karol/Pobrane/IMG_20150828_160132.jpg";
        Picture test = new Picture(path);
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        JLabel label1 = new JLabel(new ImageIcon(test.getScaledImage()));
        frame.add(label1, BorderLayout.WEST);
        //JLabel label2 = new JLabel(meta);
        //frame.add(label2, BorderLayout.EAST);
        frame.setVisible(true);
        System.out.println("Path: " + test.getPath());*/

 /*Gui gui = new Gui();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1000, 700);
        gui.setVisible(true);*/
 /*DirectoryContents test = new DirectoryContents("/home/karol/Pobrane");
        String[] rest = test.getImagePaths();
        for (int i = 0; i < rest.length; i++) {
            System.out.println(rest[i]);
        }*/
    }

}
