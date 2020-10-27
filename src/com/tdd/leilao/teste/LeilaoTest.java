package com.tdd.leilao.teste;

import static org.junit.Assert.assertEquals;

import com.tdd.leilao.dominio.Lance;
import com.tdd.leilao.dominio.Leilao;
import com.tdd.leilao.dominio.Usuario;
import org.junit.jupiter.api.Test;


class LeilaoTest {

    @Test
    public void deveReceberUmLance() {
        Leilao leilao = new Leilao("Macbook Pro 15");
        assertEquals(0, leilao.getLances().size());

        leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));

        assertEquals(1, leilao.getLances().size());
        assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
    }
}