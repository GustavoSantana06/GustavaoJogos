package controle.javaquiz.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class dbController {
    private DAO myDb;
    private SQLiteDatabase db;
    public dbController(Context context){
        myDb = new DAO(context);
    }

    public String RegistraJogador(String nome, String senha, int pontuacao){
        try{
            long resultado = 0;
            db = myDb.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(DAO.NOME, nome);
            values.put(DAO.SENHA, senha);
            values.put(DAO.PONTUACAO, pontuacao);
            resultado = db.insert(DAO.TBPLAYER, null, values);
            if(resultado < 0){
                return "Erro no insert";
            } else {
                return "Sucesso";
            }
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            db.close();
        }
    }

    public Cursor LoginHandler(String user, String senha){
        Cursor cursor = null;
        try{
            db = myDb.getReadableDatabase();
            cursor = db.rawQuery("select * from tb_player where NOME = '" + user + "' and SENHA = '" + senha + "'", null);
        } catch (Exception e){
            Log.d(e.getMessage(), "erro");
        }
        return cursor;
    }

    public Boolean UpdatePontuacao(int id, int pontuacao){
        try{
            long resultado = 0;
            db = myDb.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(DAO.IDPLAYER, id);
            values.put(DAO.PONTUACAO, pontuacao);
            resultado = db.update(DAO.TBPLAYER, values, "IDPLAYER=" + id, null);
            if(resultado < 0){
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        } finally {
            db.close();
        }
    }

    public Cursor MakeRanking(){
        Cursor cursor = null;
        try{
            db = myDb.getReadableDatabase();
            cursor = db.rawQuery("select * from tb_player order by pontuacao DESC", null);
        } catch (Exception e){
            Log.d(e.getMessage(), "erro");
        }
        return cursor;
    }

    public Cursor getQuestion(int id){
        Cursor cursor = null;
        try{
            db = myDb.getReadableDatabase();
            cursor = db.rawQuery("select * from " + DAO.TBQUESTIONS + " where id = " + id, null);
        } catch (Exception e){
            Log.d(e.getMessage(), "erro");
        }
        return cursor;
    }
}
