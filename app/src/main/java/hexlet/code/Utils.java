package hexlet.code;

import java.io.IOException;
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

    public static String getTextFromFile(String filePath) throws Exception {
        Path normalizePath = getPath(filePath);

        if (!Files.exists(normalizePath)) {
            throw new IOException("File '" + filePath + "' does not exist");
        }

        if (Files.isDirectory(normalizePath)) {
            throw new IOException("File '" + filePath + "' is a directory, not a file");
        }

        return Files.readString(normalizePath);
    }

    public static String getFormat(String filePath) throws IOException {
        if (filePath == null || filePath.isEmpty()) {
            return "";
        }

        int lastIndex = filePath.lastIndexOf(".");
        if (lastIndex == -1 || lastIndex == filePath.length() - 1) {
            return "";
        }

        return filePath.substring(lastIndex + 1).trim();
    }
}
