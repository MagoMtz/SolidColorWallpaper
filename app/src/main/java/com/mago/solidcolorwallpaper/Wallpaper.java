package com.mago.solidcolorwallpaper;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;

import yuku.ambilwarna.AmbilWarnaDialog;


public class Wallpaper extends ActionBarActivity {
    private static final String TAG ="Wallpaper";
    private Button btnDefine;
    private Button btnSelecciona;
    private LinearLayout myLayout;
    private int color = 000000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallpaper);

        btnDefine =(Button)findViewById(R.id.btnDefine);
        btnDefine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSelecciona =(Button)findViewById(R.id.btnSelecciona);
        btnSelecciona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarColor(v);
            }
        });

        dirExists("/SolidColorWallpaper/");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wallpaper, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void seleccionarColor(View view){
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, color, new AmbilWarnaDialog.OnAmbilWarnaListener(){
            @Override
            public void onOk(AmbilWarnaDialog ambilWarnaDialog, int i) {
                myLayout =(LinearLayout)findViewById(R.id.wallpaperLayout);
                myLayout.setBackgroundColor(i);
                hacerImagen(i);
                color = i;
            }

            @Override
            public void onCancel(AmbilWarnaDialog ambilWarnaDialog) {
                Toast toast = Toast.makeText(getApplicationContext(), "Cancelado", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        dialog.show();
    }

    public void hacerImagen(int color){
        CrearImagen img = new CrearImagen();
        img.createBitmap(color);
    }

    public boolean dirExists(String path){
        boolean ret = true;
        File file = new File(Environment.getExternalStorageDirectory(), path);
        if(!file.exists()){
            if(!file.mkdirs()){
                Log.e(TAG, "Directorio no creado");
                ret = false;
            }
        }
        return ret;
    }
}
