package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class GerenciadorTarefas {

    private ArrayList<Tarefa> listaTarefas = new ArrayList<>();
    public GerenciadorTarefas() {

    }
    public String addTarefa(String titulo, String descricao, String dataVencimento, String prioridade){
        Tarefa novaTarefa = new Tarefa(titulo, descricao, dataVencimento, prioridade);

        if (listaTarefas.isEmpty()){
            listaTarefas.add(novaTarefa);
            return "Tarefa Adicionada a Lista!";
    }
        else{
        for(Tarefa tarefa : listaTarefas){
            if (!Objects.equals(tarefa.getTitulo(), titulo)){
                listaTarefas.add(novaTarefa);
                return "Tarefa Adicionada a Lista!";
            }
        }
    }
        return "Tarefa já adicionada a lista!";

}
    public int getQtdTarefas() {
        return listaTarefas.size();
    }

    public Tarefa getTarefa(String titulo) {
        for(Tarefa tarefa : listaTarefas){
            if (Objects.equals(tarefa.getTitulo(), titulo)){
                return tarefa;
            }
        }
        return null;
    }


    public String atualizarTituloTarefa(Tarefa tarefaParaAtualizar, String novoTitulo) {
        tarefaParaAtualizar.setTitulo(novoTitulo);
        return "Título Alterado!";
    }

    public String atualizarDescricaoTarefa(Tarefa tarefaParaAtualizar, String novaDescricao) {
        tarefaParaAtualizar.setDescricao(novaDescricao);
        return "Descrição Alterada!";
    }

    public String atualizarDataVencimentoTarefa(Tarefa tarefaParaAtualizar, String novaData) {
        tarefaParaAtualizar.setDataVencimento(novaData);
        return "Data de Vencimento Alterada!";
    }

    public String atualizarPrioridadeAltaTarefa(Tarefa tarefaParaAtualizar) {
        tarefaParaAtualizar.setPrioridade("alta");
        return "A prioridade desta tarefa agora é ALTA";
    }

    public String atualizarPrioridadeBaixaTarefa(Tarefa tarefaParaAtualizar) {
        tarefaParaAtualizar.setPrioridade("baixa");
        return "A prioridade desta tarefa agora é BAIXA";
    }

    public String atualizarPrioridadeMediaTarefa(Tarefa tarefaParaAtualizar) {
        tarefaParaAtualizar.setPrioridade("media");
        return "A prioridade desta tarefa agora é MÉDIA";
    }

}
