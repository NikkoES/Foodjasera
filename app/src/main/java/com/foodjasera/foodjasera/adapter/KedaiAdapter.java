package com.foodjasera.foodjasera.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.foodjasera.foodjasera.R;
import com.foodjasera.foodjasera.model.Kedai;
import com.foodjasera.foodjasera.model.MenuKedai;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KedaiAdapter extends RecyclerView.Adapter<KedaiAdapter.KedaiViewHolder> {

    private List<Kedai> listKedai;
    private List<MenuKedai> listMenuChecked = new ArrayList<>();
    private Context context;

    private static int currentPosition = 0;

    public KedaiAdapter(Context context, List<Kedai> listKedai) {
        this.listKedai = listKedai;
        this.context = context;
    }

    @Override
    public KedaiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_kedai, parent, false);
        return new KedaiViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final KedaiViewHolder holder, final int position) {
        Kedai kedai = listKedai.get(position);

        //punya kedai
        Glide.with(context).
                load(kedai.getImageKedai()).
                placeholder(R.drawable.ic_pujasera_buka).
                into(holder.imageKedai);
        holder.txtNamaKedai.setText(kedai.getNamaKedai());
        holder.txtDeskripsiKedai.setText(kedai.getDeskripsi());

        //punya menu
        final MenuAdapter menuAdapter = new MenuAdapter(context, kedai.getListMenuKedai());
        holder.layoutMenu.setAdapter(menuAdapter);
        holder.layoutMenu.setLayoutManager(new LinearLayoutManager(context));
        holder.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<MenuKedai> listMenu = menuAdapter.getListMenu();

                for (int i = 0; i < listMenu.size(); i++) {
                    MenuKedai menu = listMenu.get(i);
                    if (menu.getSelected()) {
                        listMenuChecked.add(new MenuKedai(
                                menu.getIdMenu(),
                                menu.getIdKedai(),
                                menu.getNamaMenu(),
                                menu.getHargaMenu(),
                                menu.getDeskripsiMenu(),
                                menu.getImageMenu(),
                                menu.getStatusMenu()));
                    }
                }
                Toast.makeText(context, "Menu telah disave !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listKedai.size();
    }

    public List<MenuKedai> getMenuChecked() {
        return listMenuChecked;
    }

    public class KedaiViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cv_kedai)
        CardView layoutKedai;
        @BindView(R.id.rv_menu)
        RecyclerView layoutMenu;

        @BindView(R.id.image_kedai)
        ImageView imageKedai;
        @BindView(R.id.txt_nama_kedai)
        TextView txtNamaKedai;
        @BindView(R.id.txt_deskripsi_kedai)
        TextView txtDeskripsiKedai;

        @BindView(R.id.btn_save)
        ImageView btnSave;

        public KedaiViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
