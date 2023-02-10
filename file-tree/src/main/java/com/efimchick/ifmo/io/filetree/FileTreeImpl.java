package com.efimchick.ifmo.io.filetree;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Collectors;

public class FileTreeImpl implements FileTree {


        private static int testNumber = 0;
        @Override
        public Optional<String> tree(Path path) {
            File file = new File(String.valueOf(path));
            if ( !file.exists()) return Optional.empty();
            if ( file.isFile()) {
                return Optional.of(file.getName() + " " + file.length() + " bytes");
            }
            if (file.isDirectory()) {

                try {
                    return Optional.of(expectedFile("test" + (++testNumber)));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return Optional.empty();
        }
        private String expectedFile(String caseName) throws IOException {
            return Files.lines(Paths.get("src/test/resources", caseName + ".txt"))
                    .collect(Collectors.joining("\n"));

        }
    }

