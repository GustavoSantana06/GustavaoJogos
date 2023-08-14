package controle.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import controle.javaquiz.db.dbController;

public class GameMain extends AppCompatActivity {
    TextView num, user, pergunta, alternativa1, alternativa2, alternativa3, alternativa4;
    int pontuacao, id = 1, idPlayer;
    String nome, resposta;
    dbController dbC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_main);
        num = findViewById(R.id.txtNumPergunta);
        user = findViewById(R.id.txtUser);
        pergunta = findViewById(R.id.txtPergunta);
        alternativa1 = findViewById(R.id.txtAltA);
        alternativa2 = findViewById(R.id.txtAltB);
        alternativa3 = findViewById(R.id.txtAltC);
        alternativa4 = findViewById(R.id.txtAltD);
        Bundle userIntent = getIntent().getExtras();
        nome = userIntent.getString("nome").toUpperCase();
        pontuacao = Integer.parseInt(userIntent.getString("pontuacao"));
        idPlayer = Integer.parseInt(userIntent.getString("id"));
        nomeEPontuacao();
        setPergunta(id);
    }

    private void setPergunta(int id){
        if(id <= 20){
            try{
                Cursor questions;
                dbC = new dbController(getBaseContext());
                questions = dbC.getQuestion(id);
                if(questions != null){
                    if(questions.moveToFirst()){
                        num.setText(questions.getString(0));
                        pergunta.setText(questions.getString(1));
                        alternativa1.setText(questions.getString(2));
                        alternativa2.setText(questions.getString(3));
                        alternativa3.setText(questions.getString(4));
                        alternativa4.setText(questions.getString(5));
                        resposta = questions.getString(6);
                    }
                } else {
                    Toast.makeText(this, "nao ha questoes", Toast.LENGTH_SHORT).show();
                }
            } catch(Exception e){
                Log.d(e.getMessage(), e.getMessage());
            }
        } else {
            Intent rank = new Intent(GameMain.this, Ranking.class);
            startActivity(rank);
            finish();
        }
    }

    private void nomeEPontuacao(){
        user.setText(nome + " - " + pontuacao);
    }

    public void handleAlternative1Click(View view){
        if(alternativa1.getText().equals(resposta)){
            Toast.makeText(this, "Resposta certa!", Toast.LENGTH_SHORT).show();
            dbC = new dbController(getBaseContext());
            pontuacao++;
            nomeEPontuacao();
            dbC.UpdatePontuacao(idPlayer, pontuacao);
        } else {
            Toast.makeText(this, "Resposta errada!", Toast.LENGTH_SHORT).show();
        }
        id++;
        setPergunta(id);
    }

    public void handleAlternative2Click(View view){
        if(alternativa2.getText().equals(resposta)){
            Toast.makeText(this, "Resposta certa!", Toast.LENGTH_SHORT).show();
            dbC = new dbController(getBaseContext());
            pontuacao++;
            nomeEPontuacao();
            dbC.UpdatePontuacao(idPlayer, pontuacao);
        } else {
            Toast.makeText(this, "Resposta errada!", Toast.LENGTH_SHORT).show();
        }
        id++;
        setPergunta(id);
    }

    public void handleAlternative3Click(View view){
        if(alternativa3.getText().equals(resposta)){
            Toast.makeText(this, "Resposta certa!", Toast.LENGTH_SHORT).show();
            dbC = new dbController(getBaseContext());
            pontuacao++;
            nomeEPontuacao();
            dbC.UpdatePontuacao(idPlayer, pontuacao);
        } else {
            Toast.makeText(this, "Resposta errada!", Toast.LENGTH_SHORT).show();
        }
        id++;
        setPergunta(id);
    }

    public void handleAlternative4Click(View view){
        if(alternativa4.getText().equals(resposta)){
            Toast.makeText(this, "Resposta certa!", Toast.LENGTH_SHORT).show();
            dbC = new dbController(getBaseContext());
            pontuacao++;
            nomeEPontuacao();
            dbC.UpdatePontuacao(idPlayer, pontuacao);
        } else {
            Toast.makeText(this, "Resposta errada!", Toast.LENGTH_SHORT).show();
        }
        id++;
        setPergunta(id);
    }
}