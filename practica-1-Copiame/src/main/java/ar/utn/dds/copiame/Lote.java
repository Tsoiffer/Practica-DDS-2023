package ar.utn.dds.copiame;

import java.util.List;

public class Lote {
    private String directorio;
    private List<Documento> documentos;

    public Lote(String directorio){
        this.directorio = directorio;
    }

    public void cargar(){
        return;
    }

    public List<Documento> getDocumentos() {
        return this.documentos;
    }
}
