/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pilha.PilhaLista;
import pilha.PilhaVaziaException;

/**
 *
 * @author User
 */
public class AnalisadorHTML {
    private String[] singletonTags = {"meta", "base", "br", "col", "command", "embed", "hr", "img", "input", "link", "param", "source", "!DOCTYPE"};
    

    public String extrairArquivo(String path) throws FileNotFoundException {
        String texto = "";
        File arquivo = new File(path);
        Scanner scanner = new Scanner(arquivo);

        while(scanner.hasNext()) {
            texto += scanner.nextLine();
        }
        return texto;
    }
    
    public String Validar(String texto) {
        
            
            PilhaLista<Tag> pilha = new PilhaLista();
            Pattern pattern = Pattern.compile("<[^<>]+?>", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(texto);

            while(matcher.find()) {
                Tag tag = tratarTag(texto.substring(matcher.start(), matcher.end()));
                if(!isSingleton(tag)) {

                    if(tag.getTipo() == TagTipo.tagInicial) {
                        pilha.push(tag);
                    } else if (tag.getTipo() == TagTipo.tagFinal) {
                        Tag tagEsperada = pilha.pop();
                        if(!tag.getNome().equals(tagEsperada.getNome())) {
                            String quebraLinha = System.getProperty("line.separator");
                            return "Foi encontrada uma tag final inesperada!" + quebraLinha 
                                    + "Tag final encontrada: " + tag.getNome() + quebraLinha
                                    + "Tag final esperada: " + tagEsperada.getNome();
                        }
                        
                    }
                    
                }
                
            }

            if(pilha.estaVazia()) {
                return "O arquivo está bem formatado";
            }
            return "Faltam tags finais: " + pilha.toString();
            
        
    }
    
    private Tag tratarTag(String texto) {
        if(texto.contains(" ")) {
            String[] valores = texto.split(" ");
            texto = valores[0] + ">";
        }
        
        if(isFinal(texto)) {
            TagTipo tipo = TagTipo.tagFinal;
            Tag tag = new Tag(texto.substring(2, texto.length() -1).toLowerCase(), tipo);
            return tag;
        } 
        TagTipo tipo = TagTipo.tagInicial;
        Tag tag = new Tag(texto.substring(1, texto.length() -1).toLowerCase(), tipo);
        return tag;

        
    }
    
    private boolean isFinal(String texto) {
        return texto.charAt(1) == '/';
    }
    
   private boolean isSingleton (Tag tag) {
       for(String singleton : singletonTags) {
           if(tag.getNome().equals(singleton.toLowerCase())) {
               return true;
           }
       }
       return false;
   } 
   
}
