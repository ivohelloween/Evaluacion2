package com.imunoz.evaluacion1;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.imunoz.evaluacion1.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Ubicacion ubicacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ubicacion = new Ubicacion();
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ubicacion = (Ubicacion) getIntent().getSerializableExtra("ubicacion");







        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

/*
        if(ubicacion!=null){*/

        if(ubicacion.GetLatitud()==0 ) {
            LatLng Talca = new LatLng(-35.4264, -71.65542);
            ubicacion = new Ubicacion(Talca.latitude, Talca.longitude);
            mMap.addMarker(new MarkerOptions().position(Talca).title("Talca"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Talca, 14));


        }else{

            LatLng Talca = new LatLng(ubicacion.GetLatitud(), ubicacion.GetLongigut());
            mMap.addMarker(new MarkerOptions().position(Talca).title("Referencia de noticia"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Talca, 14));

        }







        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                mMap.clear();
                ubicacion = new Ubicacion(latLng.latitude, latLng.longitude);

                mMap.addMarker(new MarkerOptions().position(latLng).title("posición "));
            }
        });
    }




    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);

        dialogo.setTitle("Confirmación")
                .setMessage("¿Desea enviar la ubicación seleccionada al formulario?")
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent resultado = new Intent();
                        resultado.putExtra("ubicacion", ubicacion);
                        setResult(RESULT_OK, resultado);
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();



    }
}