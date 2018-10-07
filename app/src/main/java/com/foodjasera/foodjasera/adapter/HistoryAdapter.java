package com.foodjasera.foodjasera.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.foodjasera.foodjasera.R;
import com.foodjasera.foodjasera.model.Pujasera;
import com.foodjasera.foodjasera.model.Transaksi;
import com.foodjasera.foodjasera.utils.CurrencyUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ListMenuViewHolder>  {

    private Context context;
    private final List<Transaksi> listTransaksi;

    public HistoryAdapter(Context context, List<Transaksi> listTransaksi) {
        this.context = context;
        this.listTransaksi = listTransaksi;
    }

    @Override
    public ListMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_history, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mItemView.setLayoutParams(layoutParams);

        return new ListMenuViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(ListMenuViewHolder holder, int position) {
        final Transaksi mCurrent = listTransaksi.get(position);
        holder.txtNamaPujasera.setText(mCurrent.getNamaPujasera());
        holder.txtIdTransaksi.setText("#"+mCurrent.getIdTransaksi());
        holder.txtTanggalTransaksi.setText(mCurrent.getTanggalTransaksi());
        holder.txtTotalHarga.setText(CurrencyUtils.currencyFormatter(Long.parseLong(mCurrent.getTotalHarga())));
        holder.txtJumlahPesanan.setText("("+mCurrent.getJumlahPesanan()+" Pesanan)");
        holder.txtStatusTransaksi.setText(mCurrent.getStatusTransaksi());
        if(mCurrent.getStatusTransaksi().equalsIgnoreCase("sedang diproses")){
            holder.txtStatusTransaksi.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
        }
        else if(mCurrent.getStatusTransaksi().equalsIgnoreCase("sedang diperjalanan")){
            holder.txtStatusTransaksi.setBackgroundColor(context.getResources().getColor(R.color.colorYellow));
        }
        else if(mCurrent.getStatusTransaksi().equalsIgnoreCase("ditolak") || mCurrent.getStatusTransaksi().equalsIgnoreCase("dibatalkan")){
            holder.txtStatusTransaksi.setBackgroundColor(context.getResources().getColor(R.color.colorRed));
        }
        else if(mCurrent.getStatusTransaksi().equalsIgnoreCase("transaksi selesai")){
            holder.txtStatusTransaksi.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        }
    }

    @Override
    public int getItemCount() {
        return listTransaksi.size();
    }

    public class ListMenuViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.txt_nama_pujasera)
        TextView txtNamaPujasera;
        @BindView(R.id.txt_id_transaksi)
        TextView txtIdTransaksi;
        @BindView(R.id.txt_tanggal_transaksi)
        TextView txtTanggalTransaksi;
        @BindView(R.id.txt_total_harga)
        TextView txtTotalHarga;
        @BindView(R.id.txt_jumlah_pesanan)
        TextView txtJumlahPesanan;
        @BindView(R.id.txt_status_transaksi)
        TextView txtStatusTransaksi;

        final HistoryAdapter mAdapter;

        public ListMenuViewHolder(View itemView, HistoryAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.mAdapter = adapter;
        }

        @OnClick(R.id.cv_transaksi)
        public void buttonTransaksi(){
            Transaksi mCurrent = listTransaksi.get(getAdapterPosition());
            Toast.makeText(context, ""+mCurrent.getIdTransaksi(), Toast.LENGTH_SHORT).show();
        }

    }

}
