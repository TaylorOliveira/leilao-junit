package com.tdd.leilao.teste;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import com.tdd.leilao.dominio.FiltroDeLance;
import com.tdd.leilao.dominio.Lance;
import com.tdd.leilao.dominio.Usuario;
import org.junit.Test;

public class FiltroDeLanceTest {

    @Test
    public void deveSelecionarLancesEntre1000E3000() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLance filtro = new FiltroDeLance();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,2000),
                new Lance(joao,1000),
                new Lance(joao,3000),
                new Lance(joao, 800)));

        assertEquals(1, resultado.size());
        assertEquals(2000, resultado.get(0).getValor(), 0.00001);
    }

    @Test
    public void deveSelecionarLancesEntre500E700() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLance filtro = new FiltroDeLance();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,600),
                new Lance(joao,500),
                new Lance(joao,700),
                new Lance(joao, 800)));

        assertEquals(1, resultado.size());
        assertEquals(600, resultado.get(0).getValor(), 0.00001);
    }

    @Test
    public void deveSelecionarLancesMaioresQue5000() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLance filtro = new FiltroDeLance();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,6000),
                new Lance(joao,500),
                new Lance(joao,700),
                new Lance(joao, 800)));

        assertEquals(1, resultado.size());
        assertEquals(6000, resultado.get(0).getValor(), 0.00001);
    }

    @Test
    public void deveEliminarMenoresQue500() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLance filtro = new FiltroDeLance();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,400),
                new Lance(joao, 300)));

        assertEquals(0, resultado.size());
    }

    @Test
    public void deveEliminarEntre700E1000() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLance filtro = new FiltroDeLance();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao, 800),
                new Lance(joao, 1000),
                new Lance(joao, 700),
                new Lance(joao, 900)));

        assertEquals(0, resultado.size());
    }

    @Test
    public void deveEliminarEntre3000E5000() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLance filtro = new FiltroDeLance();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao,4000),
                new Lance(joao, 3500)));

        assertEquals(0, resultado.size());
    }
}
