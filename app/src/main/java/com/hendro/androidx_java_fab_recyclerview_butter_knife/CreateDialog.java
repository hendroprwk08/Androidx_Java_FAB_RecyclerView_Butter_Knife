package com.hendro.androidx_java_fab_recyclerview_butter_knife;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CreateDialog extends DialogFragment {
    @BindView(R.id.et_nama) EditText met_nama;
    @BindView(R.id.cb_teknologi) CheckBox mcb_teknologi;
    @BindView(R.id.cb_kuliner) CheckBox mcb_kuliner;
    @BindView(R.id.cb_keuangan) CheckBox mcb_keuangan;
    @BindView(R.id.cb_ekonomi) CheckBox mcb_ekonomi;
    @BindView(R.id.cb_arsitektur) CheckBox mcb_arsitektur;
    @BindView(R.id.cb_lain) CheckBox mcb_lain;
    @BindView(R.id.sp_status) Spinner msp_status;
    @BindView(R.id.rg_kelas) RadioGroup mrg_kelas;

    Unbinder unbinder;
    RecyclerView rvObject;
    ArrayList<Anggota> anggotaArrayList = new ArrayList<>();

    //definisikan recyclerview yang akan digunakan dan dara lemparan dari MainActivity ( agar bisa ditambahakan datanya )
    public CreateDialog(RecyclerView rvObject, ArrayList<Anggota> anggotaArrayList) {
        this.rvObject = rvObject;
        this.anggotaArrayList = anggotaArrayList;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
            .setView(R.layout.form_input)
            .setPositiveButton("SIMPAN", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    RadioButton mrb_kelas;

                    String nama, kelas, status;
                    boolean ekonomi, teknologi,
                            arsitektur, kuliner, keuangan, lain;

                    //pilih radio button yang ada di radio button group
                    int selectedId = mrg_kelas.getCheckedRadioButtonId();

                    //khusus ini ga pake butter knife, karena nilai yang dimasukkan dinamis berdasarkan ID yang dipilih
                    mrb_kelas = (RadioButton) getDialog().findViewById(selectedId);

                    nama = String.valueOf(met_nama.getText());
                    kelas = mrb_kelas.getText().toString();
                    teknologi = mcb_teknologi.isChecked();
                    kuliner = mcb_kuliner.isChecked();
                    ekonomi= mcb_ekonomi.isChecked();
                    keuangan = mcb_keuangan.isChecked();
                    arsitektur = mcb_arsitektur.isChecked();
                    lain = mcb_lain.isChecked();

                    status = msp_status.getSelectedItem().toString();

                    anggotaArrayList.add(
                        new Anggota(nama, kelas, status, teknologi,
                            lain, kuliner,
                            keuangan, ekonomi, arsitektur)
                    );

                    new MainActivity().viewRecyclerView(rvObject, anggotaArrayList);

                    Toast.makeText(getActivity(),
                            nama + " berhasil disimpan",
                            Toast.LENGTH_SHORT).show();
                }
            })
            .setNegativeButton("BATAL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            })
            .create();
    }

    @Override
    public void onStart() {
        super.onStart();
        unbinder = ButterKnife.bind(this, getDialog()); //bind butter knife ( caranya begini kalo di dialog fragment )
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind(); //kalo udah di bind, harus di "UNBIND / DILEPAS" better knife-nya
    }
}