package helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtils {

	public void readingFiles(String pathFolders) throws IOException {

		try (Stream<Path> paths = Files.walk(Paths.get("/home/you/Desktop"))) {
			paths.filter(Files::isRegularFile).forEach(System.out::println);
		}
	}
}
