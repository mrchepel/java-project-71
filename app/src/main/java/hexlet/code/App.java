package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 0.1",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<Integer> {

    @Parameters(index = "0",
            description = "path to first file",
            paramLabel = "filepath1")
    private String filepath1;

    @Parameters(index = "1",
            description = "path to second file",
            paramLabel = "filepath2")
    private String filepath2;

    @Option(names = {"-h", "--help"},
            usageHelp = true,
            description = "Show this help message and exit.")
    private boolean help;

    @Option(names = {"-V", "--version"},
            versionHelp = true,
            description = "Print version information and exit.")
    private boolean version;

    @Option(names = {"-f", "--format"},
            paramLabel = "format",
            description = "output format [default: stylish]",
            defaultValue = "stylish")
    private String format;

    @Override
    public Integer call() throws Exception {
        var diff = Differ.generate(filepath1, filepath2);
        System.out.println(diff);
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}