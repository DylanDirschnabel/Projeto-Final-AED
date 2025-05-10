/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package validador;

/**
 * Erro lançado caso o arquivo a ser analisado não seja do tipo '.html'
 * @author Dylan Dirschnabel
 */
public class ArquivoInvalidoException extends RuntimeException {

    /**
     * Creates a new instance of <code>ArquivoInvalidoException</code> without
     * detail message.
     */
    public ArquivoInvalidoException() {
    }

    /**
     * Constructs an instance of <code>ArquivoInvalidoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ArquivoInvalidoException(String msg) {
        super(msg);
    }
}
