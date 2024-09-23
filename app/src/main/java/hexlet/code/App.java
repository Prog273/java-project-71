package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Runnable {

    @Parameters(index = "0", description = "path to first path")
    private String filepath1;

    @Parameters(index = "0", description = "path to second path")
    private String filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: ${DEFAULT-VALUE}]", defaultValue = "stylish")
    private String format;

    public void readAndParseFiles() throws IOException {
        filepath1 = "/home/dim273/java-project-71/app/file1.json";
        filepath2 = "/home/dim273/java-project-71/app/file2.json";

        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map1 = mapper.readValue(new File(filepath1), Map.class);
        Map<String, Object> map2 = mapper.readValue(new File(filepath2), Map.class);
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
        System.out.println("Hello World!");
    }

    @Override
    public void run() {

    }
}
