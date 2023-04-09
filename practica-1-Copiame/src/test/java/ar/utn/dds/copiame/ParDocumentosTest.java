package ar.utn.dds.copiame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ParDocumentosTest {
    @Test
    public void testDocumentosIguales() {
        Documento doc1 = new Documento("","hola");
        Documento doc2 = new Documento("","hola");
        ParDocumentos parDoc = new ParDocumentos(doc1,doc2);

        assertTrue(parDoc.esCopia(0.6f),
                "los textos que son iguales tienen que dar verdadero, que son copia");
    }
    @Test
    public void testDocumentosDistintos() {
        Documento doc1 = new Documento("","hola");
        Documento doc2 = new Documento("","chau");
        ParDocumentos parDoc = new ParDocumentos(doc1,doc2);

        assertFalse(parDoc.esCopia(0.6f),
                "los textos que son distintos tienen que dar falso, que son copia");
    }
    @Test
    public void testDocumentosParecidos() {
        Documento doc1 = new Documento("","hola");
        Documento doc2 = new Documento("","halo");
// el 3er parámetro es una toleracia para comparar (decir si son iguales) los números con punto flotante
        ParDocumentos parDoc = new ParDocumentos(doc1,doc2);
        assertTrue(parDoc.esCopia(0.5f),
                "los textos que son parecidos y la distancia es igual al umbral, entonces debe dar verdadero que son copia");
    }
}
