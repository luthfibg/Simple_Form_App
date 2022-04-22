package com.example.simpleform;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;

    EditText ed_nik, ed_name, ed_tmp, ed_tgl, ed_alt;
    String str_nik, str_name, str_tmp, str_tgl, str_alt, str_jkm, str_pkj, str_skw;
    Spinner ed_jkm, ed_pkj, ed_skw;

    String[] genders = new String[]{"Jenis Kelamin", "Laki-laki", "Perempuan"};
    String[] jobs = new String[]{"Pekerjaan", "Pegawai Negeri Sipil", "Pegawai Swasta", "Pelajar", "Wiraswasta"};
    String[] status = new String[]{"Status Perkawinan", "Belum Kawin", "Kawin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_nik = findViewById(R.id.fd_nik);
        ed_name = findViewById(R.id.fd_fullName);
        ed_tmp = findViewById(R.id.fd_birthPlace);
        ed_tgl = findViewById(R.id.fd_birthDate);
        ed_alt = findViewById(R.id.fd_address);
        ed_jkm = findViewById(R.id.sp_jkm);
        ed_pkj = findViewById(R.id.sp_pkj);
        ed_skw = findViewById(R.id.sp_skw);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_custom, genders){
            @Override
            public boolean isEnabled(int position){
                return position != 0;
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        adapter1.setDropDownViewResource(R.layout.spinner_custom);
        ed_jkm.setAdapter(adapter1);

        ed_jkm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                if (position == 0){
                    Toast.makeText(getApplicationContext(), "Selected: " + selectedItemText, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.spinner_custom, jobs){
            @Override
            public boolean isEnabled(int position){
                return position != 0;
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        adapter2.setDropDownViewResource(R.layout.spinner_custom);
        ed_pkj.setAdapter(adapter2);

        ed_pkj.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                if (position == 0){
                    Toast.makeText(getApplicationContext(), "Selected: " + selectedItemText, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, R.layout.spinner_custom, status){
            @Override
            public boolean isEnabled(int position){
                return position != 0;
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        adapter3.setDropDownViewResource(R.layout.spinner_custom);
        ed_skw.setAdapter(adapter3);

        ed_skw.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                if (position == 0){
                    Toast.makeText(getApplicationContext(), "Selected: " + selectedItemText, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        

        Button daftar = findViewById(R.id.reg_btn);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str_nik = ed_nik.getText().toString();
                str_name = ed_name.getText().toString();
                str_tmp = ed_tmp.getText().toString();
                str_tgl = ed_tgl.getText().toString();
                str_alt = ed_alt.getText().toString();
                str_jkm = ed_jkm.getSelectedItem().toString();
                str_pkj = ed_pkj.getSelectedItem().toString();
                str_skw = ed_skw.getSelectedItem().toString();
                Intent intent = new Intent(MainActivity.this, PresentationActivity.class);


                if (str_nik.equals("")){
                    Toast.makeText(MainActivity.this, "NIK tidak boleh kosong", Toast.LENGTH_LONG).show();
                } else if (str_name.equals("")){
                    Toast.makeText(MainActivity.this, "Nama tidak boleh kosong", Toast.LENGTH_LONG).show();
                } else if (str_tmp.equals("")){
                    Toast.makeText(MainActivity.this, "Tempat lahir tidak boleh kosong", Toast.LENGTH_LONG).show();
                } else if (str_tgl.equals("")){
                    Toast.makeText(MainActivity.this, "Tanggal lahir tidak boleh kosong", Toast.LENGTH_LONG).show();
                } else if (str_alt.equals("")){
                    Toast.makeText(MainActivity.this, "alamat tidak boleh kosong", Toast.LENGTH_LONG).show();
                } else if (str_jkm.equals("")){
                    Toast.makeText(MainActivity.this, "Pilih jenis kelamin", Toast.LENGTH_LONG).show();
                } else if (str_pkj.equals("")){
                    Toast.makeText(MainActivity.this, "Pilih pekerjaan", Toast.LENGTH_LONG).show();
                } else if (str_skw.equals("")){
                    Toast.makeText(MainActivity.this, "Pilih status perkawinan", Toast.LENGTH_LONG).show();
                } else {
                    intent.putExtra("nik", str_nik);
                    intent.putExtra("name", str_name);
                    intent.putExtra("tmp", str_tmp);
                    intent.putExtra("tgl", str_tgl);
                    intent.putExtra("alt", str_alt);
                    intent.putExtra("jkm", str_jkm);
                    intent.putExtra("pkj", str_pkj);
                    intent.putExtra("skw", str_skw);
                    startActivity(intent);
                }
            }
        });

        myCalendar = Calendar.getInstance();

        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);

                TextView tanggal = findViewById(R.id.fd_birthDate);
                String myFormat = "dd-MMMM-yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.UK);
                tanggal.setText(sdf.format(myCalendar.getTime()));
            }
        };
        ed_tgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainActivity.this, date,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        setupFloatingLabelError();
    }

    public void openInfoApp(View view){
        new androidx.appcompat.app.AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_baseline_info_24)
                .setTitle("Tentang Aplikasi")
                .setMessage("Idapenas (Isi Data Kependudukan Nasional) adalah sebuah aplikasi pendataan penduduk.\n" +
                        "Aplikasi ini bersifat lokal dan single user. User hanya perlu menginput data penduduk pada halaman registrasi penduduk,\n" +
                        "lalu menekan tombol daftar, setelah itu halaman detail penduduk akan muncul dan menampilkan semua data yang sudah diinputkan.\n" +
                        "Terdapat tombol back/kembali dari halaman detail penduduk menuju ke halaman registrasi penduduk\n" +
                        "yang inputan datanya sudah kembali ter-reset (kosong).")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.cancel();
                    }
                })
                .show();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_baseline_error_24)
                .setTitle(R.string.app_name)
                .setMessage("Apakah anda ingin keluar?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
    }


    private void setupFloatingLabelError() {
        final TextInputLayout floatingUsernameLabel = findViewById(R.id.input_wrapper);
        Objects.requireNonNull(floatingUsernameLabel.getEditText()).addTextChangedListener(new TextWatcher() {
            // ...
            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() > 0 && text.length() <= 15) {
                    floatingUsernameLabel.setError(getString(R.string.e_nik_length));
                    floatingUsernameLabel.setErrorEnabled(true);
                } else {
                    floatingUsernameLabel.setErrorEnabled(false);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Code
            }
        });
    }
}