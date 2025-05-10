/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ordenador;

/**
 * Classe abstrata de ordenação
 * @author Dylan Dirschnabel
 * @param <T>
 */
abstract class OrdenacaoAbstract <T extends Comparable<T>>{

    private T[] info;

    /**
     * @return the info
     */
    public T[] getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(T[] info) {
        this.info = info;
    }
    
    public void trocar(int a, int b) {
        T tmp = info[a];
        info[a] = info[b];
        info[b] = tmp;
    }
    
    public abstract void ordenar();
    
}
