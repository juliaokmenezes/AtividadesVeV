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
    }
        else{
        for(Tarefa tarefa : listaTarefas){
            if (!Objects.equals(tarefa.getTitulo(), titulo)){
                listaTarefas.add(novaTarefa);
            }
        }
    }
        return "Tarefa Adicionada a Lista!";
}

}
