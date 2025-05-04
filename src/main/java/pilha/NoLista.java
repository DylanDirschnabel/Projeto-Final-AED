/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilha;

/**
 *
 * @author User
 */
public class NoLista<T> {
    private T info;
    private NoLista<T> proximoNodulo;

    /**
     * @return the info
     */
    public T getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * @return the proximoNodulo
     */
    public NoLista getProximoNodulo() {
        return proximoNodulo;
    }

    /**
     * @param proximoNodulo the proximoNodulo to set
     */
    public void setProximoNodulo(NoLista proximoNodulo) {
        this.proximoNodulo = proximoNodulo;
    }
}
