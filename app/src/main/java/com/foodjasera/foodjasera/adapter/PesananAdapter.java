package com.foodjasera.foodjasera.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.foodjasera.foodjasera.R;
import com.foodjasera.foodjasera.model.MenuKedai;
import com.foodjasera.foodjasera.utils.CurrencyUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PesananAdapter extends RecyclerView.Adapter<PesananAdapter.MenuViewHolder> {

    private List<MenuKedai> listMenu;
    private Context context;

    private static int currentPosition = 0;

    public PesananAdapter(Context context, List<MenuKedai> listMenu) {
        this.listMenu = listMenu;
        this.context = context;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_pesanan, parent, false);
        return new MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MenuViewHolder holder, final int position) {
        final MenuKedai menu = listMenu.get(position);

        holder.txtNamaMenu.setText(menu.getNamaMenu());
        holder.txtHargaMenu.setText(CurrencyUtils.currencyFormatter(Long.parseLong(menu.getHargaMenu())));
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

        public MenuViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}