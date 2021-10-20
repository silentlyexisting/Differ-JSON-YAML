package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "version 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App {
  @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
  private String format = "stylish";

  @Parameters(index = "0", description = "path to first file")
  private File filepath1;

  @Parameters(index = "0", description = "path to second file")
  private File filepath2;

  public static void main(String[] args) {
    int exitCode = new CommandLine(new App()).execute(args);
    System.exit(exitCode);
  }
}
