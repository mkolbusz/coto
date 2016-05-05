package krawczyk.imageviewer;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class IMAGE_VIEWER {

    public static void main(String[] args) {
        /*String path = "/home/karol/Pobrane/IMG_20150828_160132.jpg";
        Picture test = new Picture(path);
        String meta = "<html>" + test.getMetaData().replaceAll("\n", "<br>") + "<html>";
        meta = meta.replaceAll("\\[.*?\\]", "");

        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        JLabel label1 = new JLabel(new ImageIcon(test.getScaledImage()));
        frame.add(label1, BorderLayout.WEST);
        JLabel label2 = new JLabel(meta);
        frame.add(label2, BorderLayout.EAST);
        frame.setVisible(true);

        System.out.println("Path: " + test.getPath());
        System.out.println(test.getMetaData());*/

        Gui gui = new Gui();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1000, 700);
        gui.setVisible(true);

    }

}
