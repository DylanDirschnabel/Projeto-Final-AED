/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validador;

import java.util.Comparator;

/**
 * Classe representa as tags de html
 * @author Dylan Dirschnabel
 */
public class Tag implements Comparable<Tag>{

    private String nome;
    private TagTipo tipo;
    private int quantidade;
    
    /**
     * Construtor da tag usa apenas nome e tipo
     * @param nome
     * @param tipo 
     */
    public Tag(String nome, TagTipo tipo) {
        setNome(nome);
        setTipo(tipo);
    }
    
    /**
     * Construtor vazio
     */
    public Tag() {};

    /**
     * método toString() retorna nome da tag
     * @return 
     */    
    @Override
    public String toString() {
        return nome;
    }
    
    /**
     * Comparação entre tags definida por ordem alfabética
     * @param t2: outra tag a ser comparada com esta
     * @return int -1, 1 ou 0
     */
    @Override
    public int compareTo(Tag t2) {
            return getNome().compareTo(t2.getNome());
    }
    
    
    
    /**
     * Getters e setters abaixo
     */
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the tipo
     */
    public TagTipo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TagTipo tipo) {
        this.tipo = tipo;
    }
    
    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
