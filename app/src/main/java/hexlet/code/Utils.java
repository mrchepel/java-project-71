package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {
    public static Path getPath(String path) throws Exception {
        Path filePath = Paths.get(path).toAbsolutePath().normalize();
        if (!Files.exists(filePath)) {
            throw new Exception("File '" + filePath + "' does not exist");
        }
        return filePath;
    }

    public static String getFormat(String filePath) {
        return filePath.substring(filePath.lastIndexOf('.') + 1);
    }
}
