package com.mago.solidcolorwallpaper;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Environment;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Mago on 20/07/2015.
 */
public class CrearImagen {
    private static final String TAG ="CrearImagen";

    public void createBitmap(int color){
        String path = Environment.getExternalStorageDirectory()+"/SolidColorWallpaper/wallpaper.png";
        Bitmap bitmap = Bitmap.createBitmap(2000,2000, Bitmap.Config.RGB_565);
        OutputStream stream = null;
        try {
            Canvas canvas = new Canvas(bitmap);
            Paint pincel = new Paint();
            pincel.setColor(color);
            canvas.drawPaint(pincel);

            stream = new FileOutputStream(path);
            bitmap.compress(Bitmap.CompressFormat.PNG, 80, stream);
            Log.d(TAG, "Color de la imagen "+color);
            Log.d(TAG, "Imagen creada");
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.e(TAG, "Imagen no creada "+e);
        }catch (IOException e){
            e.printStackTrace();
            Log.e(TAG, "Imagen no creada "+e);
        }
    }

}
