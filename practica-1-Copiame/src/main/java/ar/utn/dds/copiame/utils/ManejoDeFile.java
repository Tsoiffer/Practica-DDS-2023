package ar.utn.dds.copiame.utils;

import ar.utn.dds.copiame.Documento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ManejoDeFile {
    public static List<Documento> documentosDeLosArchivos(List<Path> archivos){

       return (List<Documento>) archivos.stream().filter(archivo -> esArchivoValido(archivo) ).map(archivo ->
                       {
                           try {

                               return new Documento( nombreDeAutor(archivo), contenidoDeArchivo(archivo));
                           } catch (IOException e) {
                               System.err.println(e);
                               throw new RuntimeException(e);
                           }
                       }
                )
                .collect(Collectors.toList());

    }
    public static String nombreDeAutor(Path archivo){
     return    archivo.getFileName().toString().replaceAll(".txt","");
    }
    public static String contenidoDeArchivo(Path archivo) throws IOException {
        String cadena = "";
        FileReader fr = new FileReader(String.valueOf(archivo));
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while((linea=br.readLine())!=null){
            cadena += "\n"+ linea;
        };
        return   cadena;
    }
    public static boolean esArchivoValido(Path archivo){
        return    archivo.getFileName().toString().endsWith(".txt") ;
    }
}
