package com.foodjasera.foodjasera.activity.transaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.foodjasera.foodjasera.R;
import com.foodjasera.foodjasera.activity.MainActivity;
import com.foodjasera.foodjasera.adapter.KedaiAdapter;
import com.foodjasera.foodjasera.adapter.PesananAdapter;
import com.foodjasera.foodjasera.model.Kedai;
import com.foodjasera.foodjasera.model.MenuKedai;
import com.foodjasera.foodjasera.model.Transaksi;
import com.foodjasera.foodjasera.utils.CurrencyUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InvoiceActivity extends AppCompatActivity {

    @BindView(R.id.txt_tanggal_transaksi)
    TextView txtTanggalTransaksi;
    @BindView(R.id.txt_total_harga)
    TextView txtTotalHarga;
    @BindView(R.id.txt_nama_pujasera)
    TextView txtNamaPujasera;
    @BindView(R.id.txt_alamat_pemesanan)
    TextView txtAlamatPemesanan;
    @BindView(R.id.rv_pesanan)
    RecyclerView rvPemesanan;

    Transaksi transaksi;
    PesananAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);
        ButterKnife.bind(this);

        transaksi = (Transaksi) getIntent().getSerializableExtra("transaksi");

        initToolbar();
        initIntentData();
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

    @OnClick(R.id.btn_lanjutkan)
    public void buttonLanjutkan(){
        new AlertDialog.Builder(this)
                .setTitle("Pesanan akan segera diproses")
                .setMessage("Terima kasih telah memesan di foodjasera, semoga anda puas dengan pelayanan kami :)")
                .setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(InvoiceActivity.this, MainActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                    }
                })
                .show();
    }

    private void initIntentData() {
        txtTotalHarga.setText(CurrencyUtils.currencyFormatter(Long.parseLong(transaksi.getTotalHarga())));
        txtTanggalTransaksi.setText("Tanggal Transaksi : "+transaksi.getTanggalTransaksi());
        txtNamaPujasera.setText(transaksi.getNamaPujasera());
        txtAlamatPemesanan.setText(transaksi.getAlamatTransaksi());

        mAdapter = new PesananAdapter(this, transaksi.getListPesanan());
        rvPemesanan.setAdapter(mAdapter);
        rvPemesanan.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Invoice");
        getSupportActionBar().setSubtitle("#"+transaksi.getIdTransaksi());
    }
}
