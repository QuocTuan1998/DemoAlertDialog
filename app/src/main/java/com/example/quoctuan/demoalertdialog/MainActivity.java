package com.example.quoctuan.demoalertdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DialogTitle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editUser,editPass;

    CheckBox chkSave;

    Button btnLogin,btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addControls() {

        editUser = (EditText) findViewById(R.id.editUser);
        editPass = (EditText) findViewById(R.id.editPass);

        chkSave = (CheckBox) findViewById(R.id.chkSave);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnExit = (Button) findViewById(R.id.btnExit);

    }

    private void addEvents() {

        chkSave.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(
                            MainActivity.this,
                            "Chào mừng bạn đăng nhập hệ thống, bạn đã lưu thông tin",
                            Toast.LENGTH_SHORT).show();


                }else {

                    Toast.makeText(
                            MainActivity.this,
                            "Chào mừng bạn không đăng nhập hệ thống, bạn không lưu thông tin",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Bạn có chắc chắn muốn thoát ?");
                builder.setCancelable(true);
                builder.setPositiveButton("Thoát", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }


}
