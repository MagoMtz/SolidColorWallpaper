package com.mago.solidcolorwallpaper;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import yuku.ambilwarna.AmbilWarnaDialog;


public class Wallpaper extends ActionBarActivity {
    private static final String TAG ="Wallpaper";
    private Button btnDefine;
    private Button btnSelecciona;
    private LinearLayout myLayout;

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
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, 000000, new AmbilWarnaDialog.OnAmbilWarnaListener(){
            @Override
            public void onOk(AmbilWarnaDialog ambilWarnaDialog, int i) {
                String color = "Color escogido: "+i;
                Toast toast = Toast.makeText(getApplicationContext(), color, Toast.LENGTH_LONG);
                toast.show();
                myLayout =(LinearLayout)findViewById(R.id.wallpaperLayout);
                myLayout.setBackgroundColor(i);
            }

            @Override
            public void onCancel(AmbilWarnaDialog ambilWarnaDialog) {
                Toast toast = Toast.makeText(getApplicationContext(), "Cancelado", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        dialog.show();
    }
}
