package com.ncopado.miscontactosapp.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ncopado.miscontactosapp.db.ConstructorContactos;
import com.ncopado.miscontactosapp.pojo.Contacto;
import com.ncopado.miscontactosapp.DetalleContacto;
import com.ncopado.miscontactosapp.R;

import java.util.ArrayList;

/**
 * Created by ncopado on 21/08/17.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    ArrayList<Contacto> contactos;
    Activity activity;

    public  ContactoAdaptador(ArrayList<Contacto> contactos,Activity activity){
       this.contactos=contactos;
       this.activity=activity;
   }


    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);

        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContactoViewHolder holder, int position) {

        final Contacto contacto=contactos.get(position);

        holder.imgFoto.setImageResource(contacto.getFoto());

        holder.tvNombreCV.setText(contacto.getNombre());

        holder.tvTelefonoCV.setText(contacto.getTelefono());

        holder.tvLikes.setText(String.valueOf(contacto.getLikes())+" Likes" );



        holder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,contacto.getNombre(),Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(activity,DetalleContacto.class);
                intent.putExtra("nombre",contacto.getNombre());
                intent.putExtra("telefono",contacto.getTelefono());
                intent.putExtra("correo",contacto.getEmail());
                activity.startActivity(intent);
            }
        });


        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConstructorContactos constructorContactos=new ConstructorContactos(activity);
                constructorContactos.insertaLikeContacto(contacto);


                holder.tvLikes.setText( String.valueOf( constructorContactos.obtenerLikesContacto(contacto)));


                Toast.makeText(activity,"Diste like"+contacto.getNombre(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {// Cantidad de elementos que tiene la lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private ImageButton btnLike;
        private TextView tvLikes;

        public ContactoViewHolder(View itemView) {
            super(itemView);


            imgFoto         =(ImageView) itemView.findViewById(R.id.imgFoto);

            tvNombreCV      =(TextView) itemView.findViewById(R.id.tvNombreCV);

            tvTelefonoCV    =(TextView) itemView.findViewById(R.id.tvTelCV);

            btnLike         =(ImageButton) itemView.findViewById(R.id.btnLike);

            tvLikes         =(TextView) itemView.findViewById(R.id.tvLikes);
        }
    }
}
