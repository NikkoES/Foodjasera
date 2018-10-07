package com.foodjasera.foodjasera.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.foodjasera.foodjasera.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    public AccountFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_account, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @OnClick({R.id.btn_edit_profile, R.id.btn_change_password, R.id.btn_keluar})
    public void actionButton(View v){
        switch (v.getId()){
            case R.id.btn_edit_profile : {
                Toast.makeText(getContext(), "Edit Profil", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_change_password : {
                Toast.makeText(getContext(), "Change Password", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_keluar : {
                Toast.makeText(getContext(), "Logout", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }

}
