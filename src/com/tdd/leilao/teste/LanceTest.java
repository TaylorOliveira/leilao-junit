package com.tdd.leilao.teste;

import com.tdd.leilao.dominio.Lance;
import com.tdd.leilao.dominio.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LanceTest {

    @Test
    public void deveRecusarLancesComValorDeZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Lance(new Usuario("John Doe"), 0);
        });
    }

    @Test
    public void deveRecusarLancesComValorNegativo() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Lance(new Usuario("John Doe"), -10);
        });
    }
}