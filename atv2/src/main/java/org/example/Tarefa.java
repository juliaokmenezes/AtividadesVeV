package org.example;

public class Tarefa {

    String titulo;
    String descricao;
    String dataVencimento;
    String prioridade;
    public Tarefa(String titulo, String descricao, String dataVencimento, String prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.prioridade = prioridade;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getDataVencimento() {
        return this.dataVencimento;
    }

    public String getPrioridade() {
        return this.prioridade;
    }
}
