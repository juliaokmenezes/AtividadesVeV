package org.example;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void main() {
    }
    @Test
    public void testCriarTarefa() {

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
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        String tarefaADD = gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2001", "prioridade");
        assertEquals("Tarefa Adicionada a Lista!", tarefaADD);
    }

    @Test
    public void testAdicionarTarefaJaExistente() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2001", "prioridade");
        String addTarefaRepetida = gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2001", "prioridade");
        assertEquals("Tarefa já adicionada a lista!", addTarefaRepetida);
    }
    @Test
    public void testConferirAdicaoAListaTarefas() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2001", "alta");
        gerenciadorTarefas.addTarefa("titulo2", "descricao2", "01/01/2001", "baixa");
        int tamLista = gerenciadorTarefas.getQtdTarefas();
        assertEquals(2, tamLista);

    }

    @Test
    public void testConfereTarefaAdicionada(){
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2001", "alta");
        Tarefa tarefa1Adicionada = gerenciadorTarefas.getTarefa("titulo");

        assertEquals("titulo", tarefa1Adicionada.titulo);
    }

    @Test
    public void testeExibirTarefa() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        String titulo = "titulo";
        String descricao = "Descrição da minha tarefa";
        gerenciadorTarefas.addTarefa(titulo, descricao, "01/01/2001", "alta");
        Tarefa tarefa = gerenciadorTarefas.getTarefa("titulo");

        assertEquals(titulo, tarefa.getTitulo());
        assertEquals(descricao, tarefa.getDescricao());
    }
    @Test
    public void testeAtualizarTituloTarefa() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2001", "alta");
        Tarefa novaTarefa = gerenciadorTarefas.getTarefa("titulo");

        String tarefaAtualizada = gerenciadorTarefas.atualizarTituloTarefa(novaTarefa, "novoTitulo");
        assertEquals("Título Alterado!", tarefaAtualizada);
    }

    @Test
    public void testeAtualizarDescricaoTarefa() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2001", "alta");
        Tarefa novaTarefa = gerenciadorTarefas.getTarefa("titulo");

        String tarefaAtualizada = gerenciadorTarefas.atualizarDescricaoTarefa(novaTarefa, "novaDescricao");
        assertEquals("Descrição Alterada!", tarefaAtualizada);
    }

    @Test
    public void testeAtualizarDataVencimentoTarefa() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2001", "alta");
        Tarefa novaTarefa = gerenciadorTarefas.getTarefa("titulo");
        String tarefaAtualizada = gerenciadorTarefas.atualizarDataVencimentoTarefa(novaTarefa, "02/02/2002");
        assertEquals("Data de Vencimento Alterada!", tarefaAtualizada);
    }


    @Test
    public void testeAtualizarPrioridadeAltaTarefa() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2001", "alta");
        Tarefa novaTarefa = gerenciadorTarefas.getTarefa("titulo");
        String tarefaAtualizada = gerenciadorTarefas.atualizarPrioridadeAltaTarefa(novaTarefa);
        assertEquals("A prioridade desta tarefa agora é ALTA", tarefaAtualizada);
    }

    @Test
    public void testeAtualizarPrioridadeBaixaTarefa() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2001", "alta");
        Tarefa novaTarefa = gerenciadorTarefas.getTarefa("titulo");
        String tarefaAtualizada = gerenciadorTarefas.atualizarPrioridadeBaixaTarefa(novaTarefa);
        assertEquals("A prioridade desta tarefa agora é BAIXA", tarefaAtualizada);
    }

    @Test
    public void testeAtualizarPrioridadeMediaTarefa() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2001", "alta");
        Tarefa novaTarefa = gerenciadorTarefas.getTarefa("titulo");
        String tarefaAtualizada = gerenciadorTarefas.atualizarPrioridadeMediaTarefa(novaTarefa);
        assertEquals("A prioridade desta tarefa agora é MÉDIA", tarefaAtualizada);
    }

    @Test
    public void testeExcluirTarefaExistente() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2001", "alta");
        String resposta = gerenciadorTarefas.excluirTarefa(tarefa);

        assertEquals("Tarefa Excluída!", resposta);
    }

    @Test
    public void testeExcluirTarefaInexistente() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.addTarefa("titulo", "descricao", "01/01/2001", "alta");
        gerenciadorTarefas.excluirTarefa("titulo");
        String resposta = gerenciadorTarefas.excluirTarefa("titulo");

        assertEquals("Não há tarefa com este título!", resposta);
    }

    @Test
    public void testeExibirListaVazia() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        String lista = gerenciadorTarefas.getLista();
        String listaEsperada ="Nenhuma tarefa foi adicionada";
        assertEquals(listaEsperada, lista);

    }

    @Test
    public void testeExibirListaOrdenada() {
        GerenciadorTarefas gerenciadorTarefas = new GerenciadorTarefas();
        gerenciadorTarefas.getListaTarefa();
        gerenciadorTarefas.addTarefa("Titulo1", "Descricao1", "05/01/2024", "Alta");
        gerenciadorTarefas.addTarefa("Titulo2", "Descricao2", "02/01/2024", "Média");
        gerenciadorTarefas.addTarefa("Titulo3", "Descricao3", "03/01/2024", "Alta");
        gerenciadorTarefas.addTarefa("Titulo4", "Descricao4", "03/01/2024", "Baixa");
        gerenciadorTarefas.addTarefa("Titulo5", "Descricao5", "01/01/2024", "Baixa");


        String listaEsperada = "1. Título5 - 01/01/2024 (Baixa)\n" +
                "2. Título2 - 02/01/2024 (Média)\n" +
                "3. Título3 - 03/01/2024 (Alta)\n" +
                "4. Título4 - 03/01/2024 (Baixa)\n" +
                "5. Título1 - 05/01/2024 (Alta)";
        assertEquals(listaEsperada, listaTarefas.exibirLista());
    }
}
