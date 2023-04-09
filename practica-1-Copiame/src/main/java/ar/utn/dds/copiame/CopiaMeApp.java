package ar.utn.dds.copiame;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopiaMeApp {
    public static void main(String @NotNull [] args) throws IOException {

        // Valido argumentos del usuario --> Capa de Presentacion
    Path pathLote = Paths.get(args[0]);
if ( ! Files.exists( pathLote )) {
        System.err.println("'" + args[0] + "' no existe...");
        System.exit(1);
    }
    // ------------------------------------
//Cargo el Lote del Sistema de archivos --> Utilizo la Capa Persistencia
    Lote lote = new Lote(args[0]);
lote.cargar();
        System.out.println("se cargo el lote");
    // ------------------------------------------------
// Utilizo la capa de Dominio -- NO leo datos de otra fuente -- NO pido ni muestro información
    float umbral = 0.5f;
        AnalisisDeCopia analisis = new AnalisisDeCopia(umbral, lote);
    ResultadoLote resultado = analisis.procesar();
//--------------------
// Muestro la informacion por pantalla --> Capa de Prsentacion
for (ParDocumentos par : resultado.getPosiblesCopias()) {
        System.out.println(par.getDocumento1().getAutor() + " " + par.getDocumento2().getAutor() );
    }
//-------------

}}
