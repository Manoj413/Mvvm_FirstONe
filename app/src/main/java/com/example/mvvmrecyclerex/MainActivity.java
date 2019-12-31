package com.example.mvvmrecyclerex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvmrecyclerex.Adapter.MovieAdapter;
import com.example.mvvmrecyclerex.DetailFragment.DetailFragment;
import com.example.mvvmrecyclerex.Interface.AdapaterClickInterface;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapaterClickInterface {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager ;
    private MyListViewModel myListViewModel;
    private MovieAdapter movieAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        myListViewModel = ViewModelProviders.of(this).get(MyListViewModel.class);

        myListViewModel.getMutableLiveData().observe(this, new Observer<ArrayList<MyListViewModel>>() {
            @Override
            public void onChanged(ArrayList<MyListViewModel> myListViewModels) {
                movieAdapter=new MovieAdapter(myListViewModels,MainActivity.this);
                layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(movieAdapter);
            }
        });
    }

    @Override
    public void onClick(ArrayList<MyListViewModel> arrayList) {
        Toast.makeText(getApplicationContext(),"ONCLICKED",Toast.LENGTH_LONG).show();

        DetailFragment detailFragment = new DetailFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data",arrayList);
        detailFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,detailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
