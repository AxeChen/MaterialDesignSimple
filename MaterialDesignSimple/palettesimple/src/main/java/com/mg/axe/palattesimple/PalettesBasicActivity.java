package com.mg.axe.palattesimple;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.TextView;

public class PalettesBasicActivity extends AppCompatActivity {

    private Bitmap bitmap;

    private TextView tvDarkMutedColor;
    private TextView tvDarkVibrantColor;
    private TextView tvLightVibrantColor;
    private TextView tvLightMutedColor;
    private TextView tvVibrantColor;
    private TextView tvMutedColor;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palettebasic);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fj);
        tvDarkMutedColor = (TextView) findViewById(R.id.tvDarkMutedColor);
        tvDarkVibrantColor = (TextView) findViewById(R.id.tvDarkVibrantColor);
        tvLightVibrantColor = (TextView) findViewById(R.id.tvLightVibrantColor);
        tvLightMutedColor = (TextView) findViewById(R.id.tvLightMutedColor);
        tvVibrantColor = (TextView) findViewById(R.id.tvVibrantColor);
        tvMutedColor = (TextView) findViewById(R.id.tvMutedColor);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageBitmap(bitmap);
        getPaletteColor();
    }

    private void getPaletteColor() {
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                int darkMutedColor = palette.getDarkMutedColor(Color.BLUE);
                int darkVibrantColor = palette.getDarkVibrantColor(Color.BLUE);
                int lightVibrantColor = palette.getLightVibrantColor(Color.BLUE);
                int lightMutedColor = palette.getLightMutedColor(Color.BLUE);
                int vibrantColor = palette.getVibrantColor(Color.BLUE);
                int mutedColor = palette.getMutedColor(Color.BLUE);

                tvDarkMutedColor.setBackgroundColor(darkMutedColor);
                tvDarkVibrantColor.setBackgroundColor(darkVibrantColor);
                tvLightMutedColor.setBackgroundColor(lightMutedColor);
                tvLightVibrantColor.setBackgroundColor(lightVibrantColor);
                tvMutedColor.setBackgroundColor(mutedColor);
                tvVibrantColor.setBackgroundColor(vibrantColor);

            }
        });

    }
}
