package junit5;


import org.example.GerenciadorTarefas;
import org.example.Tarefa;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class testesJunit {
    @Test
    void main() {
    }
    GerenciadorTarefas gerenciadorTarefas;

    @BeforeEach
    public void before(){
        gerenciadorTarefas = new GerenciadorTarefas();
    }
    @Test
    @Order(1)
    public void testeExibirListaVazia() {
        String lista = gerenciadorTarefas.getListaTarefas();
        String listaEsperada ="Nenhuma tarefa foi adicionada";
        assertEquals(listaEsperada, lista);

    }

    @Test
    public void testeExibirListaPrioridadeAltaParaBaixa() {
        gerenciadorTarefas.addTarefa("Tarefa Alta", "descrição 1", "01/01/2024", "alta");
        gerenciadorTarefas.addTarefa("Tarefa Baixa", "descrição 2", "01/01/2024", "baixa");
        String lista = gerenciadorTarefas.getListaTarefas();
        String listaEsperada = "1. Tarefa Alta - 01/01/2024 (alta)\n" + "2. Tarefa Baixa - 01/01/2024 (baixa)\n";
        assertEquals(listaEsperada, lista);
    }
    @Test
    public void testeExibirListaDataVencimentoProxima() {
        gerenciadorTarefas.addTarefa("Tarefa Alta", "descrição 1", "20/03/2024", "alta");
        gerenciadorTarefas.addTarefa("Tarefa Baixa", "descrição 2", "01/01/2024", "baixa");
        String lista = gerenciadorTarefas.getListaTarefas();
        String listaEsperada = "1. Tarefa Baixa - 01/01/2024 (baixa)\n" + "2. Tarefa Alta - 20/03/2024 (alta)\n";
        assertEquals(listaEsperada, lista);
    }

    @Test
    @DisplayName("Tarefa inexistente")
    public void testeCasoDeTeste1() {
        Tarefa tarefa = null;
        String resposta = gerenciadorTarefas.excluirTarefa(tarefa);
        assertEquals("Tarefa Inexistente", resposta);
    }

    @Test
    @Disabled("é necessário implementar o método que verifica os dados da tarefa antes de adicionar")
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
    @ParameterizedTest
    @DisplayName("Data atual e dua qualquer. O dia atual é 20/03")
    @ValueSource(strings = {"20/03/2024", "27/03/2024"})
    public void testeValorLimiteDiaAtual(String datas) {
        String tarefaADD = gerenciadorTarefas.addTarefa("titulo", "descricao", datas, "prioridade");
        assertEquals("Tarefa Adicionada a Lista!", tarefaADD);
    }

    @Test
    @Disabled("é necessário adiconar métodos de checagem de data")
    @DisplayName("Data sendo o dia anterior ao dia atual")
    public void testeValorInferiorAoLimite() {
        String diaOntem = "19/03/2024";
        String tarefaADD = gerenciadorTarefas.addTarefa("titulo", "descricao", diaOntem, "prioridade");
        assertEquals("Data Inválida", tarefaADD);;
    }

    @Test
    @Disabled("é necessário implementar feature de conclusão de tarefa")
    @DisplayName("Marcar tarefa como concluida")
    public void testeMarcarTarefaConcluida() {
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2000", "baixa");
        Tarefa tarefa = gerenciadorTarefas.getTarefa("titulo");
        gerenciadorTarefas.marcarComoConcluida(tarefa);
        String status = gerenciadorTarefas.getStatusConclusaoTarefa(tarefa);
        assertEquals("Tarefa Concluida", status);
    }
    @Test
    @Disabled("é necessário implementar feature de conclusão de tarefa")
    @DisplayName("Marcar como concluida tarefa já concluida")
    public void testeMarcarTarefaConcluidaJaConcluida() {
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2000", "baixa");
        Tarefa tarefa = gerenciadorTarefas.getTarefa("titulo");
        gerenciadorTarefas.marcarComoConcluida(tarefa);
        gerenciadorTarefas.marcarComoConcluida(tarefa);
        String status = gerenciadorTarefas.getStatusConclusaoTarefa(tarefa);
        assertEquals("Essa tarefa já está como Tarefa Concluida", status);
    }


}
