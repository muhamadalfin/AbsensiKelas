package com.aplikasi.absenkaryawan.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aplikasi.absenkaryawan.R;
import com.aplikasi.absenkaryawan.databinding.FragmentHasilBinding;
import com.aplikasi.absenkaryawan.models.Waktu;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Hasil extends Fragment {

    public static final String MHS_REQUEST_KEY = "mahasiswa";
    public static final String DS_REQUEST_KEY = "dosen";
    public static final String JUMLAH_KEY = "jumlah";

    private List<Waktu> mahasiswaWaktuList;
    private List<Waktu> dosenWaktuList;

    public Hasil() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mahasiswaWaktuList = new ArrayList<>();
        this.dosenWaktuList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentHasilBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_hasil, container, false);
        binding.setFragment(this);
        binding.setMahasiswaWaktuList(mahasiswaWaktuList);
        binding.setDosenWaktuList(dosenWaktuList);
        getParentFragmentManager().setFragmentResultListener(MHS_REQUEST_KEY, this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                Waktu waktu = result.getParcelable(JUMLAH_KEY);
                mahasiswaWaktuList.add(waktu);
            }
        });

        getParentFragmentManager().setFragmentResultListener(DS_REQUEST_KEY, this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                Waktu waktu = result.getParcelable(JUMLAH_KEY);
                dosenWaktuList.add(waktu);
            }
        });

        return binding.getRoot();
    }

    public String mahasiswa(){
        StringBuilder builder = new StringBuilder();
        for (Waktu waktu : mahasiswaWaktuList){
            builder.append("nama :")
                    .append(waktu.getName())
                    .append("\r")
                    .append("Hari")
                    .append(waktu.getHari())
                    .append("\r")
                    .append("Tanggal")
                    .append(waktu.getTgl())
                    .append("\n");
        }
        return builder.toString();
    }

    public String dosen(){
        StringBuilder builder = new StringBuilder();
        for (Waktu waktu : dosenWaktuList){
            builder.append("nama :")
                    .append(waktu.getName())
                    .append("\r")
                    .append("Hari")
                    .append(waktu.getHari())
                    .append("\r")
                    .append("Tanggal")
                    .append(waktu.getTgl())
                    .append("\n");
        }
        return builder.toString();
    }

    public void onAddHomeClick(View view) {
        HasilDirections.waktuAction action = HasilDirections.waktuAction(MHS_REQUEST_KEY);
        Navigation.findNavController(view).navigate(action);
    }

    public void onAddAwayClick(View view) {
        HasilDirections.GoalScorerAction action = ScoreFragmentDirections.goalScorerAction(AWAY_REQUEST_KEY);
        Navigation.findNavController(view).navigate(action);
    }
}