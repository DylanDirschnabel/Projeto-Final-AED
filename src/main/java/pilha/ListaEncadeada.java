/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilha;

import pilha.NoLista;

/**
 *
 * @author User
 */
public class ListaEncadeada <T> {
    
    private NoLista<T> primeiroNodo;

    /**
     * @return the primeiroNodo
     */
    public NoLista<T> getPrimeiroNodo() {
        return primeiroNodo;
    }
   
    public ListaEncadeada() {
        primeiroNodo = null;
    }

    public void inserir(T info) {
        NoLista<T> novo = new NoLista();
        novo.setInfo(info);
        novo.setProximoNodulo(primeiroNodo);
        primeiroNodo = novo;
    }
   
    public void exibir() {
        NoLista<T> p = primeiroNodo;
        while(p != null) {
            System.out.println(p.getInfo().toString());
            p = p.getProximoNodulo();
        }
    }
   
    public boolean estaVazia() {
        return primeiroNodo == null;
    }
   
    public NoLista<T> buscar(T v) {
        NoLista<T> p = primeiroNodo;
        while(p != null) {
            if(p.getInfo().equals(v)) {
                return p;
            }
            p = p.getProximoNodulo();
        }
        return null;
    }
   
    public void retirar(T v) {
        NoLista<T> p = primeiroNodo;
        NoLista<T> anterior = null;
       
        while(p != null && !p.getInfo().equals(v)) {
            anterior = p;
            p = p.getProximoNodulo();
        }
       
        if(p != null) {
            if(p == primeiroNodo) {
                primeiroNodo = p.getProximoNodulo();
            } else {
                anterior.setProximoNodulo(p.getProximoNodulo());
            }
        }
       
    }
   
    public int obterComprimento() {
        int contagem = 0;
        NoLista<T> p = primeiroNodo;
        while(p != null) {
            contagem++;
            p = p.getProximoNodulo();
        }
        return contagem;
    }
   
    public NoLista<T> obterNo(int idx) {
        if(idx < 0 || primeiroNodo == null) {
            throw new IndexOutOfBoundsException();
        }
        
        NoLista<T> p = primeiroNodo;
        while(idx != 0 && p.getProximoNodulo() != null) {
            p = p.getProximoNodulo();
            idx --;
        }
        if(idx != 0) {
            throw new IndexOutOfBoundsException();
        }
        return p;
    }
   
    @Override
    public String toString() {
        String texto = "";
        if(!estaVazia()) {
            texto += primeiroNodo.getInfo().toString();
            NoLista<T> p = primeiroNodo.getProximoNodulo();
            while(p != null) {
                texto += ",";
                texto += p.getInfo().toString();
                p = p.getProximoNodulo();
            }
        }
       
        return texto;
    }
    
    public void inverter() {
        NoLista<T> anterior = null;
        NoLista<T> atual = primeiroNodo;
        NoLista<T> posterior;
        
        while(atual != null) {
            posterior = atual.getProximoNodulo();
            atual.setProximoNodulo(anterior);
            anterior = atual;
            atual = posterior;
        }
        primeiroNodo = anterior;
        
    }
    
    public ListaEncadeada<T> criarInvertida() {
        ListaEncadeada<T> lista = new ListaEncadeada();
        NoLista<T> p = primeiroNodo;
        while(p != null) {
            lista.inserir((T) p.getInfo());
            p = p.getProximoNodulo();
        }
        return lista;
    }
    
    public void setPrimeiroNodo(NoLista<T> obj) {
        primeiroNodo = obj;
    }
    
}
