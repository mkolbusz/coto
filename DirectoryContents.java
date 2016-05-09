package krawczyk.imageviewer;

import java.io.File;
import java.io.FilenameFilter;

public class DirectoryContents {

    private File dir;
    private static final String[] EXTENSIONS = {"gif", "png", "bmp", "jpg", "jfif",
        "jpeg", "exif", "tiff", "bmp", "png", "ppm", "pgm", "pbm", "pnm", "webp",
        "hdr", "bpg", "img"};
    private FilenameFilter imageFilter;
    private Picture[] pictures;

    public DirectoryContents(String directory) {
        dir = new File(directory);

        imageFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                for (String ext : EXTENSIONS) {
                    if (name.endsWith("." + ext)) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    public String[] getImagePaths() {
        int i = 0;

        for (File f : dir.listFiles(imageFilter)) {
            i++;
        }

        String imagePath[] = new String[i];
        i = 0;
        for (File f : dir.listFiles(imageFilter)) {
            imagePath[i] = f.getAbsolutePath();
            i++;
        }
        return imagePath;

    }
}
