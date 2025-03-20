package br.edu.insper.desagil.aps5.insee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataTest {
    private static final double DELTA = 0.000001;
    private Data data;

    @BeforeEach
    void setUp(){
        data = new Data();
    }

    @Test
    public void constroi(){
        assertEquals(1970, data.getAno(), DELTA);
        assertEquals(1, data.getMes(), DELTA);
        assertEquals(1, data.getDia(), DELTA);
    }

    @Test
    public void naoAtualizaMenor(){
        data.atualiza(1969, 0, 0);
        assertEquals(1970, data.getAno(), DELTA);
        assertEquals(1, data.getMes(), DELTA);
        assertEquals(1, data.getDia(), DELTA);
    }

    @Test
    public void atualizaMaior(){
        data.atualiza(2024, 13, 32);
        assertEquals(2024, data.getAno(), DELTA);
        assertEquals(12, data.getMes(), DELTA);
        assertEquals(31, data.getDia(), DELTA);
    }

    @Test
    public void atualiza(){
        data.atualiza(2024, 9, 26);
        assertEquals(2024, data.getAno(), DELTA);
        assertEquals(9, data.getMes(), DELTA);
        assertEquals(26, data.getDia(), DELTA);
    }

    @Test
    public void comoZero(){
        assertEquals(0, data.comoInteiro(), DELTA);
    }

    @Test
    public void comoAgora(){
        data.atualiza(2024, 9, 26);
        assertEquals(19978, data.comoInteiro(), DELTA);
    }








}
