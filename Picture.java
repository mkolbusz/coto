package krawczyk.imageviewer;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;

public class Picture {

    private BufferedImage image;
    private File imageSource;

    public Picture(String path) {
        imageSource = new File(path);
        try {
            image = ImageIO.read(imageSource);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getPath() {
        return imageSource.getAbsolutePath();
    }

    public BufferedImage getScaledImage() {
        return image = Scalr.resize(image, 163, 143);
    }

    public BufferedImage getScaledImage(int width, int height) {
        return image = Scalr.resize(image, width, height);
    }

    public String getMetaData() {
        String metadataInfo = "";
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(imageSource);

            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    metadataInfo = metadataInfo + "\n" + tag;
                }
                if (directory.hasErrors()) {
                    for (String error : directory.getErrors()) {
                        System.err.println("ERROR: " + error);
                    }
                }
            }
        } catch (ImageProcessingException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return metadataInfo;
    }
}
