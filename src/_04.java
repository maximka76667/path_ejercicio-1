import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _04 {

	public static void main(String[] args) {

		Path input = Paths.get(System.getProperty("user.home"));

		try {
			DirectoryStream<Path> files = Files.newDirectoryStream(input);
			for (Path path : files) {
				System.out.println(path.getFileName() + " " + Files.isWritable(path) + " " + Files.size(path));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
