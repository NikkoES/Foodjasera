package com.foodjasera.foodjasera.activity.transaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.foodjasera.foodjasera.R;
import com.foodjasera.foodjasera.model.Pujasera;
import com.foodjasera.foodjasera.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailPujaseraActivity extends AppCompatActivity {

    @BindView(R.id.txt_nama_pujasera)
    TextView txtNamaPujasera;
    @BindView(R.id.txt_email_pujasera)
    TextView txtEmailPujasera;
    @BindView(R.id.txt_alamat_pujasera)
    TextView txtAlamatPujasera;
    @BindView(R.id.txt_deskripsi_pujasera)
    TextView txtDeskripsiPujasera;
    @BindView(R.id.image_pujasera)
    ImageView imagePujasera;

    Pujasera pujasera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pujasera);
        ButterKnife.bind(this);

        pujasera = (Pujasera) getIntent().getSerializableExtra("pujasera");
        txtNamaPujasera.setText(pujasera.getNama());
        txtEmailPujasera.setText("("+pujasera.getEmail()+")");
        txtAlamatPujasera.setText("Alamat : "+pujasera.getAlamat());
        txtDeskripsiPujasera.setText(pujasera.getDeskripsi());
        imagePujasera.setImageResource(R.drawable.ic_pujasera_buka);

        initToolbar();
    }

    private void initToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(pujasera.getNama());
        getSupportActionBar().setSubtitle(pujasera.getJumlahKedai()+" Kedai");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home : {
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
