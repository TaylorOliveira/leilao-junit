package com.tdd.leilao.teste;

import static org.junit.Assert.assertEquals;

import com.tdd.leilao.dominio.Lance;
import com.tdd.leilao.dominio.Leilao;
import com.tdd.leilao.dominio.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LeilaoTest {

    private Leilao leilao;
    private Usuario steveJobs;
    private Usuario billGates;
    private Usuario taylor;
    private Usuario luennys;

    @BeforeEach
    public void setUp() {

        this.leilao = new Leilao("Macbook Pro 15");
        this.steveJobs = new Usuario("Steve Jobs");
        this.billGates = new Usuario("Bill Gates");
        this.taylor = new Usuario("Taylor Oliveira");
        this.luennys = new Usuario("Luennys de Almeida");
    }

    @Test
    public void deveReceberUmLance() {

        assertEquals(0, this.leilao.getLances().size());

        this.leilao.propoe(new Lance(this.steveJobs, 2000));

        assertEquals(1, this.leilao.getLances().size());
        assertEquals(2000.0, this.leilao.getLances().get(0).getValor(), 0.00001);
    }

    @Test
    public void deveReceberVariosLances() {

        this.leilao.propoe(new Lance(this.steveJobs, 2000));
        this.leilao.propoe(new Lance(this.billGates, 3000));

        assertEquals(2, this.leilao.getLances().size());
        assertEquals(2000.0, this.leilao.getLances().get(0).getValor(), 0.00001);
        assertEquals(3000.0, this.leilao.getLances().get(1).getValor(), 0.00001);
    }

    @Test
    public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {

        this.leilao.propoe(new Lance(this.steveJobs, 2000.0));
        this.leilao.propoe(new Lance(this.steveJobs, 3000.0));

        assertEquals(1, this.leilao.getLances().size());
        assertEquals(2000.0, this.leilao.getLances().get(0).getValor(), 0.00001);
    }

    @Test
    public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {

        Leilao leilao = new CriadorDeLeilao.leilao("Playstation 5")
                .lance(this.steveJobs, 2000.0)
                .lance(this.billGates, 3000.0)
                .lance(this.steveJobs, 4000.0)
                .lance(this.billGates, 5000.0)
                .lance(this.steveJobs, 6000.0)
                .lance(this.billGates, 9000.0)
                .lance(this.steveJobs, 10000.0)
                .lance(this.billGates, 11000.0)
                .lance(this.steveJobs, 12000.0)
                .lance(this.billGates, 15000.0);

        assertEquals(10, this.leilao.getLances().size());
        assertEquals(11000.0, this.leilao.getLances().get(
                this.leilao.getLances().size()-1).getValor(), 0.00001);
    }

    @Test
    public void deveDobrarOUltimoLanceDado(){

        this.leilao.propoe(new Lance(this.taylor, 2000));
        this.leilao.propoe(new Lance(this.luennys, 3000));
        this.leilao.dobraLance(this.taylor);

        assertEquals(4000, this.leilao.getLances().get(2).getValor(), 0.00001);
    }

    @Test
    public void naoDeveDobrarCasoNaoHajaLanceAnterior() {

        this.leilao.dobraLance(this.steveJobs);

        assertEquals(0, this.leilao.getLances().size());
    }
}