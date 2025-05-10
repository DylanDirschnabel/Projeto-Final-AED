/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ordenador.ListaEstatica;
import ordenador.OrdenacaoMergeSort;
import pilha.PilhaLista;
import pilha.PilhaVaziaException;

/**
 * Classe usada para analisar a validade de um arquivo html
 * @author Dylan Dirschnabel
 */
public class AnalisadorHTML {
    private String[] singletonTags = {"meta", "base", "br", "col", "command", "embed", "hr", "img", "input", "link", "param", "source", "!DOCTYPE"};
    private ListaEstatica<Tag> lista;
    private OrdenacaoMergeSort<Tag> ordenador = new OrdenacaoMergeSort();

    /**
     * Classe usada para extrair texto do arquivo html
     * Confere se o arquivo é do tipo html
     * @param path
     * @return String referente ao texto do arquivo html
     * @throws FileNotFoundException 
     * @throws ArquivoInvalidoException
     */
    public String extrairArquivo(String path) throws FileNotFoundException{
        
        if(path.length() < 6 || !path.substring(path.length() - 5, path.length()).equals(".html")) {
            throw new ArquivoInvalidoException("Tipo de arquivo inválido");
        }
        
        String texto = "";
        File arquivo = new File(path);
        Scanner scanner = new Scanner(arquivo);

        
        while(scanner.hasNext()) {
            texto += scanner.nextLine();
        }
        return texto;
    }
    
    /**
     * Confere a validade do arquivo html
     * @param texto : refere-se aao texto do arquivo html
     * @return String apontando se o arquivo é válido ou se possui algum erro
     */
    public String Validar(String texto) {
            lista = new ListaEstatica();
            
            PilhaLista<Tag> pilha = new PilhaLista();
            Pattern pattern = Pattern.compile("<[^<>]+?>", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(texto);
            try {
                while(matcher.find()) {
                    Tag tag = tratarTag(texto.substring(matcher.start(), matcher.end()));
                    if(tag.getTipo() != TagTipo.tagFinal) {
                        inserirTag(tag);
                    }

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

                if(pilha.estaVazia()) {
                    return "O arquivo está bem formatado";
                }
                return "Faltam tags finais: " + pilha.toString();
            } catch (PilhaVaziaException e) {
                return "Arquivo inválido: começou com tag final";
            }
            
        
    }
    
    /**
     * Cria instância do tipo tag para um pedaço de texto
     * @param texto : String referente a uma tag
     * @return Tag
     */
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
        
        Tag tag = new Tag();
        tag.setNome(texto.substring(1, texto.length() -1).toLowerCase());
        if(isSingleton(tag.getNome())) {
            tag.setTipo(TagTipo.tagSingleton);
        } else if(isComentario(tag.getNome())) {
            tag.setTipo(TagTipo.tagComentario);
            tag.setNome("comentario");
        } else {
            tag.setTipo(TagTipo.tagInicial);
        }
        
        return tag;

    }
    
    /**
     * Verifica se tag é final
     * @param texto: pedaço de texto referente a uma tag
     * @return boolean
     */
    private boolean isFinal(String texto) {
        return texto.charAt(1) == '/';
    }
    
    /**
     * Verifica se tag é do tipo singleton
     * @param texto: pedaço de texto referente a uma tag
     * @return boolean
     */
   private boolean isSingleton (String texto) {
       for(String singleton : singletonTags) {
           if(texto.equals(singleton.toLowerCase())) {
               return true;
           }
       }
       return false;
   } 
   
   /**
    * Verifica se tag é do tipo comentário
    * @param texto: pedaço de texto referente a uma tag
    * @return boolean
    */
    private boolean isComentario(String texto) {
        Pattern pattern = Pattern.compile("!--.*?--", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(texto);
        if(matcher.find()) {
            return true;
        }
        return false;
    }
    
    /**
     * Insere tag na lista de tags caso ainda não esteja na lista
     * Caso esteja, soma sua quantidade em um 
     * @param tag: tag a ser inserida
     */
    private void inserirTag(Tag tag) {
        for(int i = 0; i < lista.getTamanho(); i++) {
            if(tag.getNome().equals( lista.obterElemento(i).getNome())) {
                lista.obterElemento(i).setQuantidade(lista.obterElemento(i).getQuantidade() + 1);
                return;
            }
        }
        tag.setQuantidade(1);
        lista.inserir(tag);
    }
    
    /**
     * Ordena a lista de tags e retorna uma cópia
     * @return Tag[]
     */
    public Tag[] enviarTagsOrdenadas() {
        Tag[] tmp = new Tag[lista.getTamanho()];
        for(int i = 0; i < tmp.length; i++) {
            tmp[i] = (Tag) lista.getInfo()[i];
        }
        ordenador.setInfo(tmp);
        ordenador.ordenar();
        return ordenador.getInfo();
    }
   
}
