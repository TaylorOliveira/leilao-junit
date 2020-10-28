package com.tdd.leilao.builder;

import com.tdd.leilao.dominio.Lance;
import com.tdd.leilao.dominio.Leilao;
import com.tdd.leilao.dominio.Usuario;

public class CriadorDeLeilao {

    private Leilao leilao;

    public CriadorDeLeilao leilao(String descricao) {
        this.leilao = new Leilao(descricao);
        return this;
    }

    public CriadorDeLeilao lance(Usuario usuario, double valor){
        this.leilao.propoe(new Lance(usuario, valor));
        return this;
    }

    public Leilao construe(){
        return this.leilao;
    }
}
