package br.edu.insper.desagil.aps5.insee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TempoTest {
    private static final double DELTA = 0.000001;
    private Tempo tempo;

    @BeforeEach
    void setUp(){
        tempo = new Tempo();
    }
    @Test
    public void constroi(){
        assertEquals(0, tempo.getHora(), DELTA);
        assertEquals(0, tempo.getMinutos(), DELTA);
    }

    @Test
    public void naoAtualizaMenor(){
        tempo.atualiza(-1, -1);
        assertEquals(0, tempo.getHora(), DELTA);
        assertEquals(0, tempo.getMinutos(), DELTA);
    }

    @Test
    public void atualizaMaior(){
        tempo.atualiza(24, 60);
        assertEquals(23, tempo.getHora(), DELTA);
        assertEquals(59, tempo.getMinutos(), DELTA);
    }

    @Test
    public void atualiza(){
        tempo.atualiza(15, 30);
        assertEquals(15, tempo.getHora(), DELTA);
        assertEquals(30, tempo.getMinutos(), DELTA);
    }

    @Test
    public void comoZero(){
        assertEquals(0, tempo.comoInteiro(), DELTA);
    }

    @Test
    public void comoAgora(){
        tempo.atualiza(15, 30);
        assertEquals(930, tempo.comoInteiro(), DELTA);
    }

}
