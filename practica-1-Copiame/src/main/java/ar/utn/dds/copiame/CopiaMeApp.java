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
//Cargo el Lote del Sistema de archivos --> Utilizo la Capa Persistencia (Mezclo capa de presentacion en cargar Lote para comprobar correcto funcionamiento)
    Lote lote = new Lote(args[0]);
    lote.cargar();

    // ------------------------------------------------
    // Utilizo la capa de Dominio -- NO leo datos de otra fuente -- NO pido ni muestro información
    float umbral = 0.5f;
    AnalisisDeCopia analisis = new AnalisisDeCopia(umbral, lote);
    ResultadoLote resultado = analisis.procesar();
    //--------------------
    // Muestro la informacion por pantalla --> Capa de Prsentacion
    if(resultado.getPosiblesCopias().size() > 0) {
            System.out.println("Se encontraron las siguientes posibles copias:");
            for (ParDocumentos par : resultado.getPosiblesCopias()) {
                System.out.println(par.getDocumento1().getAutor() + " " + par.getDocumento2().getAutor());
            }
        }else {
            System.out.println("No se encontraron posibles copias!");
        }
//-------------

}}
