package junit5;

import org.example.GerenciadorTarefas;
import org.example.Tarefa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TabelaDecisao {
    @Test
    void main() {
    }
    private GerenciadorTarefas gerenciadorTarefas;
    @BeforeEach
    public void before(){
        gerenciadorTarefas = new GerenciadorTarefas();
    }
    @Test
    @DisplayName("Tarefa inexistente")
    public void testeCasoDeTeste1() {
        Tarefa tarefa = null;
        String resposta = gerenciadorTarefas.excluirTarefa(tarefa);
        assertEquals("Tarefa Inexistente", resposta);
    }

    @Test
    @DisplayName("Tarefa no prazo e com alta prioridade")
    public void testeCasoDeTeste2() {
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2050", "alta");
        Tarefa tarefa = gerenciadorTarefas.getTarefa("titulo");
        String resposta = gerenciadorTarefas.excluirTarefa(tarefa);
        assertEquals("Esta tarefa ainda está no prazo, e tem alta prioridade.", resposta);
    }

    @Test
    @DisplayName("Tarefa Prioridade baixa mas na validade")
    public void testeCasoDeTeste3() {
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2050", "baixa");
        Tarefa tarefa = gerenciadorTarefas.getTarefa("titulo");
        String resposta = gerenciadorTarefas.excluirTarefa(tarefa);
        assertEquals("Tarefa Excluída!", resposta);
    }

    @Test
    @DisplayName("Tarefa vencida e de alta prioridade")
    public void testeCasoDeTeste4() {
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2000", "alta");
        Tarefa tarefa = gerenciadorTarefas.getTarefa("titulo");
        String resposta = gerenciadorTarefas.excluirTarefa(tarefa);
        assertEquals("Tarefa Excluída!", resposta);
    }

    @Test
    @DisplayName("Tarefa vencida e de baixa prioridade")
    public void testeCasoDeTeste5() {
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2000", "baixa");
        Tarefa tarefa = gerenciadorTarefas.getTarefa("titulo");
        String resposta = gerenciadorTarefas.excluirTarefa(tarefa);
        assertEquals("Tarefa Excluída!", resposta);
    }
}


