package collectors;

import java.io.File;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Joining {
    private File[] files = new File("src/main/java").listFiles();

    public String joinFileNamesImperative() {
        StringBuilder sb = new StringBuilder();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                sb.append(files[i].getName());
                if (i != files.length - 1) {
                    sb.append(", ");
                }
            }
        }
        return sb.toString();
    }

    public String joinFileNamesDeclarative() {
        return Stream.of(files)
                .map(File::getName)
                .collect(Collectors.joining(", "));
    }

    public String joinFileNamesParallel() {
        return Stream.of(files)
                .parallel()
                .map(File::getName)
                .collect(Collectors.joining(", "));
    }

    public String joinFileNamesParallelStringBuffer() {
        StringBuilder sb = new StringBuilder();
        Stream.of(files)
                .parallel()
                .map(File::getName)
                .forEachOrdered(s -> sb.append(s).append(", "));
        return sb.toString();
    }


}
