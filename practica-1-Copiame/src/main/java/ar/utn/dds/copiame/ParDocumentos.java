package ar.utn.dds.copiame;

import org.apache.commons.lang3.ObjectUtils;

public class ParDocumentos {
    private Documento documento1;
    private Documento documento2;

    public ParDocumentos(Documento documento1, Documento documento2) {
        this.documento1 = documento1;
        this.documento2 = documento2;
    }

    public boolean esCopia(Float umbral){
        return this.documento1.distancia(this.documento2) <= umbral;
    }
}
