package controle.javaquiz.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DAO extends SQLiteOpenHelper {
    public DAO(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //context.deleteDatabase(DATABASE_NAME);
    }

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dbjogos.db";
    static final String NOME = "NOME";
    static final String SENHA = "SENHA";
    static final String PONTUACAO = "PONTUACAO";
    static final String IDPLAYER = "IDPLAYER";
    static final String TBPLAYER = "tb_player";
    static final String TBQUESTIONS = "tb_pergunta";

    private String tbPlayer = " create table if not exists " + TBPLAYER +
            " ( IDPLAYER integer primary key autoincrement,  " +
            " NOME varchar(100), " +
            " SENHA varchar(40), " +
            " PONTUACAO int(0)); ";

    static final String PERGUNTA = "PERGUNTA";
    static final String ALTERNATIVA1 = "ALTERNATIVA1";
    static final String ALTERNATIVA2 = "ALTERNATIVA2";
    static final String ALTERNATIVA3 = "ALTERNATIVA3";
    static final String ALTERNATIVA4 = "ALTERNATIVA4";
    static final String RESPOSTA = "RESPOSTA";

    private String tbPerguntas = "create table if not exists " + TBQUESTIONS +
            " (id integer primary key autoincrement, " +
            " PERGUNTA varchar(500), " +
            " ALTERNATIVA1 varchar(500), " +
            " ALTERNATIVA2 varchar(500), " +
            " ALTERNATIVA3 varchar(500), " +
            " ALTERNATIVA4 varchar(500), " +
            " RESPOSTA varchar(500)); ";

    private String tbPerguntasINSERT = "INSERT INTO tb_pergunta (PERGUNTA, ALTERNATIVA1, ALTERNATIVA2, ALTERNATIVA3, ALTERNATIVA4, RESPOSTA) VALUES " +
            "('Qual é o principal objetivo da linguagem de programação Java?', 'Desenvolver aplicações web', 'Criar interfaces gráficas', 'Escrever código de baixo nível', 'Criar aplicações portáteis e robustas', 'Criar aplicações portáteis e robustas'), " +
            "('Qual é a extensão de arquivo padrão para arquivos Java?', '.java', '.jav', '.class', '.jar', '.java'), " +
            "('Java é uma linguagem de programação orientada a:', 'Objetos', 'Script', 'Procedimentos', 'Componentes', 'Objetos'), " +
            "('Qual palavra-chave é usada para definir uma classe em Java?', 'class', 'define', 'new', 'create', 'class'), " +
            "('Qual é o operador de igualdade em Java?', '==', '=', '!=', '===', '=='), " +
            "('Qual é o método principal usado para iniciar um programa Java?', 'start()', 'run()', 'main()', 'execute()', 'main()'), " +
            "('Qual pacote Java contém classes para entrada e saída de dados?', 'java.io', 'java.util', 'java.lang', 'java.net', 'java.io'), " +
            "('Qual é o tipo de dados primitivo para números inteiros de 32 bits em Java?', 'int', 'byte', 'short', 'long', 'int'), " +
            "('Qual declaração é usada para criar um objeto em Java?', 'create', 'instance', 'object', 'new', 'new'), " +
            "('Qual é o resultado da expressão: 10 % 3 em Java?', '1', '2', '3', '4', '1'), " +
            "('Em Java, uma classe pode herdar de quantas outras classes?', 'Apenas uma', 'Até duas', 'Até três', 'Quantas forem necessárias', 'Apenas uma'), " +
            "('Qual é o tipo de dados para valores booleanos em Java?', 'boolean', 'bool', 'bit', 'logic', 'boolean'), " +
            "('Qual método é usado para ler dados de entrada do teclado em Java?', 'read()', 'input()', 'scan()', 'next()', 'next()'), " +
            "('Qual palavra-chave é usada para interromper um loop em Java?', 'break', 'stop', 'exit', 'end', 'break'), " +
            "('Qual é o operador de atribuição em Java?', '=', '==', ':=', '->', '='), " +
            "('Qual é a classe principal da biblioteca Java Swing para criar interfaces gráficas?', 'JFrame', 'GUI', 'Window', 'Panel', 'JFrame'), " +
            "('Qual é a função do operador \"this\" em Java?', 'Referenciar a classe atual', 'Criar uma nova instância', 'Acessar métodos estáticos', 'Realizar uma chamada recursiva', 'Referenciar a classe atual'), " +
            "('O que é um construtor em Java?', 'Uma classe especial que herda de outra classe', 'Um método que não possui retorno', 'Um objeto que é usado para acessar métodos estáticos', 'Uma instrução que cria uma nova instância de uma classe', 'Um método que não possui retorno'), " +
            "('Qual é a diferença entre herança e interface em Java?', 'Herança permite múltipla implementação, enquanto interface permite herança simples', 'Herança permite herdar atributos, enquanto interface permite herdar métodos', 'Herança permite criar objetos, enquanto interface permite criar classes', 'Herança representa uma relação \"é um\", enquanto interface representa uma relação \"tem um\"', 'Herança representa uma relação \"é um\", enquanto interface representa uma relação \"tem um\"'), " +
            "('O que é polimorfismo em Java?', 'A capacidade de uma classe herdar de várias outras classes', 'A capacidade de uma classe ter vários construtores', 'A capacidade de uma classe ter vários métodos com o mesmo nome', 'A capacidade de uma classe ter várias interfaces implementadas', 'A capacidade de uma classe ter vários métodos com o mesmo nome');";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tbPerguntas);
        db.execSQL(tbPlayer);
        db.execSQL(tbPerguntasINSERT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
