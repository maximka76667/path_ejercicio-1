import java.nio.file.Path;
import java.nio.file.Paths;

public class _01 {

	public static void main(String[] args) {
		Path path = Paths.get(System.getProperty("user.dir"));

		System.out.println("Ruta completa: " + path);
		System.out.println("El nombre de la carpeta: " + path.getFileName());
		System.out.println("Nodo raíz: " + path.getRoot());

		for (int i = 0; i < path.getNameCount(); i++) {
			System.out.println("La carpeta de la ruta " + (i + 1) + ": " + path.getName(i));
		}

		Path rutaLeeme = path.resolve("leeme.txt");
		System.out.println(rutaLeeme);

		System.out.println(path);

	}
}
