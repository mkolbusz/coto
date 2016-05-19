package krawczyk.imageviewer;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.jpeg.JpegDirectory;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;

public class Picture {

    private BufferedImage image;
    private File imageSource;
    private String path;
    private String metadataInfo;
    private String[][] arrMetadataInfo;

    public Picture(String newPath) {
        path = newPath;
        imageSource = new File(path);
        try {
            image = ImageIO.read(imageSource);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        metadataInfo = "";
        setMetadata();
        setMetadataArray();
    }

    private void setMetadata() {
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(imageSource);
            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    metadataInfo = metadataInfo + tag.toString() + "\n";
                }
                if (directory.hasErrors()) {
                    for (String error : directory.getErrors()) {
                        System.err.println("ERROR: " + error);
                    }
                }
            }
        } catch (ImageProcessingException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void setMetadataArray() {
        String meta;
        meta = metadataInfo.replaceAll("\\[.*?\\]", "");
        String[] tempArr = meta.split(" - |\\\n");
        arrMetadataInfo = new String[52][2];
        int d = 0;
        for (int i = 0; i < arrMetadataInfo.length; i++) {
            arrMetadataInfo[i][0] = tempArr[d];
            arrMetadataInfo[i][1] = tempArr[d + 1];
            d = d + 2;
        }
    }

    public String[][] getMetadataArray() {
        return arrMetadataInfo;
    }

    public File getFile() {
        return imageSource;
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getPath() {
        return imageSource.getAbsolutePath();
    }

    public void setPath(String newPath) {
        path = newPath;
    }

    public BufferedImage getScaledImage() {
        return image = Scalr.resize(image, 163, 143);
    }

    public BufferedImage getScaledImage(int width, int height) {
        return image = Scalr.resize(image, width, height);
    }

    public String getMetaData() {
        return metadataInfo;
    }
}
