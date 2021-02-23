package com.applex.drugs_to_db;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.applex.drugs_to_db.SQLiteUtilities.AssetDatabaseOpenHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    Executor executor = Executors.newSingleThreadExecutor();
    private String DB_NAME;
    private AssetDatabaseOpenHelper assetDatabaseOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(MainActivity.this);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(v -> new PutDataIntoDB().execute());

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> new CopyDataOneDbToAnother().execute());

        DB_NAME = "Drugs_A.db";
        assetDatabaseOpenHelper = new AssetDatabaseOpenHelper(MainActivity.this, DB_NAME);
        assetDatabaseOpenHelper.saveDatabase();


    }

    ////copying data from sqlite db into room db
    @SuppressLint("StaticFieldLeak")
    public class CopyDataOneDbToAnother extends AsyncTask<Void, Void, Void> {

        private ProgressDialog progressDialog;
        private ZyephrDatabase database;
        private ZyephrCopyDatabase copyDatabase_A;
        private DatabaseCopyHelper databaseCopyHelper;
        private Drugs_A_Model drugsModel;

        @Override
        protected void onPreExecute() {
            database = ZyephrDatabase.getDatabase(MainActivity.this);

            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Copying your data");
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
//            copyDatabase_A = ZyephrCopyDatabase.getDatabase(MainActivity.this, "Drugs_A.db", "Drugs_A_Copy.db");
//            List<DrugsModel> list_A = copyDatabase_A.drugsDummyDAOInterface().getAllDrugs();
            databaseCopyHelper = new DatabaseCopyHelper(MainActivity.this, "Drugs_A.db", "Drugs_A_Table");
            try {
                databaseCopyHelper.createDatabase();
                ArrayList<Drugs_A_Model> list_A = databaseCopyHelper.getAllDrugs();
                databaseCopyHelper.db_delete();
                for(int i = 0; i < list_A.size(); i++) {
                    database.drugsDAOInterface().insert(list_A.get(i));
                    Log.e("BAMCHIKI", i + "");
                }
            } catch (IOException e) {
                Log.e("BAMCHIKI", e.getMessage());
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if(progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            executor.execute(() -> {
                drugsModel = database.drugsDAOInterface().getDrugs(1);
                new Handler(Looper.getMainLooper()).post(() -> {
                    Toast.makeText(MainActivity.this, drugsModel.getName(), Toast.LENGTH_SHORT).show();
                });
            });
        }
    }

    ////copying data from json into sqlite db
    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getAssets().open("Drugs_D.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            Log.e("BAMCHIKI", e.getMessage());
            return null;
        }
        return json;
    }

    @SuppressLint("StaticFieldLeak")
    public class PutDataIntoDB extends AsyncTask<Void, Void, Void> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Copying your data");
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                JSONArray jsonArray = new JSONArray(loadJSONFromAsset());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);

//                    Log.i("BAMCHIKI", obj.getString("NAME") + obj.getString("MANUFACTURER") + obj.getString("CONTENTS") +
//                            obj.getString("CIMS CLASS") + obj.getString("ATC CLASSIFICATION") + obj.getString("FORM(1)") +
//                            obj.getString("PACKING/PRICE(1)") + obj.getString("FORM(2)") + obj.getString("PACKING/PRICE(2)") +
//                            obj.getString("FORM(3)") + obj.getString("PACKING/PRICE(3)") + obj.getString("FORM(4)") +
//                            obj.getString("PACKING/PRICE(4)") + obj.getString("FORM(5)") + obj.getString("PACKING/PRICE(5)") +
//                            obj.getString("FORM(6)") + obj.getString("PACKING/PRICE(6)") + obj.getString("FORM(7)") +
//                            obj.getString("PACKING/PRICE(7)") + obj.getString("FORM(8)") + obj.getString("PACKING/PRICE(8)") +
//                            obj.getString("FORM(9)") + obj.getString("PACKING/PRICE(9)"));

                    databaseHelper.addData(obj.getString("NAME"), obj.getString("MANUFACTURER"), obj.getString("CONTENTS"),
                            obj.getString("CIMS CLASS"), obj.getString("ATC CLASSIFICATION"), obj.getString("FORM(1)"),
                            obj.getString("PACKING/PRICE(1)"), obj.getString("FORM(2)"), obj.getString("PACKING/PRICE(2)"),
                            obj.getString("FORM(3)"), obj.getString("PACKING/PRICE(3)"), obj.getString("FORM(4)"),
                            obj.getString("PACKING/PRICE(4)"), obj.getString("FORM(5)"), obj.getString("PACKING/PRICE(5)"),
                            obj.getString("FORM(6)"), obj.getString("PACKING/PRICE(6)"), obj.getString("FORM(7)"),
                            obj.getString("PACKING/PRICE(7)"), obj.getString("FORM(8)"), obj.getString("PACKING/PRICE(8)"),
                            obj.getString("FORM(9)"), obj.getString("PACKING/PRICE(9)"));
                }
            } catch (JSONException e) {
                Log.e("BAMCHIKI", e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if(progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            Toast.makeText(MainActivity.this, "Completed", Toast.LENGTH_SHORT).show();
        }
    }
}