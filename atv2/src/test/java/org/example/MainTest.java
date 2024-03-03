package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void main() {
    }

    @Test
    public void testCriarTarefa() {
        // Preparação
        String titulo = "Minha Tarefa";
        String descricao = "Descrição da minha tarefa";
        String dataVencimento = "02/03/2024";
        String prioridade = "alta";
        Tarefa novaTarefa = new Tarefa(titulo, descricao, dataVencimento, prioridade);

        assertEquals(titulo, novaTarefa.getTitulo());
        assertEquals(descricao, novaTarefa.getDescricao());
        assertEquals(dataVencimento, novaTarefa.getDataVencimento());
        assertEquals(prioridade, novaTarefa.getPrioridade());
    }

    @Test
    public void testAdicionarTarefa() {

        String tarefaADD = addTarefa("titulo", "descricao", "01/01/2001", "prioridade");
        assertEquals("Tarefa Adicionada a Lista!", tarefaADD);
    }
    @Test
    public void testConferirListaTarefas() {

        addTarefa("titulo", "descricao", "01/01/2001", "alta");
        addTarefa("titulo2", "descricao2", "01/01/2001", "baixa");
        Tarefa[] listaTarefaOficial = getListaTarefa();

        int tamLista = listaTarefaOficial.getQtdTarefas();

        assertEquals(2, tamLista);
        assertTrue(listaTarefas.contains(tarefa1));
    }

    @Test
    public void testeExibirTarefa() {
        String titulo = "titulo";
        String descricao = "Descrição da minha tarefa";
        addTarefa(titulo, descricao, "01/01/2001", "alta");
        Tarefa tarefa = getTarefa("titulo");

        assertEquals(titulo, tarefa.getTitulo());
        assertEquals(descricao, tarefa.getDescricao());
    }
    @Test
    public void testeAtualizarTituloTarefa() {
        addTarefa("titulo", "descricao", "01/01/2001", "alta");
        String tarefaAtualizada = atualizarTituloTarefa(novaTarefa, "novoTitulo");
        assertEquals("Título Alterado!", tarefaAtualizada);
    }

    @Test
    public void testeAtualizarDescricaoTarefa() {
        addTarefa("titulo", "descricao", "01/01/2001", "alta");
        Tarefa novaTarefa = getTarefa("titulo");

        String tarefaAtualizada = atualizarDescricaoTarefa(novaTarefa, "novaDescricao");
        assertEquals("Descrição Alterada!", tarefaAtualizada);
    }

    @Test
    public void testeAtualizarDataVencimentoTarefa() {
        addTarefa("titulo", "descricao", "01/01/2001", "alta");
        Tarefa novaTarefa = getTarefa("titulo");
        String tarefaAtualizada = atualizarDataVencimentoTarefa(novaTarefa, "02/02/2002");
        assertEquals("Data de Vencimento Alterada!", tarefaAtualizada);
    }


    @Test
    public void testeAtualizarPrioridadeAltaTarefa() {
        addTarefa("titulo", "descricao", "01/01/2001", "alta");
        Tarefa novaTarefa = getTarefa("titulo");
        String tarefaAtualizada = atualizarPrioridadeAltaTarefa(novaTarefa);
        assertEquals("A prioridade desta tarefa agora é ALTA", tarefaAtualizada);
    }

    @Test
    public void testeAtualizarPrioridadeBaixaTarefa() {
        addTarefa("titulo", "descricao", "01/01/2001", "alta");
        Tarefa novaTarefa = getTarefa("titulo");
        String tarefaAtualizada = atualizarPrioridadeBaixaTarefa(novaTarefa);
        assertEquals("A prioridade desta tarefa agora é BAIXA", tarefaAtualizada);
    }

    @Test
    public void testeAtualizarPrioridadeMediaTarefa() {
        addTarefa("titulo", "descricao", "01/01/2001", "alta");
        Tarefa novaTarefa = getTarefa("titulo");
        String tarefaAtualizada = atualizarPrioridadeMediaTarefa(novaTarefa);
        assertEquals("A prioridade desta tarefa agora é MÉDIA", tarefaAtualizada);
    }

    @Test
    public void testeExcluirTarefaExistente() {
        Tarefa[] listaTarefas = getListaTarefa();
        addTarefa("titulo", "descricao", "01/01/2001", "alta");
        Tarefa tarefa = getTarefa("titulo");
        listaTarefas.adicionarTarefa(tarefa);

        listaTarefas.excluirTarefa(tarefa);
        assertFalse(listaTarefas.contemTarefa(tarefa));
    }

    @Test
    public void testeExcluirTarefaInexistente() {
        Tarefa[] listaTarefas = getListaTarefa();
        addTarefa("titulo", "descricao", "01/01/2001", "alta");
        Tarefa tarefa = getTarefa("titulo");
        listaTarefas.excluirTarefa(tarefa);

        assertTrue(listaTarefas.getTarefas().isEmpty());
    }

    @Test
    public void testeExibirListaVazia() {
        Tarefa[] listaTarefas = getListaTarefa();
        assertEquals(0, listaTarefas.length);

    }

    @Test
    public void testeExibirListaOrdenada() {
        Tarefa[] listaTarefas = getListaTarefa();
        addTarefa("Titulo1", "Descricao1", "05/01/2024", "Alta");
        addTarefa("Titulo2", "Descricao2", "02/01/2024", "Média");
        addTarefa("Titulo3", "Descricao3", "03/01/2024", "Alta");
        addTarefa("Titulo4", "Descricao4", "03/01/2024", "Baixa");
        addTarefa("Titulo5", "Descricao5", "01/01/2024", "Baixa");


        String listaEsperada = "1. Título5 - 01/01/2024 (Baixa)\n" +
                "2. Título2 - 02/01/2024 (Média)\n" +
                "3. Título3 - 03/01/2024 (Alta)\n" +
                "4. Título4 - 03/01/2024 (Baixa)\n" +
                "5. Título1 - 05/01/2024 (Alta)";
        assertEquals(listaEsperada, listaTarefas.exibirLista());
    }
}
