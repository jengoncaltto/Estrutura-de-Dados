package Pilha.lista1;

import java.util.Scanner;

public class Posfixada {
    private Integer resposta;
    private PilhaGenerica<Integer> pilha;
    private String expressao;
    private Scanner scan;

    public Posfixada(int tamanhoPilha) {
        this.pilha = new PilhaGenerica(tamanhoPilha);
        this.expressao = new String();
        this.scan = new Scanner(System.in);
    }

    public void leExpressao() {
        System.out.println("Entre com expressao posfixada: ");
        this.expressao = this.scan.next();
    }

    private boolean eOperador(char simbolo) {
        return simbolo == '*' || simbolo == '+' || simbolo == '-' || simbolo == '/';
    }

    private boolean aplicaOperador(char operador) {
        Integer operando1 = 0;
        Integer operando2 = 0;
        operando1 = (Integer)this.pilha.pop();
        operando2 = (Integer)this.pilha.pop();
        if (operando1 == null) {
            return false;
        } else if (operando2 == null) {
            return false;
        } else {
            switch (operador) {
                case '*':
                    this.pilha.push(operando1 * operando2);
                    break;
                case '+':
                    this.pilha.push(operando1 + operando2);
                    break;
                case ',':
                case '.':
                default:
                    return false;
                case '-':
                    this.pilha.push(operando2 - operando1);
                    break;
                case '/':
                    this.pilha.push(operando2 / operando1);
            }

            return true;
        }
    }

    public boolean avaliaExpressao() {
        for(int simbolo = 0; simbolo < this.expressao.length(); ++simbolo) {
            if (this.eOperador(this.expressao.charAt(simbolo))) {
                if (!this.aplicaOperador(this.expressao.charAt(simbolo))) {
                    System.out.println("Erro: a expressão está incorreta.");
                    return false;
                }
            } else if (this.expressao.charAt(simbolo) >= '0' && this.expressao.charAt(simbolo) <= '9') {
                this.pilha.push(Character.getNumericValue(this.expressao.charAt(simbolo)));
            }
        }

        this.resposta = (Integer)this.pilha.pop();
        if (this.resposta == null) {
            System.out.println("Erro desempilhando resposta.");
            return false;
        } else if (!this.pilha.vazia()) {
            System.out.println("Erro: muitos operandos.\n");
            return false;
        } else {
            return true;
        }
    }

    public void imprimeResposta() {
        System.out.println("Resposta = " + this.resposta);
    }

    public void leExpressaoInfixa(){
        System.out.println("Entre com a expressao infixa: ");
        this.expressao = this.scan.next();
    }
    public void transformaInfixaEmPos(){
        /*EXERCÍCIO 7.
            Recebe uma string > transforma em pilha
            lê a pilha infixa e add elementos na aux até encontrar um fechamento de parentese na infixa
            após achar fechamento de parentese, analisa a pilha aux
            analisa a pilha aux afim de separar numeros na pilha pos(formato pósfixado) e separar operadores na pilha op, até abertura de parentese na pilha aux
            após adicionar dois numeros que estao dentro de parenteses na pilha pos, deve recuperar operador da pilha op e add na pilha pos
            depois isso, deverá retornar para o while da analise da pilha infixa
            analisar e adicionar na pilha aux até achar fechamento e repetir o processo da linha 95
            depois de esvazir a pilha infixa e aux para pos
            transformar a pilha pos em string e chamar os métodos existentes da classe posfixada
        */
        leExpressaoInfixa();
        String s = this.expressao;
        Pilha pilhaInfixa = new Pilha(s.length());
        Pilha pilhaAux = new Pilha(s.length());
        Pilha pilhaPos = new Pilha(s.length());
        Pilha pilhaOP = new Pilha(s.length());
        int j = s.length() -1;
        while(j > -1) {
            pilhaInfixa.push(s.charAt(j));
            j--;
        }

        while(!pilhaInfixa.vazia()){
            char cAux = '\0';
            char c = pilhaInfixa.pop();
            if(c != ')'){
                pilhaAux.push(c);
                continue;
            } else {
                while(cAux != '(' && !pilhaAux.vazia()){
                    cAux = pilhaAux.pop();
                    if(Character.isDigit(cAux)){
                        pilhaPos.push(cAux);
                    } else if (cAux != '('){
                        pilhaOP.push(cAux);
                    }
                }
                if(!pilhaOP.vazia()){
                    char cop = pilhaOP.pop();
                    pilhaPos.push(cop);
                }
            }
        }

        String exp = "";
        while(!pilhaPos.vazia()){
            char c = pilhaPos.pop();
            exp = Character.toString(c).concat(exp);
        }
        this.expressao = exp;
    }

}
