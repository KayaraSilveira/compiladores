import java.util.Stack;
import java.io.*;

class MaquinaPilha {

	public static void main(String[]args) {	

        Stack<Integer> pilha = new Stack<>();
        String instrucao;
        int a, b;

        try {
            BufferedReader arquivo = new BufferedReader(new FileReader(args[0]));

            while ((instrucao = arquivo.readLine()) != null) {

                switch (instrucao){

                        case "DIV":
                            a = pilha.pop();
                            b = pilha.pop();
                            pilha.push(b / a);
                            break;

                        case "SUM":
                            a = pilha.pop();
                            b = pilha.pop();
                            pilha.push(a + b);
                            break;

                        case "MULT":
                            a = pilha.pop();
                            b = pilha.pop();
                            pilha.push(a * b);
                            break;

                        case "SUB":
                            a = pilha.pop();
                            b = pilha.pop();
                            pilha.push(b - a);
                            break;
                        
                        case "PRINT":
                            System.out.println(pilha.peek());
                            break;

                        default: 
                            pilha.push(Integer.parseInt(instrucao.substring(5)));
                    }
            }

            arquivo.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        } 
        catch (IOException e) {
            System.out.println("Erro de leitura: " + e.getMessage());
        }

	}
}