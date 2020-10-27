package com.tdd.leilao.teste;

import static org.junit.Assert.assertEquals;

import com.tdd.leilao.dominio.MatematicaMaluca;
import org.junit.Test;

public class MatematicaMalucaTest {

    @Test
    public void deveMultiplicarNumerosMaioresQue30() {
        MatematicaMaluca matematica = new MatematicaMaluca();
        assertEquals(140*4, matematica.contaMaluca(140));
    }

    @Test
    public void deveMultiplicarNumerosMaioresQue10EMenoresQue30() {
        MatematicaMaluca matematica = new MatematicaMaluca();
        assertEquals(20*3, matematica.contaMaluca(20));
    }

    @Test
    public void deveMultiplicarNumerosMenoresQue10() {
        MatematicaMaluca matematica = new MatematicaMaluca();
        assertEquals(5*2, matematica.contaMaluca(5));
    }
}
