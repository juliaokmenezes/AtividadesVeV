package functionalTests;

import org.example.GerenciadorTarefas;
import org.example.Tarefa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TabelaDecisao {
    @Test
    void main() {
    }

    @Test
    public void testeCasoDeTeste1() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        Tarefa tarefa = null;
        String resposta = gerenciadorTarefas.excluirTarefa(tarefa);
        assertEquals("Tarefa Inexistente", resposta);
    }

    @Test
    public void testeCasoDeTeste2() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2050", "alta");
        Tarefa tarefa = gerenciadorTarefas.getTarefa("titulo");
        String resposta = gerenciadorTarefas.excluirTarefa(tarefa);
        assertEquals("Esta tarefa ainda está no prazo, e tem alta prioridade.", resposta);
    }

    @Test
    public void testeCasoDeTeste3() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2050", "baixa");
        Tarefa tarefa = gerenciadorTarefas.getTarefa("titulo");
        String resposta = gerenciadorTarefas.excluirTarefa(tarefa);
        assertEquals("Tarefa Excluída!", resposta);
    }

    @Test
    public void testeCasoDeTeste4() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2000", "alta");
        Tarefa tarefa = gerenciadorTarefas.getTarefa("titulo");
        String resposta = gerenciadorTarefas.excluirTarefa(tarefa);
        assertEquals("Tarefa Excluída!", resposta);
    }

    @Test
    public void testeCasoDeTeste5() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2000", "baixa");
        Tarefa tarefa = gerenciadorTarefas.getTarefa("titulo");
        String resposta = gerenciadorTarefas.excluirTarefa(tarefa);
        assertEquals("Tarefa Excluída!", resposta);
    }
}


