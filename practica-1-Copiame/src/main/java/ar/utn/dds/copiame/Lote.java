package ar.utn.dds.copiame;

import java.io.BufferedReader;
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

    public void cargar() throws IOException {
        Path dirpath = Paths.get(directorio);
        System.out.println(dirpath);
        List<Path> archivos = Files.list(dirpath).collect(Collectors.toList()) ;
        archivos.stream().map( (Path archivo) => {});
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        System.out.println(archivos.get(0).getFileName());
        System.out.println(archivos.get(0).getFileName());
        return;
    }

    public List<Documento> getDocumentos() {
        return this.documentos;
    }
}
