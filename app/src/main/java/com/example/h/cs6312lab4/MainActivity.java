package com.example.h.cs6312lab4;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int ALERT_DIALOG_ID=1;
    private static final int PROGRESS_DIALOG_ID=2;
    EditText editText;
    Button button;
    Button alert;
    Button progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText =(EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);

        alert=(Button)findViewById(R.id.alert);
        progress=(Button)findViewById(R.id.progress);

        alert.setOnClickListener(this);
        progress.setOnClickListener(this);
    }
    public void ButtonOnClick(View v){
        Toast.makeText(MainActivity.this, "You entered: " + editText.getText().toString(), Toast.LENGTH_SHORT).show();
    }
    @Override
    protected Dialog onCreateDialog (int id) {
        switch (id)
        {
            case ALERT_DIALOG_ID:
                AlertDialog.Builder builder =new AlertDialog.Builder(this);
                builder.setTitle("Dialog Title");
                builder.setMessage("Dialog Message");
                builder.setIcon(android.R.drawable.btn_star);
                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        return;
                    }
                });
                return builder.create();
            case PROGRESS_DIALOG_ID:
                ProgressDialog progress=new ProgressDialog(this);
                progress.setTitle("Loading...");
                progress.setMessage("Please wait...");
                progress.setCancelable(true);
                progress.show();
        }
        return null;

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.alert){
            showDialog(ALERT_DIALOG_ID);
        }else if(v.getId()==R.id.progress){
            showDialog(PROGRESS_DIALOG_ID);
        }
    }
}
