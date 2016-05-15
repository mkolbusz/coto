package krawczyk.imageviewer;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.jpeg.JpegDirectory;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import org.imgscalr.Scalr;

public class Rotate {

    private Metadata metadata;
    private ExifIFD0Directory exifIFD0Directory;
    private JpegDirectory jpegDirectory;
    private int orientation;
    private int width;
    private int height;
    private AffineTransform affineTransform;
    private AffineTransformOp affineTransformOp;
    private BufferedImage destinationImage;

    public Rotate(File imageSource, BufferedImage image) throws ImageProcessingException, IOException, MetadataException {
        metadata = ImageMetadataReader.readMetadata(imageSource);
        exifIFD0Directory = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
        jpegDirectory = (JpegDirectory) metadata.getFirstDirectoryOfType(JpegDirectory.class);
        orientation = 1;
        try {
            orientation = exifIFD0Directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        width = jpegDirectory.getImageWidth();
        height = jpegDirectory.getImageHeight();
        affineTransform = new AffineTransform();
        switch (orientation) {
            case 1:
                break;
            case 2: // Flip X
                affineTransform.scale(-1.0, 1.0);
                affineTransform.translate(-width, 0);
                break;
            case 3: // PI rotation
                affineTransform.translate(width, height);
                affineTransform.rotate(Math.PI);
                break;
            case 4: // Flip Y
                affineTransform.scale(1.0, -1.0);
                affineTransform.translate(0, -height);
                break;
            case 5: // - PI/2 and Flip X
                affineTransform.rotate(-Math.PI / 2);
                affineTransform.scale(-1.0, 1.0);
                break;
            case 6: // -PI/2 and -width
                affineTransform.translate(height, 0);
                affineTransform.rotate(Math.PI / 2);
                break;
            case 7: // PI/2 and Flip
                affineTransform.scale(-1.0, 1.0);
                affineTransform.translate(-height, 0);
                affineTransform.translate(0, width);
                affineTransform.rotate(3 * Math.PI / 2);
                break;
            case 8: // PI / 2
                affineTransform.translate(0, width);
                affineTransform.rotate(3 * Math.PI / 2);
                break;
            default:
                break;
        }
        affineTransformOp = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);
        destinationImage = new BufferedImage(image.getHeight(), image.getWidth(), image.getType());
        destinationImage = affineTransformOp.filter(image, destinationImage);
    }

    public BufferedImage getRotatedScaledImage(int inWidth, int inHeight) {
        return Scalr.resize(destinationImage, inWidth, inHeight);
    }
}
