package com.foodjasera.foodjasera.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.foodjasera.foodjasera.R;
import com.foodjasera.foodjasera.adapter.HistoryAdapter;
import com.foodjasera.foodjasera.adapter.PujaseraAdapter;
import com.foodjasera.foodjasera.model.Pujasera;
import com.foodjasera.foodjasera.model.Transaksi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

    private final List<Transaksi> listTransaksi = new ArrayList<>();

    @BindView(R.id.rv_history)
    RecyclerView mRecyclerView;

    private HistoryAdapter mAdapter;


    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        ButterKnife.bind(this, view);

        initDummyData();
        initRecyclerView();

        return view;
    }

    private void initDummyData() {
        listTransaksi.add(new Transaksi(
                "11223344",
                "07/10/2010 - 08.16",
                "Jalan Kelurahan Cipadung, RT. 05/08, Cibiru, Kota Bandung",
                "sedang diproses",
                "2",
                "9000",
                "1",
                "Nikko Eka Saputra",
                "082262227436",
                "",
                "1",
                "Aditya Permana Putra",
                "08988190546",
                "Bandung, Jawa Barat",
                "1",
                "Pujasera Manisi",
                "Gang Kujang, Cipadung, Cibiru, Bandung",
                "08989177364",
                null));
        listTransaksi.add(new Transaksi(
                "11122233",
                "06/10/2010 - 22.10",
                "Jalan Kelurahan Cipadung, RT. 05/08, Cibiru, Kota Bandung",
                "dibatalkan",
                "1",
                "16000",
                "1",
                "Nikko Eka Saputra",
                "082262227436",
                "",
                "1",
                "Aditya Permana Putra",
                "08988190546",
                "Bandung, Jawa Barat",
                "1",
                "Pujasera Cipadung",
                "Gang Kujang, Cipadung, Cibiru, Bandung",
                "08989177364",
                null));
        listTransaksi.add(new Transaksi(
                "11114444",
                "06/10/2010 - 20.13",
                "Jalan Kelurahan Cipadung, RT. 05/08, Cibiru, Kota Bandung",
                "transaksi selesai",
                "4",
                "32000",
                "1",
                "Nikko Eka Saputra",
                "082262227436",
                "",
                "1",
                "Aditya Permana Putra",
                "08988190546",
                "Bandung, Jawa Barat",
                "1",
                "Pujasera Cipadung",
                "Gang Kujang, Cipadung, Cibiru, Bandung",
                "08989177364",
                null));
        listTransaksi.add(new Transaksi(
                "12345678",
                "06/10/2010 - 20.05",
                "Jalan Kelurahan Cipadung, RT. 05/08, Cibiru, Kota Bandung",
                "sedang diproses",
                "4",
                "36000",
                "1",
                "Nikko Eka Saputra",
                "082262227436",
                "",
                "1",
                "Aditya Permana Putra",
                "08988190546",
                "Bandung, Jawa Barat",
                "1",
                "Pujasera Cipadung",
                "Gang Kujang, Cipadung, Cibiru, Bandung",
                "08989177364",
                null));
    }

    private void initRecyclerView() {
        mAdapter = new HistoryAdapter(getContext(), listTransaksi);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}
