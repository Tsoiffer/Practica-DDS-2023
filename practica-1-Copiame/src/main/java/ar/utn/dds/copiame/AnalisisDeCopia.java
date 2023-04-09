package ar.utn.dds.copiame;

import org.paukov.combinatorics3.Generator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AnalisisDeCopia {
    private Float umbral;
    private Lote lote;

    public AnalisisDeCopia(Float umbral, Lote lote) {
        this.umbral = umbral;
        this.lote = lote;
    }

    public ResultadoLote procesar(){
        // Genero todos los pares de documentos Posibles
        List<ParDocumentos> pares = Generator.combination(this.lote.getDocumentos())
                .simple(2)
                .stream()
                .map(t-> new ParDocumentos(t.get(0),t.get(1)) )
                .collect(Collectors.toList());
// Armo el resultado procesando cada par
        ResultadoLote rl = new ResultadoLote();
        rl.setFechaInicio(LocalDateTime.now());
        for (ParDocumentos parDocumentos : pares) {
            if(parDocumentos.esCopia(this.umbral)) {
                rl.agregarPar(parDocumentos);
            }
        }
        rl.setFechaFin(LocalDateTime.now());
        return rl;
    }
}
