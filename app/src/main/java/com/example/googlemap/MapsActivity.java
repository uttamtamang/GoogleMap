package com.example.googlemap;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final String TAG = MapsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.map_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.normal_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case R.id.hybrid_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;
            case R.id.satellite_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;
            case R.id.terrain_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
      //  mMap = googleMap;

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

//        List<LatitudeLongitude> latLngs = new ArrayList<>();
//        latLngs.add(new LatitudeLongitude(27.7052354, 85.3294158, "Softwarica college"));
//        latLngs.add(new LatitudeLongitude(27.70482, 85.3293997, "Gopal dai ko chatamari"));
//
//        CameraUpdate center, zoom;
//        for (int i= 0; i< latLngs.size(); i++) {
//            center = CameraUpdateFactory.newLatLng(new LatLng(latLngs.get(i).getLat(),
//                    latLngs.get(i).getLon()));
//            zoom = CameraUpdateFactory.zoomTo(16);
//            mMap.addMarker(new MarkerOptions().position(new LatLng(latLngs.get(i).getLat(),
//                    latLngs.get(i).getLon())).title(latLngs.get(i).getMarker()));
//            mMap.moveCamera(center);
//            mMap.animateCamera(zoom);
//            mMap.getUiSettings().setZoomControlsEnabled(true);
        try{
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style)
            );
            if(!success){
                Log.e(TAG, "Style parsing failed.");
            }
        }
        catch(Resources.NotFoundException e){
            Log.e(TAG, "Can't find style. Error:", e);

        }
    }


//    @Override
//    public boolean onMapReady(GoogleMap googleMap){
//        try{
//            boolean success = googleMap.setMapStyle(
//                    MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style)
//            );
//            if(!success){
//                Log.e(TAG, "Style parsing failed.");
//            }
//        }
//        catch(Resources.NotFoundException e){
//            Log.e(TAG, "Can't find style. Error:", e);
//        }
//    }

}
