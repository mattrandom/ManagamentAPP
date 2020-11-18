package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public static void createNewFile(String fileName) throws IOException {
        String path = System.getProperty("user.dir");
        Path homePath = Paths.get(path);
        Path textFile = homePath.resolve(fileName);
        if (!Files.exists(textFile)) {
            Files.createFile(textFile);
        }
    }
}
