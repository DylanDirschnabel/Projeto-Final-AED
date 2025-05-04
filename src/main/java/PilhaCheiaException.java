/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */


/**
 *
 * @author User
 */
public class PilhaCheiaException extends RuntimeException{

    /**
     * Creates a new instance of <code>PilhaCheiaException</code> without detail
     * message.
     */
    public PilhaCheiaException() {
    }

    /**
     * Constructs an instance of <code>PilhaCheiaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PilhaCheiaException(String msg) {
        super(msg);
    }
}
