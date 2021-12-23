package com.imunoz.evaluacion1;

import android.graphics.Bitmap;
import android.net.Uri;

import java.io.Serializable;

public class Foto implements Serializable {

    private SerializableBitmap bitmap;

    public Foto() {
    }

    public SerializableBitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(SerializableBitmap bitmap) {
        this.bitmap = bitmap;
    }
}
