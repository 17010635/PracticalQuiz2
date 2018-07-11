package sg.edu.rp.c346.practicalquiz;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName, etAge;
    Spinner spnClass;
    Button btnSave;

    String name;
    int age;
    String strClass;
    int classPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editTextName);
        etAge = findViewById(R.id.editTextAge);
        spnClass = findViewById(R.id.spinner);
        btnSave = findViewById(R.id.buttonSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etName.getText().toString();
                age = Integer.parseInt(etAge.getText().toString());



                Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        classPos = spnClass.getSelectedItemPosition();

        // Step 1a: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        // Step 1b: Obtain an instance of the SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        // Step 1c: Add the key-value pair
        prefEdit.putString("name", name);
        prefEdit.putInt("age", age);
        prefEdit.putInt("classes",classPos );
        // Step 1d: Call ocmmit() method to save the changes into the SharedPreferences
        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        // Step 2a: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        // Step 2b: Retrieve the saved data with the key "greeting" from the SharedPreferences object
        String name = prefs.getString("name", "");
        int age = prefs.getInt("age", 0);

         int intClass = prefs.getInt("classes", 0);
        etName.setText(name);
        etAge.setText(age +"");
      spnClass.setSelection(intClass);
        
        //abcd
    }
}
