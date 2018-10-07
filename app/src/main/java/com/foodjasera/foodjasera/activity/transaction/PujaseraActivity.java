package com.foodjasera.foodjasera.activity.transaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.foodjasera.foodjasera.R;
import com.foodjasera.foodjasera.adapter.HistoryAdapter;
import com.foodjasera.foodjasera.adapter.KedaiAdapter;
import com.foodjasera.foodjasera.model.Kedai;
import com.foodjasera.foodjasera.model.MenuKedai;
import com.foodjasera.foodjasera.model.Pujasera;
import com.foodjasera.foodjasera.model.Transaksi;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PujaseraActivity extends AppCompatActivity {

    private List<Kedai> listKedai = new ArrayList<>();
    private List<MenuKedai> menuKedaiSatu = new ArrayList<>();
    private List<MenuKedai> menuKedaiDua = new ArrayList<>();

    List<MenuKedai> menuKedai;

    KedaiAdapter mAdapter;

    Pujasera pujasera;

    @BindView(R.id.rv_kedai)
    RecyclerView mRecyclerView;

    private int PLACE_PICKER_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pujasera);
        ButterKnife.bind(this);

        initToolbar();
        initDummyData();
        initRecyclerView();
    }

    private void initToolbar() {
        pujasera = (Pujasera) getIntent().getSerializableExtra("pujasera");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(pujasera.getNama());
        getSupportActionBar().setSubtitle(pujasera.getStatusBuka());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_pujasera, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home : {
                finish();
                break;
            }
            case R.id.nav_detail_store : {
                Intent i = new Intent(this, DetailPujaseraActivity.class);
                i.putExtra("pujasera", pujasera);
                startActivity(i);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.btn_order)
    public void order(){
        menuKedai = mAdapter.getMenuChecked();
//        String data = "";
//        for (int i = 0; i < menuKedai.size(); i++) {
//            MenuKedai menu = menuKedai.get(i);
//            data = data + "\n" + menu.getNamaMenu();
//        }
        int total = 0;
        for(int i=0; i<menuKedai.size(); i++){
            total = total + Integer.parseInt(menuKedai.get(i).getHargaMenu());
        }
        Transaksi transaksi = new Transaksi(
                "11223344",
                "07/10/2010 - 08.16",
                "Cibiru, Bandung",
                "diproses",
                String.valueOf(menuKedai.size()),
                String.valueOf(total),
                "",
                "",
                "",
                "",
                "1",
                "Nikko Eka Saputra",
                "08988190546",
                "Cibiru, Bandung",
                pujasera.getId(),
                pujasera.getNama(),
                pujasera.getAlamat(),
                pujasera.getEmail(),
                menuKedai
        );
        Intent i = new Intent(PujaseraActivity.this, InvoiceActivity.class);
        i.putExtra("pujasera", pujasera);
        i.putExtra("transaksi", transaksi);
        startActivity(i);
//        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
//        try {
//            //menjalankan place picker
//            startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
//        }
//        catch (GooglePlayServicesRepairableException e) {
//            e.printStackTrace();
//        }
//        catch (GooglePlayServicesNotAvailableException e) {
//            e.printStackTrace();
//        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == PLACE_PICKER_REQUEST) {
//            if (resultCode == RESULT_OK) {
//                Place place = PlacePicker.getPlace( this, data);
//            }
//        }
//    }

    private void initDummyData() {
        menuKedaiSatu.add(new MenuKedai(
                "1",
                "1",
                "Indomie Goreng",
                "5000",
                "indomie goreng indofood",
                "",
                "ada"
        ));
        menuKedaiSatu.add(new MenuKedai(
                "2",
                "1",
                "Indomie Soto",
                "4000",
                "indomie soto indofoot",
                "",
                "ada"
        ));
        menuKedaiSatu.add(new MenuKedai(
                "3",
                "1",
                "Indomie Kari",
                "4000",
                "indomie kari indofood",
                "",
                "ada"
        ));
        menuKedaiDua.add(new MenuKedai(
                "1",
                "2",
                "Sarimi isi Dua Goreng",
                "5000",
                "Sarimi isi dua goreng guys",
                "",
                "ada"
        ));
        menuKedaiDua.add(new MenuKedai(
                "2",
                "2",
                "Sarimi isi Dua Soto",
                "4000",
                "Sarimi isi dua soto guys",
                "",
                "ada"
        ));

        listKedai.add(new Kedai(
                "1",
                "1",
                "Kedai Indomie",
                "ini kedai indomie yaa guys",
                "buka",
                "",
                menuKedaiSatu
        ));
        listKedai.add(new Kedai(
                "2",
                "1",
                "Kedai Sarimi",
                "ini kedai sarimi yaa guys",
                "buka",
                "",
                menuKedaiDua
        ));
    }

    private void initRecyclerView() {
        mAdapter = new KedaiAdapter(this, listKedai);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
