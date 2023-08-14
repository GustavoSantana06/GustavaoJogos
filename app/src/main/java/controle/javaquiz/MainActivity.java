package controle.javaquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import controle.javaquiz.db.dbController;

public class MainActivity extends AppCompatActivity {
    EditText nome, senha1, senha2;
    dbController dbC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = findViewById(R.id.edtNomeLog);
        senha1 = findViewById(R.id.edtSenhaLog);
        senha2 = findViewById(R.id.edtSenha2Reg);
    }

  @Override
    public boolean onCreateOptionsMenu(Menu menu) {

      getMenuInflater().inflate(R.menu.menu_principal,menu);

      return super.onCreateOptionsMenu(menu);
  }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_quiz:

                Toast.makeText(MainActivity.this,"Você clicou quiz",Toast.LENGTH_SHORT).show();

                break;


            case R.id.nav_rank:

                Toast.makeText(MainActivity.this,"Você clicou rank",Toast.LENGTH_SHORT).show();

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void LoginPage(View view){
        startActivity(new Intent(MainActivity.this, Login.class));
        finish();
    }

    public void RegistrationChecker(View view){
        String nomeUser = nome.getText().toString();
        String senha1User = senha1.getText().toString();
        String senha2User = senha2.getText().toString();
        if(!nomeUser.isEmpty() && !senha1User.isEmpty() && !senha2User.isEmpty()){
            if(senha1User.equals(senha2User)){
                dbC = new dbController(getBaseContext());
                String Registered = dbC.RegistraJogador(nomeUser, senha1User,0);
                if(Registered.equals("Sucesso")){
                    Toast.makeText(this, "Registro realizado com sucesso", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, Login.class));
                    finish();
                } else {
                    Toast.makeText(this, Registered, Toast.LENGTH_SHORT).show();
                }
            } else{
                Toast.makeText(this, "Preencha a mesma senha em ambos campos", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Preencha corretamente todas as opções", Toast.LENGTH_SHORT).show();
        }
    }
}