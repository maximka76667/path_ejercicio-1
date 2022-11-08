import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class _03 {

	public static void main(String[] args) {
		Path input = Paths.get("C:\\Windows\\");
		Path output = Paths.get(System.getProperty("user.home"));

		try {
			DirectoryStream<Path> files = Files.newDirectoryStream(input, "*.ini");
			for (Path file : files) {
				Path fileName = file.getFileName();
				Files.copy(input.resolve(fileName), output.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
				System.out.println(fileName + " ha copiado correctamente");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
