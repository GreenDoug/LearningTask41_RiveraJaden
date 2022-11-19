package com.demo.learningtask41_riverajaden;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText v1, v2, v3;
    String strV1, strV2, strV3, strA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCompute = findViewById(R.id.compute);

        btnCompute.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Calculating", Toast.LENGTH_SHORT).show();
        ComputeResult();
    }

    public void ComputeResult(){
        v1 = findViewById(R.id.value1);
        v2 = findViewById(R.id.value2);
        v3 = findViewById(R.id.value3);
        if(v1.getText().toString().isEmpty() || v2.getText().toString().isEmpty() || v3.getText().toString().isEmpty()){
            strV1 = "0";
            strV2 = "0";
            strV3 = "0";
        }else{
            strV1 = v1.getText().toString();
            strV2 = v2.getText().toString();
            strV3 = v3.getText().toString();
        }
        double raw1 = Double.parseDouble(strV1);
        double raw2 = Double.parseDouble(strV2);
        double raw3 = Double.parseDouble(strV3);

        double answer = raw1 + raw2 - raw3;

        strA = "The Answer is: " + (int)  answer;

        Bundle args = new Bundle();
        args.putString("answer", strA);

        DialogFragment dialogFragmentImp = new DialogFragment();
        dialogFragmentImp.setArguments(args);
        dialogFragmentImp.show(getSupportFragmentManager(),"Display Answer");
        clearEditText();
    }
    public void clearEditText(){
        v1.getText().clear();
        v2.getText().clear();
        v3.getText().clear();
        v1.requestFocus();
    }
}