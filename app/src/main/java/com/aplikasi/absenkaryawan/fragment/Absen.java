package com.aplikasi.absenkaryawan.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.aplikasi.absenkaryawan.R;
import com.aplikasi.absenkaryawan.databinding.FragmentAbsenBinding;
import com.aplikasi.absenkaryawan.models.Waktu;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class Absen extends Fragment {

    private String requestKey;
    private Waktu waktu;

    public Absen() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.waktu = new Waktu();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentAbsenBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_absen, container, false);
        binding.setFragment(this);
        binding.setWaktu(waktu);
        requestKey = AbsenArgs.fromBundle(getArguments()).getRequestKey();
        return binding.getRoot();
    }

    public void onSaveClicked(View view) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Hasil.JUMLAH_KEY, waktu);
        getParentFragmentManager().setFragmentResult(requestKey, bundle);
        Navigation.findNavController(view).navigateUp();
    }

    public void onCancelClicked(View view) {
        Navigation.findNavController(view).navigateUp();
    }
}