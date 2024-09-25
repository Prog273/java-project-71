package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.Callable;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable {

    @Parameters(index = "0", description = "path to first path")
    private String filepath1;

    @Parameters(index = "0", description = "path to second path")
    private String filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: ${DEFAULT-VALUE}]", defaultValue = "stylish")
    private String format;

    public void readAndParseFiles() throws Exception {
            filepath1 = "/home/dim273/java-project-71/app/file1.json";
            filepath2 = "/home/dim273/java-project-71/app/file2.json";

            Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        if (!Files.exists(path1)) {
            throw new Exception("File '" + path1 + "' does not exist");
        }

        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();
        if (!Files.exists(path2)) {
            throw new Exception("File '" + path2 + "' does not exist");
        }

        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        System.out.println(content1);
        System.out.println(content2);
        ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map1 = mapper.readValue(content1, Map.class);
            Map<String, Object> map2 = mapper.readValue(content2, Map.class);
        }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
        System.out.println("Hello World!");
    }

    @Override
    public Object call() {

        return null;
    }
}
