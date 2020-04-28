package com.hendro.androidx_java_fab_recyclerview_butter_knife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.et_nama) EditText et_nama;
    @BindView(R.id.cb_teknologi) CheckBox cb_teknologi;
    @BindView(R.id.cb_kuliner) CheckBox cb_kuliner;
    @BindView(R.id.cb_keuangan) CheckBox cb_keuangan;
    @BindView(R.id.cb_ekonomi) CheckBox cb_ekonomi;
    @BindView(R.id.cb_arsitektur) CheckBox cb_arsitektur;
    @BindView(R.id.cb_lain) CheckBox cb_lain;
    @BindView(R.id.sp_status) Spinner sp_status;
    @BindView(R.id.rb_IK) RadioButton rb_ik;
    @BindView(R.id.rb_TI) RadioButton rb_ti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        //tangkap bundle
        Bundle bundle = null;
        bundle = this.getIntent().getExtras();

        //letakkan isi bundle
        et_nama.setText(bundle.getString("b_nama"));

        //pada radio button
        if ("b_kelas" == "IK"){
            rb_ik.setChecked(true);
        }else{
            rb_ti.setChecked(true);
        }

        //pada checkbox
        cb_teknologi.setChecked(bundle.getBoolean("b_teknologi"));
        cb_arsitektur.setChecked(bundle.getBoolean("b_arsitektur"));
        cb_ekonomi.setChecked(bundle.getBoolean("b_ekonomi"));
        cb_keuangan.setChecked(bundle.getBoolean("b_keuangan"));
        cb_kuliner.setChecked(bundle.getBoolean("b_kuliner"));
        cb_lain.setChecked(bundle.getBoolean("b_lain"));

        //set data untuk spinner harus dikonversi dulu kedalam array
        String[] arrActive = getResources().getStringArray(R.array.status_bekerja);
        int idxActive = Arrays.asList(arrActive).indexOf(bundle.getString("b_status"));//find the index
        sp_status.setSelection(idxActive); //set spinner

        getSupportActionBar().setTitle("Data Peserta"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for add back arrow in action bar
    }


}
