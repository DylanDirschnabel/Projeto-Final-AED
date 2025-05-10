/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenador;

/**
 *
 * @author User
 * @param <T>
 */
public class OrdenacaoMergeSort <T extends Comparable<T>> extends OrdenacaoAbstract<T>{

    @Override
    public void ordenar() {
        mergeSort(0, super.getInfo().length -1);
    }
    
    public void mergeSort(int inicio, int fim) {
        if(inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio);
            mergeSort(meio + 1, fim);
            merge(inicio, meio, fim);
        }
    }

    public void merge(int inicio, int meio, int fim) {
        
        int tamEsquerda = meio - inicio + 1;  
        T[] esquerda = (T[]) new Comparable[tamEsquerda];
        for(int i = 0; i < tamEsquerda; i++) {
            esquerda[i] = (T) super.getInfo()[inicio + i];
        }
        
        int tamDireita = fim - meio;
        T[] direita = (T[]) new Comparable[tamDireita];
        for(int i = 0; i < tamDireita; i++) {
            direita[i] = (T) super.getInfo()[meio + 1 + i];
        }
        
        int cEsq = 0;
        int cDir = 0;
        
        int j = inicio;
        
        for(int i = inicio; i <= fim; i++) {
            j = i;
            if((cEsq < tamEsquerda) && (cDir < tamDireita)) {
                if(esquerda[cEsq].compareTo(direita[cDir]) < 0) {
                    super.getInfo()[i] = esquerda[cEsq];
                    cEsq++;
                } else {
                    super.getInfo()[i] = direita[cDir];
                    cDir++;
                }
            } else {
                break;
            }
        }
        
        while(cEsq < tamEsquerda) {
            super.getInfo()[j] = esquerda[cEsq];
            cEsq++;
            j++;
        }
        
        while(cDir < tamDireita) {
            super.getInfo()[j] = direita[cDir];
            cDir++;
            j++;
        }
         
    }
    
}
