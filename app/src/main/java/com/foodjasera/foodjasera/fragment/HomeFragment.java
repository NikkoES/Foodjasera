package com.foodjasera.foodjasera.fragment;


import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.foodjasera.foodjasera.R;
import com.foodjasera.foodjasera.adapter.ImageSliderAdapter;
import com.foodjasera.foodjasera.adapter.PujaseraAdapter;
import com.foodjasera.foodjasera.model.Pujasera;
import com.foodjasera.foodjasera.utils.SharedPreferencesUtils;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.firebase.database.DatabaseReference;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment{

    private final List<Pujasera> listPujasera = new ArrayList<>();

    @BindView(R.id.rv_pujasera)
    RecyclerView mRecyclerView;
    @BindView(R.id.home_slider)
    ViewPager homeSlider;
    @BindView(R.id.ci_indicator)
    CircleIndicator mCiIndicator;

    private ImageSliderAdapter mImageSlideAdapter = null;
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
        initViewPager();

        return view;
    }

    private void initViewPager() {

        List<String> data = new ArrayList<>();

        data.add("https://cdn1-production-images-kly.akamaized.net/Dw_3MaqWNKWmZ7QVGTtQNYWiLOc=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2208479/original/026527000_1525944145-iStock-843820560.jpg");
        data.add("http://cdn2.tstatic.net/tribunnews/foto/bank/images/20140801_103826_hidangan-lebaran.jpg");
        data.add("http://www.kabarmakkah.com/wp-content/uploads/2015/06/menubukapuasa-630x380.jpg");
        data.add("https://inilahtasik.com/wp-content/uploads/2018/06/5.jpg");
        data.add("http://1.bp.blogspot.com/-T1z9XQLR0F8/VZyy8wPT0uI/AAAAAAAAA5Y/Rp-oYzC6TNE/s1600/resep-kari-ayam-spesial-campur-kentang.jpg");

        mImageSlideAdapter = new ImageSliderAdapter(data);
        homeSlider.setAdapter(mImageSlideAdapter);
        mCiIndicator.setViewPager(homeSlider);
        mImageSlideAdapter.registerDataSetObserver(mCiIndicator.getDataSetObserver());
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
                "pujaseracipadung@gmail.com",
                "Gang Kujang, Jalan Cipadung No. 43 RT. 03/08, Cibiru, Kota Bandung",
                "ini deskripsi dari puja sera cipadung",
                "2",
                "buka",
                -6.905468,
                107.589036,
                ""));
        listPujasera.add(new Pujasera(
                "2",
                "Pujasera Manisi",
                "pujaseramanisi@gmail.com",
                "Gang Kujang, Jalan Cipadung No. 43 RT. 03/08, Cibiru, Kota Bandung",
                "ini deskripsi dari pujasera manisi",
                "2",
                "buka",
                -6.901666,
                107.592169,
                ""));
        listPujasera.add(new Pujasera(
                "3",
                "Pujasera Ujung Berung",
                "pujaserauber@gmail.com",
                "Gang Kujang, Jalan Cipadung No. 43 RT. 03/08, Cibiru, Kota Bandung",
                "ini deskripsi puja sera ujung berung",
                "2",
                "tutup",
                -6.903445,
                107.597963,
                ""));
    }
}
