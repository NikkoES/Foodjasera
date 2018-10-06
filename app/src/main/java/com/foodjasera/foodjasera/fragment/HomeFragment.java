package com.foodjasera.foodjasera.fragment;


import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.foodjasera.foodjasera.R;
import com.foodjasera.foodjasera.adapter.PujaseraAdapter;
import com.foodjasera.foodjasera.model.Pujasera;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment{

    private final List<Pujasera> listPujasera = new ArrayList<>();
    String idUser;

    @BindView(R.id.rv_pujasera)
    RecyclerView mRecyclerView;

    private PujaseraAdapter mAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        initDummyData();
        initRecyclerView();

        return view;
    }

    private void initRecyclerView() {
        mAdapter = new PujaseraAdapter(getContext(), listPujasera);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void initDummyData() {
        listPujasera.add(new Pujasera(
                "1",
                "Pujasera Cipadung",
                "",
                "Gang Kujang, Jalan Cipadung No. 43 RT. 03/08, Cibiru, Kota Bandung",
                "",
                "",
                "buka",
                -6.905468,
                107.589036,
                ""));
        listPujasera.add(new Pujasera(
                "2",
                "Pujasera Manisi",
                "",
                "Gang Kujang, Jalan Cipadung No. 43 RT. 03/08, Cibiru, Kota Bandung",
                "",
                "",
                "buka",
                -6.901666,
                107.592169,
                ""));
        listPujasera.add(new Pujasera(
                "3",
                "Pujasera Ujung Berung",
                "",
                "Gang Kujang, Jalan Cipadung No. 43 RT. 03/08, Cibiru, Kota Bandung",
                "",
                "",
                "tutup",
                -6.903445,
                107.597963,
                ""));
        listPujasera.add(new Pujasera(
                "4",
                "Pujasera Cinunuk",
                "",
                "Gang Kujang, Jalan Cipadung No. 43 RT. 03/08, Cibiru, Kota Bandung",
                "",
                "",
                "buka",
                -6.890450,
                107.613155,
                ""));
        listPujasera.add(new Pujasera(
                "5",
                "Pujasera Cilengkrang",
                "",
                "Gang Kujang, Jalan Cipadung No. 43 RT. 03/08, Cibiru, Kota Bandung",
                "",
                "",
                "buka",
                -6.897299,
                107.614797,
                ""));
        listPujasera.add(new Pujasera(
                "6",
                "Pujasera Panyileukan",
                "",
                "Gang Kujang, Jalan Cipadung No. 43 RT. 03/08, Cibiru, Kota Bandung",
                "",
                "",
                "tutup",
                -6.903509,
                107.612168,
                ""));
        listPujasera.add(new Pujasera(
                "7",
                "Pujasera Buah Batu",
                "",
                "Gang Kujang, Jalan Cipadung No. 43 RT. 03/08, Cibiru, Kota Bandung",
                "",
                "",
                "buka",
                -6.90495,
                107.613445,
                ""));

    }
}
