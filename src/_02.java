import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _02 {

	public static void main(String[] args) {

		Path path = Paths.get("C:\\Windows\\System.ini");

		if (!Files.exists(path)) {
			return;
		}

		System.out.println("Permiso lectura: " + Files.isReadable(path));
		System.out.println("Permiso escritura: " + Files.isWritable(path));

		Path output = Paths.get(System.getProperty("user.home")).resolve("sistema.ini");

		try {
			Files.copy(path, output);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
