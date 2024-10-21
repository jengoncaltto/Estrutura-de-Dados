package Fila.lista2.filaCircularSimples;

import java.security.PrivateKey;

public class Binario {
    /*
      recebe o numero
      interpreta
      devolve o resultado
     */

    public Binario() {
    }

    public static String calculaBinario(int numero){
        String binario = null;
        String aux;
        if(numero == 1){
            binario = "1";
        } else if (numero == 0) {
            binario = "0";
        } else {
            for (double i = numero; i >= 0; i = i - Math.ceil(i / 2)) {
                if (i % 2 == 0) {
                    if (i == numero) {
                        binario = "0";
                        continue;
                    }
                    aux = "0";
                    binario = aux.concat(binario);
                } else {
                    if (i == numero) {
                        binario = "1";
                        continue;
                    }
                    aux = "1";
                    binario = aux.concat(binario);
                    if (i == 1) break;
                }
            }
        }
        return binario;
    }

    public static FilaGenerica<String> formaFilaBinarios(int numero){
        FilaGenerica<String> binarios = new FilaGenerica<>(numero);
        int i = numero;
        while(i > -1){
            binarios.insere(calculaBinario(i));
            i--;
        }
        return binarios;
    }
    public static FilaGenerica<String> mostraFilaBinarios(int numero){
        return formaFilaBinarios(numero);
    }
}
