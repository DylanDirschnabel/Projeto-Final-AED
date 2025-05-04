/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao1.aedprojetofinal;

/**
 *
 * @author User
 */
public class Tag {

    private String nome;
    private TagTipo tipo;
    
    public Tag(String nome, TagTipo tipo) {
        setNome(nome);
        setTipo(tipo);
    }

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
    
    @Override
    public String toString() {
        return nome;
    }
}
