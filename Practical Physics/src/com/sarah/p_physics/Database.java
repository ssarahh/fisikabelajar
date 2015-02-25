package com.sarah.p_physics;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
	
	final static String DB_NAME = "db_kuis";
	 
    public Database(Context context) {
        super(context, DB_NAME, null, 1);
        // TODO Auto-generated constructor stub
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS tbl_soal(id INTEGER PRIMARY KEY AUTOINCREMENT, soal TEXT, pil_a TEXT, pil_b TEXT, pil_c TEXT, jwban INTEGER, img BLOB)";
        db.execSQL(sql);
 
        ContentValues values = new ContentValues();
        values.put("soal", "Pada gambar dibawah ini, termasuk arus tegangan apa?");
        values.put("pil_a", "AC");
        values.put("pil_b","DC");
        values.put("pil_c", "EC");
        values.put("jwban","0");
        values.put("img", R.drawable.ac);
        db.insert("tbl_soal", "soal", values);
 
        values.put("soal", "Pada gambar dibawah ini, termasuk arus tegangan apa?");
        values.put("pil_a", "AC");
        values.put("pil_b","DC");
        values.put("pil_c", "EC");
        values.put("jwban","1");
        values.put("img", R.drawable.dc);
        db.insert("tbl_soal", "soal", values);
         
        values.put("soal", "Gambar dibawah termasuk dari materi apa?");
        values.put("pil_a", "Kalor");
        values.put("pil_b","Medan Magnet");
        values.put("pil_c", "Teori Atom");
        values.put("jwban","2");
        values.put("img", R.drawable.bohr);
        db.insert("tbl_soal", "soal", values);
         
        values.put("soal", "Gambar dibawah termasuk dari materi apa?");
        values.put("pil_a", "Medan Listrik");
        values.put("pil_b","Medan Magnet");
        values.put("pil_c", "Arus Bolak Balik");
        values.put("jwban","1");
        values.put("img", R.drawable.magnet);
        db.insert("tbl_soal", "soal", values);
 
        values.put("soal", "Gambar dibawah termasuk dari materi apa?");
        values.put("pil_a", "Arus Bolak Balik");
        values.put("pil_b","Kalor");
        values.put("pil_c", "Medan Listrik");
        values.put("jwban","2");
        values.put("img", R.drawable.listrik);
        db.insert("tbl_soal", "soal", values);
 
    }
     
    public List<Soal> getSoal(){
        List<Soal> listSoal = new ArrayList<Soal>();
        String query = "select * from tbl_soal";
         
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
         
        if(cursor.moveToFirst()){
            do{
                Soal s = new Soal();
                s.setSoal(cursor.getString(1));
                s.setPil_a(cursor.getString(2));
                s.setPil_b(cursor.getString(3));
                s.setPil_c(cursor.getString(4));
                s.setJwban(cursor.getInt(5));
                s.setGambar(cursor.getInt(6));
                listSoal.add(s);
            }while(cursor.moveToNext());
        }
         
        return listSoal;
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbl_soal");
        onCreate(db);
 
    }
 
}

