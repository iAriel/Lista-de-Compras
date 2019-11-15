/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.util.List;        

/**
 *
 * @author Ariel
 */
public class ProdutoTableModel extends AbstractTableModel{

    private List<Produto> dados = new ArrayList<>();
    private String[] colunas = {"Produto", "Quantidade", "Marca"};

    @Override
    //Colocando o nome das colunas
    public String getColumnName(int column) {
        return colunas [column];
    }
    
    
    
    
    @Override
    //Quantidade de linhas da tabela
    public int getRowCount() {
        return dados.size();
    }

    @Override
    //Quantidade de Colunas da tabela
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    //Pega os valores da tabela
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return dados.get(linha).getProduto();
            case 1:
                return dados.get(linha).getQtd();
            case 2:
                return dados.get(linha).getMarca();
        }
        
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
         
        switch(coluna){
            case 0:
                dados.get(linha).setProduto((String) valor);
                break;
            case 1:
                 dados.get(linha).setQtd((String) valor);
                 break;
            case 2:
                 dados.get(linha).setMarca((String) valor);
                 break;
        }
        
        this.fireTableRowsUpdated(linha, linha);
    }
    
    
    
    //adicionar Linha
    public void addRow(Produto p){
        this.dados.add(p);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
}
