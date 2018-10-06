package com.foodjasera.foodjasera.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.foodjasera.foodjasera.R;
import com.foodjasera.foodjasera.model.Pujasera;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.maps.android.SphericalUtil;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PujaseraAdapter extends RecyclerView.Adapter<PujaseraAdapter.ListMenuViewHolder>  {

    //deklarasi global variabel
    private Context context;
    private final List<Pujasera> listPujasera;

    public PujaseraAdapter(Context context, List<Pujasera> listPujasera) {
        this.context = context;
        this.listPujasera = listPujasera;
    }

    @Override
    public ListMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_pujasera, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mItemView.setLayoutParams(layoutParams);

        return new ListMenuViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(ListMenuViewHolder holder, int position) {
        final Pujasera mCurrent = listPujasera.get(position);
        holder.txtNamaPujasera.setText(mCurrent.getNama());
        holder.txtAlamatPujasera.setText(mCurrent.getAlamat());

        double myLatitude = -6.836956;
        double myLongitude = 107.635213;

        LatLng myLatLng = new LatLng(myLatitude, myLongitude);
        LatLng storeLatLng = new LatLng(mCurrent.getLatitude(),mCurrent.getLongitude());

//        Location myLocation = new Location("");
//        Location storeLocation = new Location("");
//
//        myLocation.setLatitude(myLatitude);
//        myLocation.setLongitude(myLongitude);
//
//        storeLocation.setLatitude(Double.parseDouble(mCurrent));

        double distance = SphericalUtil.computeDistanceBetween(myLatLng, storeLatLng);

        holder.txtJarakPujasera.setText(String.valueOf((int) distance+" m"));
        holder.txtStatusPujasera.setText(mCurrent.getStatusBuka());
        Glide.with(context).
                load(mCurrent.getImage()).
                placeholder(R.drawable.ic_store).
                into(holder.imagePujasera);
    }

    public double calculateDistance(double initialLat, double initialLong, double finalLat, double finalLong){
        long R = 6371; // km (Earth radius)
        double dLat = Math.toRadians(finalLat/1E6 - initialLat/1E6);
        double dLon = Math.toRadians(finalLong/1E6 - initialLong/1E6);
        initialLat = Math.toRadians(initialLat);
        finalLat = Math.toRadians(finalLat);

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(initialLat) * Math.cos(finalLat);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }

    @Override
    public int getItemCount() {
        return listPujasera.size();
    }

    public class ListMenuViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/ {
        @BindView(R.id.txt_nama_pujasera)
        TextView txtNamaPujasera;
        @BindView(R.id.txt_alamat_pujasera)
        TextView txtAlamatPujasera;
        @BindView(R.id.txt_jarak_pujasera)
        TextView txtJarakPujasera;
        @BindView(R.id.txt_status_pujasera)
        TextView txtStatusPujasera;
        @BindView(R.id.image_pujasera)
        ImageView imagePujasera;

        final PujaseraAdapter mAdapter;

        public ListMenuViewHolder(View itemView, PujaseraAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.mAdapter = adapter;
        }

        @OnClick(R.id.cv_pujasera)
        public void buttonPujasera(){
            Pujasera mCurrent = listPujasera.get(getAdapterPosition());
            Toast.makeText(context, ""+mCurrent.getLatitude(), Toast.LENGTH_SHORT).show();
        }

    }

}
