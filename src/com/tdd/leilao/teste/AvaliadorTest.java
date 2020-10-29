package com.tdd.leilao.teste;

import com.tdd.leilao.builder.CriadorDeLeilao;
import com.tdd.leilao.dominio.Avaliador;
import com.tdd.leilao.dominio.Leilao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AvaliadorTest {

    private Avaliador leiloeiro;

    @BeforeEach
    public void setUp(){
        leiloeiro = new Avaliador();
    }

    @Test
    public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {

        Assertions.assertThrows(RuntimeException.class, () -> {
                    Leilao leilao = new CriadorDeLeilao()
                            .leilao("Playstation 3 Novo")
                            .construe();

                    leiloeiro.avalia(leilao);
                });
    }
}
