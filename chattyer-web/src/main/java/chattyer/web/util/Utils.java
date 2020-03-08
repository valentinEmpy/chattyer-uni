package chattyer.web.util;

import java.io.IOException;
import java.io.UncheckedIOException;

import org.springframework.web.multipart.MultipartFile;

public class Utils {

    private Utils() {
    }

    public static String getText(MultipartFile file) {
        try {
            return new String(file.getBytes());
        } catch (IOException e) {
            throw new UncheckedIOException("Could not extract text from multipart file", e);
        }
    }

}
