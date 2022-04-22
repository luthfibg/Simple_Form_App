package com.example.simpleform;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PresentationActivity extends AppCompatActivity {

    TextView sh_nik, sh_name, sh_tmp, sh_tgl, sh_alt, sh_jkm, sh_pkj, sh_skw;
    String nik, name, tmp, tgl, alt, jkm, pkj, skw;
    Button cancel, send;
    FloatingActionButton help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);


        sh_nik = findViewById(R.id.show_nik);
        sh_name = findViewById(R.id.show_name);
        sh_tmp = findViewById(R.id.show_tmp);
        sh_tgl = findViewById(R.id.show_tgl);
        sh_alt = findViewById(R.id.show_alt);
        sh_jkm = findViewById(R.id.show_jkm);
        sh_pkj = findViewById(R.id.show_pkj);
        sh_skw = findViewById(R.id.show_skw);

        send = findViewById(R.id.yes_cta);
        cancel = findViewById(R.id.no_cta);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Data telah dikirim", Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getApplicationContext(),"Pengiriman data dibatalkan", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });

        if(getIntent().getStringExtra("nik") != null){
            nik = getIntent().getStringExtra("nik");
            sh_nik.setText(nik);
        }
        if(getIntent().getStringExtra("name") != null){
            name = getIntent().getStringExtra("name");
            sh_name.setText(name);
        }
        if(getIntent().getStringExtra("tmp") != null){
            tmp = getIntent().getStringExtra("tmp");
            sh_tmp.setText(tmp);
        }
        if(getIntent().getStringExtra("tgl") != null){
            tgl = getIntent().getStringExtra("tgl");
            sh_tgl.setText(tgl);
        }
        if(getIntent().getStringExtra("alt") != null){
            alt = getIntent().getStringExtra("alt");
            sh_alt.setText(alt);
        }
        if(getIntent().getStringExtra("jkm") != null){
            jkm = getIntent().getStringExtra("jkm");
            sh_jkm.setText(jkm);
        }
        if(getIntent().getStringExtra("pkj") != null){
            pkj = getIntent().getStringExtra("pkj");
            sh_pkj.setText(pkj);
        }
        if(getIntent().getStringExtra("skw") != null){
            skw = getIntent().getStringExtra("skw");
            sh_skw.setText(skw);
        }

        FloatingActionButton button = findViewById(R.id.back_action);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(PresentationActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }

    public void openAlertDialogCancel(View view){
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_baseline_error_24)
                .setTitle("Konfirmasi Pembatalan")
                .setMessage("Data akan dihapus. Apakah anda ingin melanjutkan?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Intent intent = new Intent(PresentationActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .show();
    }
    public void openSnackBar(View view){
        Snackbar.make(view, "Data telah dikirim", Snackbar.LENGTH_SHORT).show();
    }
}