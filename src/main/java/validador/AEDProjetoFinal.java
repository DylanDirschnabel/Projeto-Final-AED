/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package validador;

import java.io.FileNotFoundException;

/**
 *
 * @author User
 */
public class AEDProjetoFinal {

    public static void main(String[] args) throws FileNotFoundException {
        AnalisadorHTML analisador = new AnalisadorHTML();
        try {
            String texto = analisador.extrairArquivo("C:\\Users\\User\\Desktop\\AEDProjetoFinal\\teste4.html");
            System.out.println(texto);
            System.out.println(analisador.Validar(texto));
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }
    }
}
