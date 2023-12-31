/* Generated By:JavaCC: Do not edit this line. Lugosi.java */
import java.io.*;
import java.util.ArrayList;

//Primeira regra: Lugosi, que contém um main obrigatório, sendo o main uma lista de comandos 
//E pode ou não possuir uma lista de funções.

class LugosiA{
    Main principal;
    ArrayList<Func> listaDeFuncoes = new ArrayList();

    LugosiA(Main principal, ArrayList<Func> listaDeFuncoes)
    {
        this.principal=principal;
        this.listaDeFuncoes=listaDeFuncoes;
    }

    public String toString(){
        String retornoLugosi = new String();
        retornoLugosi += "#include<stdio.h>" + "\u005cn" + "#include<stdlib.h>" + "\u005cn" + "#include <stdbool.h>" + "\u005cn";
        for(int i = 0; i < listaDeFuncoes.size(); i++) {
            retornoLugosi += listaDeFuncoes.get(i).toString();
        }
        return retornoLugosi + principal.toString() + "\u005cn";
    }
}


class Main{
    ArrayList<DeclaraVar> declaracoes = new ArrayList();
    ArrayList<Comando> comandos = new ArrayList();

    Main(ArrayList<DeclaraVar> declaracoes, ArrayList<Comando> comandos){
        this.declaracoes = declaracoes;
        this.comandos = comandos;
    }

    public String toString(){
        String retornoMain = new String();
        retornoMain += "int main()" + "{" + "\u005cn";
        for(int i = 0; i < declaracoes.size(); i++) {
            retornoMain += declaracoes.get(i).toString();
        }
        for(int i = 0; i < comandos.size(); i++) {
            retornoMain += comandos.get(i).toString();
        }
        return retornoMain + "\u005cn" + "}";
    }
}

class DeclaraVar{
    Tipo tipo;
    Var id;

    DeclaraVar(Tipo tipo, Var id){
        this.tipo = tipo;
        this.id = id;
    }

    public String toString(){
        return tipo.toString() + " " + id.toString() + ";" + "\u005cn";
    }
}

class Vardecl{
    ArrayList<DeclaraVar> declaracoes = new ArrayList();

    Vardecl(ArrayList<DeclaraVar> declaracoes){
        this.declaracoes = declaracoes;
    }

    public String toString(){
        String retornoDeclaracoes = new String();
        for(int i=0; i<declaracoes.size(); i++){
            retornoDeclaracoes += declaracoes.get(i).toString();
            retornoDeclaracoes += "\u005cn";
        }

        return retornoDeclaracoes;
    }
}

class Tipo{
    String tipoVar;

    Tipo(String tipoVar){
        this.tipoVar = tipoVar;
    }

    public String toString(){
        return tipoVar;
    }
}



class Comando{}

class Atrib extends Comando{
   Var id;
   Exp exp;

   Atrib (Var id, Exp exp)
   {
    this.id=id;
    this.exp=exp;
   }

    public String toString(){
      return id.toString() + "=" + exp.toString() + ";" + "\u005cn";
    }

}

class chamadaDeFuncao extends Comando{
    Var id;
    ArrayList<Exp> exp = new ArrayList();

    chamadaDeFuncao(Var id, ArrayList<Exp> exp)
    {
        this.id = id;
        this.exp = exp;
    }

    public String toString() {
      String retornoExpressoes = new String();
      for(int i=0; i<exp.size(); i++) {
        retornoExpressoes += exp.get(i).toString();
        if(i != exp.size() - 1){
            retornoExpressoes += ", ";
            }
        }

      return id.toString() + "(" + retornoExpressoes + ")" + ";" + "\u005cn";
    }
}

class condicional extends Comando{
    Exp exp;
    ArrayList<Comando> seqcomandos =  new ArrayList();

    condicional(Exp exp, ArrayList<Comando> seqcomandos)
    {
        this.exp = exp;
        this.seqcomandos = seqcomandos;
    }

    public String toString(){
        String retornoCondicional = new String();
        retornoCondicional += "if" + "(" + exp.toString() + ")" + "{";
        for(int i = 0; i < seqcomandos.size(); i++) {
            retornoCondicional += seqcomandos.get(i).toString();
        }
        return retornoCondicional + "}" + "\u005cn";
    }
}

class loopWhile extends Comando{
    Exp exp;
    ArrayList<Comando> seqcomandos =  new ArrayList();

    loopWhile(Exp exp, ArrayList<Comando> seqcomandos)
    {
        this.exp = exp;
        this.seqcomandos = seqcomandos;
    }

    public String toString(){
        String retornoWhile = new String();
        retornoWhile += "while" + "(" + exp.toString() + ")" + "{" + "\u005cn";
        for(int i = 0; i < seqcomandos.size(); i++) {
            retornoWhile += seqcomandos.get(i).toString();
        }
        return  retornoWhile + "}" + "\u005cn";
    }
}

class loopDoWhile extends Comando{
    ArrayList<Comando> seqcomandos =  new ArrayList();
    Exp exp;

    loopDoWhile(ArrayList<Comando> seqcomandos, Exp exp)
    {
        this.seqcomandos = seqcomandos;
        this.exp = exp;
    }

    public String toString(){
        String retornoDoWhile = new String();
        retornoDoWhile += "do" + "{" + "\u005cn";
        for(int i = 0; i < seqcomandos.size(); i++) {
            retornoDoWhile += seqcomandos.get(i).toString();
        }
        return  retornoDoWhile + "}" + "while" + "(" + exp.toString() + ")" + ";" + "\u005cn";
    }
}

class retorno extends Comando{
    Exp exp;

    retorno(Exp exp)
    {
        this.exp = exp;
    }

    public String toString(){
        return "return" + " " + exp.toString() + ";";
    }
}

class SeqComandos{
    ArrayList<Comando> comandos = new ArrayList();

    SeqComandos(ArrayList<Comando> comandos){
        this.comandos = comandos;
    }

    public String toString(){
        String retornoComandos = new String();
        for(int i=0; i<comandos.size(); i++){
            retornoComandos += comandos.get(i).toString();
            retornoComandos += "\u005cn";
        }

        return retornoComandos;
    }
}


class print extends Comando{
    Exp exp;

    print(Exp exp)
    {
        this.exp = exp;
    }

    public String toString(){
        return "printf" + "(" + "\u005c"%d\u005c", " + exp.toString() + ")" + ";";
    }
}


class Exp{}

class operacao extends Exp{
    Exp exp1;
    Exp exp2;
    Op operador;

    operacao(Exp exp1, Exp exp2, Op operador)
    {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.operador = operador;
    }

    public String toString(){
        return "(" + exp1.toString() + operador.toString() + exp2.toString() + ")";
    }

}

//class Fator extends Exp{}

class Var extends Exp{
    String variavel = new String();

    Var(String variavel){
        this.variavel = variavel;
    }

    public String toString(){
        return variavel;
    }

}

class retornoDeFuncao extends Exp{
    Var id;
    ArrayList<Exp> exp = new ArrayList();

    retornoDeFuncao(Var id, ArrayList<Exp> exp)
    {
        this.id = id;
        this.exp = exp;
    }

    public String toString(){
      String retornoFuncoes = new String();
      for(int i=0; i<exp.size(); i++){
            retornoFuncoes += exp.get(i).toString();
            if(i != exp.size() - 1) {
                retornoFuncoes += ",";
            }
        }
      return id.toString() + "(" + retornoFuncoes + ")";
    }
}

class Num extends Exp{
    String numero;

    Num(String numero){
        this.numero = numero;
    }

    public String toString(){
        return numero;
    }
}

class Verdadeiro extends Exp{
    String v = new String();

    Verdadeiro(String v){
        this.v = v;
    }

    public String toString(){
        return "true";
    }

}

class Falso extends Exp{
    String f = new String();

    Falso(String f){
        this.f = f;
    }

    public String toString(){
        return "false";
    }

}

class Op{
    String operador;

    Op(String operador){
        this.operador = operador;
    }

    public String toString(){
        return operador;
    }
}

class Func{
    Tipo tipo;
    Var id;
    ArrayList<Arg> argumentos = new ArrayList();
    ArrayList<DeclaraVar> declaraVariaveis = new ArrayList();
    ArrayList<Comando> seqcomandos = new ArrayList();

    Func(Tipo tipo, Var id, ArrayList<Arg> argumentos, ArrayList<DeclaraVar> declaraVariaveis, ArrayList<Comando> seqcomandos){
        this.tipo = tipo;
        this.id = id;
        this.argumentos = argumentos;
        this.declaraVariaveis = declaraVariaveis;
        this.seqcomandos = seqcomandos;
    }

    public String toString(){
        String retornoFuncao = new String();
        for(int i=0; i<argumentos.size(); i++){
            retornoFuncao += argumentos.get(i).toString();
            if(i != argumentos.size() - 1) {
                retornoFuncao += ", ";
            }
        }
        retornoFuncao += ")";
        retornoFuncao += "{";
        retornoFuncao += "\u005cn";
        for(int i=0; i<declaraVariaveis.size(); i++){
            retornoFuncao += declaraVariaveis.get(i).toString();
        }
        for(int i=0; i<seqcomandos.size(); i++){
            retornoFuncao += seqcomandos.get(i).toString();
        }
        return tipo.toString() + " " + id.toString() + "(" + retornoFuncao + "}";
    }
}

class Funcoes{
    ArrayList<Func> funcao = new ArrayList();

    Funcoes(ArrayList<Func> funcao){
        this.funcao = funcao;
    }

    public String toString(){
        String retornoFuncoes = new String();
        for(int i=0; i<funcao.size(); i++){
            retornoFuncoes += funcao.get(i).toString();
            retornoFuncoes += "\u005cn";
        }

        return retornoFuncoes;
    }
}

class Arg{
    Var id;
    Tipo tipo;

    Arg(Var id, Tipo tipo){
        this.id = id;
        this.tipo = tipo;
    }

    public String toString(){
        return tipo.toString() + " " + id.toString() + "\u005cn";
    }
}

class ListaArg{
    ArrayList<Arg> argumentos = new ArrayList();

    ListaArg(ArrayList<Arg> argumentos) {
        this.argumentos = argumentos;
    }

    public String toString() {
        String retornoArgumentos = new String();
        for(int i = 0; i < argumentos.size(); i++) {
            retornoArgumentos += argumentos.get(i).toString();
            if(i != argumentos.size() - 1) {
                retornoArgumentos += ", ";
            }
        }
        return retornoArgumentos;
    }
}



public class Lugosi implements LugosiConstants {
    public static void main(String args[]) throws ParseException,IOException {
        Lugosi parser = new Lugosi(new FileInputStream(args[0]));
        LugosiA arvore = parser.Lugosi();
        System.out.println(arvore);

        OutputStream output = new FileOutputStream("main.c");
        String s = arvore.toString();

        int length = s.length()-1;
        int count = 0;

        while (count < length) {
            output.write(s.charAt(count));
            count++;
        }

        output.close();

    }

// LUGOSI -> 
  static final public LugosiA Lugosi() throws ParseException {
 Main m = null; ArrayList funcoes = new ArrayList();
    m = MAIN();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FUNCAO:
      FUNCOES(funcoes);
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
   {if (true) return new LugosiA(m, funcoes);}
    throw new Error("Missing return statement in function");
  }

//MAIN -> "main" "{" VARDECL SEQCOMANDOS "}"
  static final public Main MAIN() throws ParseException {
 ArrayList declaracoesVar = new ArrayList();
ArrayList sequenciasComandos = new ArrayList();
    jj_consume_token(MAIN);
    jj_consume_token(ACHAVES);
    VARDECL(declaracoesVar);
    SEQCOMANDOS(sequenciasComandos);
    jj_consume_token(FCHAVES);
                                                                                   {if (true) return new Main(declaracoesVar, sequenciasComandos);}
    throw new Error("Missing return statement in function");
  }

//VARDECL -> ("var" TIPO TOKEN_id ";")*
  static final public DeclaraVar UMAVAR() throws ParseException {
 Token id = null; Tipo tipo = null;
    jj_consume_token(VAR);
    tipo = TIPO();
    id = jj_consume_token(ID);
    jj_consume_token(PEV);
                                      {if (true) return new DeclaraVar(tipo, new Var(id.image));}
    throw new Error("Missing return statement in function");
  }

  static final public void VARDECL(ArrayList variaveis) throws ParseException {
 DeclaraVar v = null;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VAR:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      v = UMAVAR();
                 variaveis.add(v);
    }
  }

//TIPO -> "int" | "bool"
  static final public Tipo TIPO() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEIRO:
      jj_consume_token(INTEIRO);
            {if (true) return new Tipo("int");}
      break;
    case BOOLEANO:
      jj_consume_token(BOOLEANO);
                                                  {if (true) return new Tipo("bool");}
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

//SEQCOMANDOS -> (COMANDO)*
  static final public void SEQCOMANDOS(ArrayList comandos) throws ParseException {
 Comando c = null;
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONDICAO:
      case LOOP:
      case FACA:
      case RETORNA:
      case IMPRIME:
      case ID:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      c = COMANDO();
                  comandos.add(c);
    }
  }

//COMANDO -> TOKEN_id TOKEN_id’
//| TOKEN_id’ -> “:=” EXP “;” | “(“ LISTAEXP? “)” “;”
//| "if" "(" EXP ")" "{" SEQCOMANDOS "}" ";"
//| "while" "(" EXP ")" "do" "{" SEQCOMANDOS "}" ";"
//| "do" "{" SEQCOMANDOS "}" "while" "(" EXP ")" ";"
//| "return" EXP ";"
//| "print" "(" EXP ")" ";"
  static final public Comando COMANDO() throws ParseException {
 Token id = null; Exp exp = null; ArrayList arrayC = new ArrayList(); Comando c = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      id = jj_consume_token(ID);
      c = IDLinha(id);
                             {if (true) return c;}
      break;
    case CONDICAO:
      jj_consume_token(CONDICAO);
      jj_consume_token(APARENTESES);
      exp = EXP();
      jj_consume_token(FPARENTESES);
      jj_consume_token(ACHAVES);
      SEQCOMANDOS(arrayC);
      jj_consume_token(FCHAVES);
      jj_consume_token(PEV);
                                                                                                     {if (true) return new condicional(exp, arrayC);}
      break;
    case LOOP:
      jj_consume_token(LOOP);
      jj_consume_token(APARENTESES);
      exp = EXP();
      jj_consume_token(FPARENTESES);
      jj_consume_token(FACA);
      jj_consume_token(ACHAVES);
      SEQCOMANDOS(arrayC);
      jj_consume_token(FCHAVES);
      jj_consume_token(PEV);
                                                                                                        {if (true) return new loopWhile(exp, arrayC);}
      break;
    case FACA:
      jj_consume_token(FACA);
      jj_consume_token(ACHAVES);
      SEQCOMANDOS(arrayC);
      jj_consume_token(FCHAVES);
      jj_consume_token(LOOP);
      jj_consume_token(APARENTESES);
      exp = EXP();
      jj_consume_token(FPARENTESES);
      jj_consume_token(PEV);
                                                                                                        {if (true) return new loopDoWhile(arrayC, exp);}
      break;
    case RETORNA:
      jj_consume_token(RETORNA);
      exp = EXP();
      jj_consume_token(PEV);
                                {if (true) return new retorno(exp);}
      break;
    case IMPRIME:
      jj_consume_token(IMPRIME);
      jj_consume_token(APARENTESES);
      exp = EXP();
      jj_consume_token(FPARENTESES);
      jj_consume_token(PEV);
                                                            {if (true) return new print(exp);}
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Comando IDLinha(Token id) throws ParseException {
 Exp exp = null; ArrayList listaexpressoes = new ArrayList();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ATRIBUICAO:
      jj_consume_token(ATRIBUICAO);
      exp = EXP();
      jj_consume_token(PEV);
                                 {if (true) return new Atrib(new Var(id.image), exp);}
      break;
    case APARENTESES:
      jj_consume_token(APARENTESES);
      LISTAEXP(listaexpressoes);
      jj_consume_token(FPARENTESES);
      jj_consume_token(PEV);
                                                                {if (true) return new chamadaDeFuncao(new Var(id.image), listaexpressoes);}
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

//EXP "(" EXP OP EXP ")" | FATOR
  static final public Exp EXP() throws ParseException {
 Exp expA=null; Exp expB=null; Op operador=null; Token fator=null; ArrayList exps = new ArrayList(); Exp result = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case APARENTESES:
      jj_consume_token(APARENTESES);
      expA = EXP();
      operador = OP();
      expB = EXP();
      jj_consume_token(FPARENTESES);
                                                                           {if (true) return new operacao(expA, expB, operador);}
      break;
    case ID:
      fator = jj_consume_token(ID);
                  result = new Var(fator.image);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case APARENTESES:
        jj_consume_token(APARENTESES);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case APARENTESES:
        case VERDADEIRO:
        case FALSO:
        case NUM:
        case ID:
          LISTAEXP(exps);
          break;
        default:
          jj_la1[6] = jj_gen;
          ;
        }
        jj_consume_token(FPARENTESES);
                                                                                                 result =  new retornoDeFuncao(new Var(fator.image),exps);
        break;
      default:
        jj_la1[7] = jj_gen;
        ;
      }
                                                                                                                                                               {if (true) return result;}
      break;
    case NUM:
      fator = jj_consume_token(NUM);
                   {if (true) return new Num(fator.image);}
      break;
    case VERDADEIRO:
      fator = jj_consume_token(VERDADEIRO);
                          {if (true) return new Verdadeiro(fator.image);}
      break;
    case FALSO:
      fator = jj_consume_token(FALSO);
                     {if (true) return new Falso(fator.image);}
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

//OP -> operadores
  static final public Op OP() throws ParseException {
 Token op;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SOMA:
      op = jj_consume_token(SOMA);
      break;
    case SUB:
      op = jj_consume_token(SUB);
      break;
    case MULT:
      op = jj_consume_token(MULT);
      break;
    case DIV:
      op = jj_consume_token(DIV);
      break;
    case AND:
      op = jj_consume_token(AND);
      break;
    case OR:
      op = jj_consume_token(OR);
      break;
    case MENOR:
      op = jj_consume_token(MENOR);
      break;
    case MAIOR:
      op = jj_consume_token(MAIOR);
      break;
    case IGUAL:
      op = jj_consume_token(IGUAL);
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
   {if (true) return new Op(op.image);}
    throw new Error("Missing return statement in function");
  }

//LISTAEXP -> (EXP) ("," EXP)*
  static final public void LISTAEXP(ArrayList exps) throws ParseException {
 Exp exp = null;
    exp = EXP();
              exps.add(exp);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRGULA:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_3;
      }
      jj_consume_token(VIRGULA);
      exp = EXP();
                                                     exps.add(exp);
    }
  }

//FUNC -> ("function" TIPO TOKEN_id "(" LISTAARG? ")" "{" VARDECL SEQCOMANDOS "}")+
  static final public Func FUNC() throws ParseException {
 Tipo tipo = null; Token id=null; ArrayList argumentos = new ArrayList(); ArrayList variaveis = new ArrayList(); ArrayList comandos = new ArrayList();
    jj_consume_token(FUNCAO);
    tipo = TIPO();
    id = jj_consume_token(ID);
    jj_consume_token(APARENTESES);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEIRO:
    case BOOLEANO:
      LISTAARG(argumentos);
      break;
    default:
      jj_la1[11] = jj_gen;
      ;
    }
    jj_consume_token(FPARENTESES);
    jj_consume_token(ACHAVES);
    VARDECL(variaveis);
    SEQCOMANDOS(comandos);
    jj_consume_token(FCHAVES);
   {if (true) return new Func(tipo, new Var(id.image), argumentos, variaveis, comandos);}
    throw new Error("Missing return statement in function");
  }

  static final public void FUNCOES(ArrayList funcoes) throws ParseException {
 Func f = null;
    label_4:
    while (true) {
      f = FUNC();
               funcoes.add(f);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FUNCAO:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_4;
      }
    }
  }

  static final public Arg ARGUMENTO() throws ParseException {
 Tipo tipo = null; Token id = null;
    tipo = TIPO();
    id = jj_consume_token(ID);
                          {if (true) return new Arg(new Var(id.image), tipo);}
    throw new Error("Missing return statement in function");
  }

//LISTAARG -> (TIPO TOKEN_id) ("," TIPO TOKEN_id)*
  static final public void LISTAARG(ArrayList argumentos) throws ParseException {
 Arg a = null;
    a = ARGUMENTO();
                    argumentos.add(a);
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRGULA:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_5;
      }
      jj_consume_token(VIRGULA);
      a = ARGUMENTO();
                                                                     argumentos.add(a);
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public LugosiTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[14];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x400,0x1800,0x3e0000,0x3e0000,0x8100,0xc00100,0x100,0xc00100,0xff000000,0x0,0x1800,0x0,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x4,0x0,0x0,0x10,0x10,0x0,0x18,0x0,0x18,0x1,0x2,0x0,0x4,0x2,};
   }

  /** Constructor with InputStream. */
  public Lugosi(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Lugosi(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new LugosiTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Lugosi(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new LugosiTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Lugosi(LugosiTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(LugosiTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[37];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 14; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 37; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
