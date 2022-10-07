package com.example.zenbakiabidali;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView tv1;
    private EditText edit2;

    ActivityResultLauncher<Intent> launcherra = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.gerResultCode()==RESULT_OK)
                bueltatu("o((>ω< ))o");

        }
    });



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv1 = (TextView) findViewById(R.id.tv1);

        String zenbakia = getIntent().getStringExtra("zenbakia");
        tv1.setText(zenbakia);

        Intent intent = null;
        launcherra.launch(intent);
    }



    public void bueltatu(View view){
        String hZenbakia = getIntent().getStringExtra("zenbakia");

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("hasierakoZenbakia", hZenbakia);
        intent.putExtra("zenbakiBerria", edit2.getText().toString());

        startActivity(intent);
    }
}