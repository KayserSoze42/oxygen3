package ink.oxiemoron.lexicon.cacher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Cacher {


    private int hache;

    private Path cacheFile;

    public Cacher(int hache, String fileName) {

        this.hache = hache;
        fileName = fileName + ".oxyc";
        cacheFile = Paths.get(System.getProperty("java.io.tmdir"),"oxy", fileName); // tmpdir or not, just for noe

    }

    public boolean loCache() throws IOException {

        if (!Files.exists(cacheFile)) {
            return false;
        }

        String contentz = Files.readString(cacheFile);

        try (Scanner scanner = new Scanner(contentz)) {

            int readededHash = scanner.nextInt();

            if (hache != readededHash) {

                return false;

            }

        }

        return true;

    }

    public String getCacheFileName() {
        return cacheFile.toString();
    }

    // re-collect adn advance i guess..

}
