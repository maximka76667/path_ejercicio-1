import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class _02 {

	public static void main(String[] args) {

		Path path = Paths.get("C:\\Windows\\System.ini");

		// Permisos
		mostrarPermisos(path);

		// Ruta copiar
		Path pathCopiar = Paths.get(System.getProperty("user.home"));

		// Copiar sin opciones
		Path pathCopiarSinSobrescribir = pathCopiar.resolve("sistema.ini");
		copiarSiExiste(path, pathCopiarSinSobrescribir);

		// Copiar con opcion sobrescribir
		Path pathSobrescribir = pathCopiar.resolve("sistema.txt");
		copiarYSobrescribir(path, pathSobrescribir);

		// Tamaño
		mostrarTamano(pathSobrescribir);

		// Borrar
		borrarSiExiste(pathSobrescribir);

		// Crear ruta de carpetas
		crearCarpetas(Paths.get("C:\\FACTURAS\\2012\\ENERO"));

		System.out.println("FIN");
	}

	public static void mostrarPermisos(Path path) {
		if (!Files.exists(path)) {
			return;
		}

		System.out.println("Permiso lectura: " + Files.isReadable(path));
		System.out.println("Permiso escritura: " + Files.isWritable(path));
	}

	public static void copiarSiExiste(Path input, Path output) {

		try {
			if (!Files.exists(input)) {
				System.out.println("Fichero origen no existe");
				return;
			}
			if (Files.exists(output)) {
				System.out.println("Fichero destino ya existe");
				return;
			}
			Files.copy(input, output);
			System.out.println("Fichero ha copiado correctamente");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copiarYSobrescribir(Path input, Path output) {
		try {
			if (!Files.exists(input)) {
				System.out.println("Fichero origen no existe");
				return;
			}
			Files.copy(input, output, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Fichero ha copiado correctamente");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void mostrarTamano(Path path) {
		try {
			System.out.println(Files.size(path) + " bytes");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void borrarSiExiste(Path path) {
		try {
			Files.deleteIfExists(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void crearCarpetas(Path path) {
		try {
			Files.createDirectories(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
