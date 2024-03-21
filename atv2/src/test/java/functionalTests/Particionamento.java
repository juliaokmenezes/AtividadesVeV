package functionalTests;


import org.example.GerenciadorTarefas;
import org.example.Tarefa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Particionamento {
    @Test
    void main() {
    }

    @Test
    public void testeExibirListaVazia() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        String lista = gerenciadorTarefas.getListaTarefas();
        String listaEsperada ="Nenhuma tarefa foi adicionada";
        assertEquals(listaEsperada, lista);

    }

    @Test
    public void testeExibirListaPrioridadeAltaParaBaixa() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.addTarefa("Tarefa Alta", "descrição 1", "01/01/2024", "alta");
        gerenciadorTarefas.addTarefa("Tarefa Baixa", "descrição 2", "01/01/2024", "baixa");
        String lista = gerenciadorTarefas.getListaTarefas();
        String listaEsperada = "1. Tarefa Alta - 01/01/2024 (alta)\n" + "2. Tarefa Baixa - 01/01/2024 (baixa)\n";
        assertEquals(listaEsperada, lista);
    }
    @Test
    public void testeExibirListaDataVencimentoProxima() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.addTarefa("Tarefa Alta", "descrição 1", "20/03/2024", "alta");
        gerenciadorTarefas.addTarefa("Tarefa Baixa", "descrição 2", "01/01/2024", "baixa");
        String lista = gerenciadorTarefas.getListaTarefas();
        String listaEsperada = "1. Tarefa Baixa - 01/01/2024 (baixa)\n" + "2. Tarefa Alta - 20/03/2024 (alta)\n";
        assertEquals(listaEsperada, lista);
    }
}
