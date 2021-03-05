package dev.mudithasanka.infoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText h_no, name_input, nic_input, sub_no_input;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button add_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        h_no = findViewById(R.id.h_no);
        name_input = findViewById(R.id.name_input);
        nic_input = findViewById(R.id.nic_input);
        radioGroup = findViewById(R.id.radioGroup);
        sub_no_input = findViewById(R.id.sub_no_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);

                if (radioId != -1) {
                    MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                    myDB.addPerson(h_no.getText().toString().trim(),
                            name_input.getText().toString().trim(),
                            nic_input.getText().toString().trim(),
                            radioButton.getText().toString().trim(),
                            Integer.valueOf(sub_no_input.getText().toString()));
                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "Select Gender";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

    }
    public void checkbutton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        Toast.makeText(this, "Selected Gender : "+radioButton.getText(), Toast.LENGTH_SHORT).show();
    }
}