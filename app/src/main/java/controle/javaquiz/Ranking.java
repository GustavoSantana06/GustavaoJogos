package controle.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import controle.javaquiz.db.dbController;

public class Ranking extends AppCompatActivity {
    dbController dbC;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        lv = findViewById(R.id.listView);
        rank();
    }

    public void handleBtnClick(View view){
        startActivity(new Intent(Ranking.this, MainActivity.class));
        finish();
    }
    private void rank(){
        try{
            Cursor cursor;
            dbC = new dbController(getBaseContext());
            cursor = dbC.MakeRanking();
            ArrayList<String> linhas = new ArrayList<>();
            if(cursor != null){
                if(cursor.moveToFirst()){
                    do{
                        linhas.add(cursor.getString(1) + " - " + cursor.getString(3));
                    } while (cursor.moveToNext());
                }
            }
            ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, android.R.id.text1, linhas);
            lv.setAdapter(adapter);
        } catch(Exception e){
            Log.d(e.getMessage(), e.getMessage());
        }
    }

}