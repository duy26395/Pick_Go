package com.example.mypc.i_tour.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mypc.i_tour.R;

public class DetailsActivity extends AppCompatActivity {
    TextView nameTxt,intro;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        nameTxt = (TextView)findViewById(R.id.tenct);
        img = (ImageView)findViewById(R.id.imgct);
        intro = (TextView)findViewById(R.id.motact);

        //nhan data
        Intent i = this.getIntent();
        String name = i.getBundleExtra("DATA").getString("NAME_KEY");
        String hinh = i.getBundleExtra("DATA").getString("IMAGE_KEY");
        String gt = i.getBundleExtra("DATA").getString("INTRO_KEY");
        intro.setText(gt);
        nameTxt.setText(name);
        Glide.with(this).load(hinh).into(img);
    }
}
