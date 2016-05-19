package krawczyk.imageviewer;

public class IMAGE_VIEWER {

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.setSize(1366, 600);
        gui.setVisible(true);

        /*JFrame test = new JFrame("test");
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setSize(300, 400);

        String path = "/home/karol/Pobrane/IMG_20150825_141939.jpg";
        Picture pic = new Picture(path);
        String[][] rowNames = pic.getMetadataArray();
        String[] columnNames = new String[]{"jeden", "dwa"};
        DefaultTableModel model = new DefaultTableModel(rowNames, columnNames);
        JTable table = new JTable(model);
        JPanel dsds = new JPanel();
        dsds.add(table);
        test.add(dsds);
        test.setVisible(true);*/

 /*String path = "/home/karol/Pobrane/IMG_20150825_141939.jpg";
        Picture test = new Picture(path);
        String[][] meta = test.getMetadataArray();
        System.out.println();
        for (int i = 0; i < meta.length; i++) {
            System.out.println(meta[i][0] + "         " + meta[i][1]);
        }*/
 /*meta = meta.replaceAll("\\[.*?\\]", "");
        String[] trtr = meta.split(" - |\\\n");
        String[][] trutut = new String[52][2];
        System.out.println(trtr.length);
        int d = 0;
        for (int i = 0; i < trutut.length; i++) {
            trutut[i][0] = trtr[d];
            trutut[i][1] = trtr[d + 1];
            d = d + 2;
            System.out.println(trutut[i][0] + "         " + trutut[i][1]);
        }*/
    }

}
