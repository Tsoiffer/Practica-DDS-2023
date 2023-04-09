package ar.utn.dds.copiame;

import java.util.List;

public class Lote {
    private String directorio;
    private List<Documento> documentos;

    public Lote(String directorio, List<Documento> documentos) {
        this.directorio = directorio;
        this.documentos = documentos;
    }

    public void cargar(){
        return;
    }
}
