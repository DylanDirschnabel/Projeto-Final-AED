/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenador;

/**
 * Implementação de lista estática
 * @author Dylan Dirschnabel
 * @param <T>
 */
public class ListaEstatica <T> {
    private Object[] info;
    private int tamanho; 
    
    public int getTamanho() {
        return tamanho;
    }
    
    public ListaEstatica() {
        info = new Object[10];
        tamanho = 0;
    }
    
    private void redimensionar() {
        Object[] novo = new Object[tamanho + 10];
        
        for(int i = 0; i < tamanho; i++) {
            novo[i] = getInfo()[i];
        }
        
        setInfo(novo);

    }
    
    public void inserir(T valor) {
        if(tamanho == getInfo().length) {
            redimensionar();
        }
        
        info[tamanho] = valor;
        tamanho++;

    }
    
    public void exibir() {
        for(int i = 0; i < tamanho; i++) {
            System.out.println(getInfo()[i]);
        }

    }
    
    public int buscar(T valor) {
        for(int i = 0; i < tamanho; i++) {
            if(getInfo()[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }
    
    public void retirar(T valor) {
        int posicao = buscar(valor);
        if(posicao == -1) {
            return;
        }
        
        for(int i = posicao; i < tamanho - 1; i++) {
            info[i] = getInfo()[i + 1];  
        }
        info[tamanho] = null;
        tamanho--;
        
    }
    
    public void liberar() {
        setInfo(new Object[10]);
        tamanho = 0;
    }
    
    public T obterElemento(int posicao) {
        if(posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posição Inválida!");
        }
        return (T)getInfo()[posicao];
    }
    
    public boolean estaVazia() {
        return tamanho == 0;
    }
    
    @Override
    public String toString() {
        String texto = "";
        for(int i = 0; i < tamanho; i++) {
            texto += getInfo()[i].toString();
            if(i < tamanho - 1) {
                texto += ",";
            }
        }
        return texto;
    }
    
    public void inverter() {
        for(int i = 0; i < (int)tamanho/2;i++) {
            Object tmp = getInfo()[tamanho - i - 1];
            info[tamanho - i - 1] = getInfo()[i];
            info[i] = tmp;
        }
    }

    /**
     * @return the info
     */
    public Object[] getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(Object[] info) {
        this.info = info;
    }
    
    
    
    
}
