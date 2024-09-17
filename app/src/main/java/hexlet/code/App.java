package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

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

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
        System.out.println("Hello World!");
    }

    @Override
    public void run() {

    }
}
