package com.example.mvvmrecyclerex.DetailFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mvvmrecyclerex.MyListViewModel;
import com.example.mvvmrecyclerex.R;

import java.util.ArrayList;

public class DetailFragment extends Fragment
{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lay_detail_fragment,container,false);

        ArrayList<MyListViewModel> arrayList = (ArrayList<MyListViewModel>) getArguments().getSerializable("data");

        Toast.makeText(getContext(), arrayList.get(0).artistname,Toast.LENGTH_LONG).show();
        return view;
    }
}
