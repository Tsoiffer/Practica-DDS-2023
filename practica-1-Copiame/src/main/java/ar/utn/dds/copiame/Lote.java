package ar.utn.dds.copiame;

import ar.utn.dds.copiame.utils.ManejoDeFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Lote {
    private String directorio;
    private List<Documento> documentos;

    public Lote(String directorio){
        this.directorio = directorio;
    }

    //Mezclo capa de presentacion en cargar Lote para comprobar correcto funcionamiento
    public void cargar() throws IOException {
        Path dirpath = Paths.get(directorio);
        System.out.println("Buscando archivos de la carpeta: "+dirpath);
        List<Path> archivos = Files.list(dirpath).collect(Collectors.toList()) ;
        System.out.println("Se encontraron "+archivos.size()+ " archivos");
        this.documentos = ManejoDeFile.documentosDeLosArchivos( archivos );
        System.out.println("se cargo el lote");
        return;
    }

    public List<Documento> getDocumentos() {
        return this.documentos;
    }
}
