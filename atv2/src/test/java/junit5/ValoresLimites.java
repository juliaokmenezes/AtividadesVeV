package junit5;


import org.example.GerenciadorTarefas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValoresLimites {
    @Test
    void main() {
    }
    @Test
    public void testeValorLimiteInferiorDiaAtual() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        String diaHoje = "20/03/2024";
        String tarefaADD = gerenciadorTarefas.addTarefa("titulo", "descricao", diaHoje, "prioridade");
        assertEquals("Tarefa Adicionada a Lista!", tarefaADD);
    }

    @Test
    public void testeValorInferiorAoLimite() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        String diaHoje = "20/03/2024";
        String diaOntem = "19/03/2024";
        String tarefaADD = gerenciadorTarefas.addTarefa("titulo", "descricao", diaOntem, "prioridade");
        assertEquals("Data Inválida", tarefaADD);;
    }

    @Test
    public void testeValorQualquer() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        String diaHoje = "20/03/2024";
        String proximaSemana = "27/03/2024";
        String tarefaADD = gerenciadorTarefas.addTarefa("titulo", "descricao", proximaSemana, "prioridade");
        assertEquals("Tarefa Adicionada a Lista!", tarefaADD);
    }
}