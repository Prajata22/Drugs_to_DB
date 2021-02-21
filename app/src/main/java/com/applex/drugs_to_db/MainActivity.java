package com.applex.drugs_to_db;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(MainActivity.this);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> new PutDataIntoDB().execute());
    }

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