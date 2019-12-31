package com.example.mvvmrecyclerex.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmrecyclerex.Interface.AdapaterClickInterface;
import com.example.mvvmrecyclerex.MainActivity;
import com.example.mvvmrecyclerex.R;
import com.example.mvvmrecyclerex.MyListViewModel;
import com.example.mvvmrecyclerex.databinding.MyListBinding;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private ArrayList<MyListViewModel> arrayList;
    private Context context;
    private LayoutInflater layoutInflater;
    AdapaterClickInterface adapaterClickInterface;

    public MovieAdapter(ArrayList<MyListViewModel> arrayList, Context context,AdapaterClickInterface adapaterClickInterface) {
        this.arrayList = arrayList;
        this.context = context;
        this.adapaterClickInterface=adapaterClickInterface;
    }

    public MovieAdapter(ArrayList<MyListViewModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        this.adapaterClickInterface=adapaterClickInterface;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater=LayoutInflater.from(parent.getContext());
        }
        MyListBinding myListBinding= DataBindingUtil.inflate(layoutInflater, R.layout.lay_adapter,parent,false);
        return new ViewHolder(myListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyListViewModel myListViewModel=arrayList.get(position);
        holder.bind(myListViewModel);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewHolder(@NonNull View itemView, final AdapaterClickInterface adapaterClickInterface ) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    adapaterClickInterface.onClick(arrayList);

                }
            });
        }

        private MyListBinding myListBinding;


        public ViewHolder(@NonNull MyListBinding myListBinding) {
            super(myListBinding.getRoot());
            this.myListBinding=myListBinding;

        }
        public void bind(MyListViewModel myli){
            this.myListBinding.setMylistmodel(myli);
            myListBinding.executePendingBindings();
        }
        public MyListBinding getMyListBinding(){
            return myListBinding;
        }
    }
}
