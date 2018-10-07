package com.foodjasera.foodjasera.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.foodjasera.foodjasera.R;
import com.foodjasera.foodjasera.model.Kedai;
import com.foodjasera.foodjasera.model.MenuKedai;
import com.foodjasera.foodjasera.utils.CurrencyUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private List<MenuKedai> listMenu;
    private Context context;

    private static int currentPosition = 0;

    public MenuAdapter(Context context, List<MenuKedai> listMenu) {
        this.listMenu = listMenu;
        this.context = context;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_menu, parent, false);
        return new MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MenuViewHolder holder, final int position) {
        final MenuKedai menu = listMenu.get(position);

        holder.txtNamaMenu.setText(menu.getNamaMenu());
        holder.txtHargaMenu.setText(CurrencyUtils.currencyFormatter(Long.parseLong(menu.getHargaMenu())));
        holder.checkMenu.setChecked(menu.getSelected());
        holder.checkMenu.setTag(menu);
        holder.checkMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                MenuKedai mk = (MenuKedai) cb.getTag();

                mk.setSelected(cb.isChecked());
                listMenu.get(position).setSelected(cb.isChecked());
            }
        });
    }

    public List<MenuKedai> getListMenu() {
        return listMenu;
    }

    @Override
    public int getItemCount() {
        return listMenu.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_nama_menu)
        TextView txtNamaMenu;
        @BindView(R.id.txt_harga_menu)
        TextView txtHargaMenu;
        @BindView(R.id.check_menu)
        CheckBox checkMenu;

        public MenuViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}