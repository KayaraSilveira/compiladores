import java.io.*;
import java.lang.Character;

enum TokenType{ NUM,SOMA,MULT,SUB,DIV,APar,FPar,EOF}

class Token{
  String lexema;
  TokenType token;

 Token (String l, TokenType t)
 	{ lexema=l;token = t;}	

}

class AnaliseLexica {

	RandomAccessFile arquivo;

	AnaliseLexica(String a) throws Exception
	{
		
	 	this.arquivo = new RandomAccessFile(a, "r");
	}

	Token getNextToken() throws Exception
	{	
		Token token;
		int eof = -1;
		char currchar;
		int currchar1;

			do{
				currchar1 =  arquivo.read();
				currchar = (char) currchar1;
			} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
			
			if(currchar1 != eof && currchar1 !=10)
			{
								
				if(currchar >= '0' && currchar <= '9') {
					StringBuilder temp = new StringBuilder();
					temp.append((char)currchar);
					currchar1 = arquivo.read();
					currchar = (char) currchar1;

					while (Character.isDigit(currchar)) {
						temp.append((char)currchar);
						currchar1 = arquivo.read();
						currchar = (char) currchar1;
					}

					this.arquivo.seek(this.arquivo.getFilePointer() - 1);

					return (new Token (temp.toString(), TokenType.NUM));
				}
				else
					switch (currchar){
						case '(':
							return (new Token (Character.toString(currchar),TokenType.APar));
						case ')':
							return (new Token (Character.toString(currchar),TokenType.FPar));
						case '+':
							return (new Token (Character.toString(currchar),TokenType.SOMA));
						case '*':
							return (new Token (Character.toString(currchar),TokenType.MULT));
						case '-':
							return (new Token (Character.toString(currchar),TokenType.SUB));
						case '/':
							return (new Token (Character.toString(currchar),TokenType.DIV));
						
						default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
					}
			}

			arquivo.close();
			
		return (new Token(Character.toString(currchar),TokenType.EOF));
		
	}
}
