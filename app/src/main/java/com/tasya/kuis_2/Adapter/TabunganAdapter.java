package com.tasya.kuis_2.Adapter;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.tasya.kuis_2.Activity.TransferActivity;
import com.tasya.kuis_2.Model.Tabungan;
import com.tasya.kuis_2.R;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Tasya on 5/7/2018.
 */

public class TabunganAdapter extends RecyclerView.Adapter<TabunganAdapter.ViewHolder> {
    private List<Tabungan> mData;
    private LayoutInflater mInflater;
    private int position;

    public TabunganAdapter(Context context, List<Tabungan> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public TabunganAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_tabungan, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the textview in each row
    @Override
    public void onBindViewHolder(@NonNull final TabunganAdapter.ViewHolder holder, final int position) {
        final Tabungan tab = mData.get(position);
        holder.user_id = tab.getUser_id();
        holder.nama_user.setText(tab.getNama_user());
        holder.koin.setText((tab.getKoin()+""));
        holder.matkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mInflater.getContext(), "Detail kode "+holder.kode_mk, Toast.LENGTH_SHORT).show();
            }
        });
        holder.matkul.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popup = new PopupMenu(mInflater.getContext(), view);
                popup.getMenuInflater()
                        .inflate(R.menu.matkul_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.mn_trans :
                                Intent in = new Intent(mInflater.getContext(), TransferActivity.class);
                                mInflater.getContext().startActivity(in);
                                Toast.makeText(mInflater.getContext(), "edit "+holder.user_id, Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.mn_delete :
                                Toast.makeText(mInflater.getContext(), "hapus "+holder.user_id, Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return true;
                        }
                    }

                });
                popup.show(); //showing popup menu
                return true;
            }
        });
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder{
        public int kode_mk;
        public TextView nama_mk, dosen, sks;
        public ConstraintLayout matkul;

        public ViewHolder(View itemView) {
            super(itemView);
            matkul = itemView.findViewById(R.id.list_tbgn);
            nama_mk = itemView.findViewById(R.id.tx_li_idusr);
            dosen = itemView.findViewById(R.id.tx_li_user);
            sks = itemView.findViewById(R.id.tx_li_jml);
        }

    }

    // convenience method for getting data at click position
    public Tabungan getItem(int id) {
        return mData.get(id);
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void filterList(ArrayList<Tabungan> filterdNames) {
        this.mData = filterdNames;
        notifyDataSetChanged();
    }
}
