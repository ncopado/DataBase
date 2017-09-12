package com.ncopado.miscontactosapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TableLayout;

import com.ncopado.miscontactosapp.adapter.ContactoAdaptador;
import com.ncopado.miscontactosapp.adapter.PageAdapter;
import com.ncopado.miscontactosapp.fragment.PerfilFragment;
import com.ncopado.miscontactosapp.fragment.RecyclierViewFragment;
import com.ncopado.miscontactosapp.pojo.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        toolbar =(Toolbar) findViewById(R.id.toolbar);

        tabLayout=(TabLayout) findViewById(R.id.tabLayout);

        viewPager=(ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if(toolbar !=null){
            setSupportActionBar(toolbar);
        }





        /* ArrayList<String> nombreContactos=new ArrayList<>();

        for (Contacto contacto:lstContacto) {

            nombreContactos.add(contacto.getNombre());
        }


        //Buscas el listview
        ListView  lst=(ListView)  findViewById(R.id.lstContactos);

        lst.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombreContactos));

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre),lstContacto.get(i).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono),lstContacto.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pcorreo),lstContacto.get(i).getEmail());
                startActivity(intent);

            }
        });
        */
    }


    private  ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments=new ArrayList<>();

        fragments.add(new RecyclierViewFragment());
        fragments.add(new PerfilFragment());


        return  fragments;
    }


    private void  setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_name);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_profile);


    }


}
