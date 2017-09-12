package com.ncopado.miscontactosapp;

import android.Manifest;
import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {


    private TextView txtNombre;
    private TextView txtTelefono;
    private TextView txtEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);





        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString(getResources().getString(R.string.pnombre));
        String telefono = bundle.getString(getResources().getString(R.string.ptelefono));
        String email = bundle.getString(getResources().getString(R.string.pcorreo));

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtTelefono = (TextView) findViewById(R.id.txtTelefono);
        txtEmail = (TextView) findViewById(R.id.txtemail);

        txtNombre.setText(nombre);
        txtTelefono.setText(telefono);
        txtEmail.setText(email);

    }

    public void llamar(View v) {
        String phone = txtTelefono.getText().toString();
      /*  if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        //startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone)));

        Intent call=new Intent(Intent.ACTION_CALL,Uri.parse("tel:" + phone));
        startActivity(call);

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" +phone));
        startActivity(intent);
        */

        startActivity( new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone)));
    }

    public void  EnviarMail(View v){
        String email = txtEmail.getText().toString();

        Intent emailinten=new Intent((Intent.ACTION_SEND));
        emailinten.setData(Uri.parse("mailto:"));
        emailinten.putExtra(Intent.EXTRA_EMAIL,email);
        emailinten.setType("message/rfc822");
        startActivity(Intent.createChooser(emailinten,  "Email"));
    }
}
