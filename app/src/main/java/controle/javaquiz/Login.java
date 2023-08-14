package controle.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import controle.javaquiz.db.dbController;

public class Login extends AppCompatActivity {
    EditText user, senha;
    Button btnLog;
    dbController dbC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.edtNomeLog);
        senha = findViewById(R.id.edtSenhaLog);
        btnLog = findViewById(R.id.btnLogin);
    }

    public void RegPage(View view){
        startActivity(new Intent(Login.this, MainActivity.class));
        finish();
    }

    public void handleLoginClick(View view){
        try{
            dbC = new dbController(getBaseContext());
            Cursor result = dbC.LoginHandler(user.getText().toString(), senha.getText().toString());
            if(result.getCount() == 0){
                Toast.makeText(this, "Usuário ou senha inexistentes ou errados", Toast.LENGTH_SHORT).show();
            } else {
                if(result.moveToFirst()){
                    if(result.getString(3).equals("0")){
                        Intent game = new Intent(Login.this, GameMain.class);
                        game.putExtra("id", result.getString(0));
                        game.putExtra("nome", result.getString(1));
                        game.putExtra("pontuacao", result.getString(3));
                        startActivity(game);
                        finish();
                    } else {
                        Intent rank = new Intent(Login.this, Ranking.class);
                        startActivity(rank);
                        Toast.makeText(this, "O teste só pode ser realizado uma vez", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        } catch(Exception e){
            Log.d(e.getMessage(), e.getMessage());
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}