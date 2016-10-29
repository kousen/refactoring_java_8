package collectors;

import java.io.File;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

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
        if (files != null)
            return Stream.of(files)
                    .filter(Objects::nonNull)
                    .map(File::getName)
                    .collect(joining(", "));
        return "";
    }
}
