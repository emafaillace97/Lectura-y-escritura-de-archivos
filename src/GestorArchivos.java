import java.io.*;

public class GestorArchivos {

    public static void escribir(String texto, String pathArchivo) {
        FileWriter escritor = null;
        try {
            escritor = new FileWriter(pathArchivo);
            escritor.append(texto);
            escritor.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void leer(String pathArchivo) {
        FileReader archivo = null;
        BufferedReader lector = null;
        try {
            archivo = new FileReader(pathArchivo);
            lector = new BufferedReader(archivo);
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
            archivo.close();
            lector.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void reemplazar(String pathOrigen, String pathDestino, String pVieja, String pNueva) {
        FileReader archivoLectura = null;
        BufferedReader lector = null;
        FileWriter escritor = null;
        try {
            archivoLectura = new FileReader(pathOrigen);
            lector = new BufferedReader(archivoLectura);
            escritor = new FileWriter(pathDestino);
            String linea;
            while ((linea = lector.readLine()) != null) {
                for (String palabra : linea.split(" ")) {
                    if (palabra.equals(pVieja)) {
                        escritor.append(pNueva + " ");
                    } else {
                        escritor.append(palabra + " ");
                    }
                }
                escritor.append("\n");
            }
            archivoLectura.close();
            lector.close();
            escritor.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        //escribir("Hola mundo!", "salida.txt");
        //leer("salida.txt");
        //reemplazar("entrada.txt", "salida.txt", "ema", "ana");
    }
}
