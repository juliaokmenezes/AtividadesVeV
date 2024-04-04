package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        for(Tarefa tarefa : listaTarefas){
            if (!Objects.equals(tarefa.getTitulo(), titulo)){
                listaTarefas.add(novaTarefa);
                return "Tarefa Adicionada a Lista!";
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

    public String excluirTarefa(Tarefa tarefa) {
        if (listaTarefas.contains(tarefa)){
            listaTarefas.remove(tarefa);
            return "Tarefa Excluída!";
        }
        else{
            return "Tarefa Inexistente";
        }

    }


    public String getListaTarefas() {
        if (listaTarefas.isEmpty()){
            return "Nenhuma tarefa foi adicionada";
        }
        else {
            ordenarTarefas();
            return formatarListaTarefas();
        }
    }

    private void ordenarTarefas() {
        Collections.sort(listaTarefas, new Comparator<Tarefa>() {
            @Override
            public int compare(Tarefa tarefa1, Tarefa tarefa2) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date data1 = dateFormat.parse(tarefa1.dataVencimento);
                    Date data2 = dateFormat.parse(tarefa2.dataVencimento);
                    int compareData = data1.compareTo(data2);
                    if (compareData != 0) {
                        return compareData;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String[] prioridades = {"Alta", "Média", "Baixa"};
                int prioridadeIndex1 = getIndex(tarefa1.prioridade, prioridades);
                int prioridadeIndex2 = getIndex(tarefa2.prioridade, prioridades);
                return Integer.compare(prioridadeIndex1, prioridadeIndex2);
            }
        });
    }

    private String formatarListaTarefas() {
        StringBuilder listaFormatada = new StringBuilder();
        int index = 1;
        for (Tarefa tarefa : listaTarefas) {
            listaFormatada.append(index).append(". ")
                    .append(tarefa.getTitulo()).append(" - ")
                    .append(tarefa.dataVencimento).append(" (")
                    .append(tarefa.prioridade).append(")\n");
            index++;
        }
        return listaFormatada.toString();
    }
    private int getIndex(String prioridade, String[] prioridades) {
        for (int i = 0; i < prioridades.length; i++) {
            if (prioridade.equals(prioridades[i])) {
                return i;
            }
        }
        return -1;
    }

    public void marcarComoConcluida(Tarefa tarefa) {
    }

    public String getStatusConclusaoTarefa(Tarefa tarefa) {
        return null;
    }
}
