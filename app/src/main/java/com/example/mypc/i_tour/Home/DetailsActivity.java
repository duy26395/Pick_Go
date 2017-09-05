package com.example.mypc.i_tour.Home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mypc.i_tour.Data.Data_favorite;
import com.example.mypc.i_tour.LoginActivity;
import com.example.mypc.i_tour.R;
import com.example.mypc.i_tour.SQL.DBHelper;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.LikeView;
import com.facebook.share.widget.ShareButton;

public class DetailsActivity extends AppCompatActivity {
    TextView nameTxt, intro;
    ImageView img,imgshare;

    Button btnsave;
    private CallbackManager callbackManager;
    private LoginManager loginManager;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        callbackManager = CallbackManager.Factory.create();


        dbHelper = new DBHelper(this);

        nameTxt = (TextView) findViewById(R.id.tenct);
        img = (ImageView) findViewById(R.id.imgct);
        intro = (TextView) findViewById(R.id.motact);

        //nhan data
        Intent i = this.getIntent();
        String id = i.getBundleExtra("DATA").getString("ID_KEY");
        String name = i.getBundleExtra("DATA").getString("NAME_KEY");
        String hinh = i.getBundleExtra("DATA").getString("IMAGE_KEY");
        String gt = i.getBundleExtra("DATA").getString("INTRO_KEY");
        intro.setText(gt);
        nameTxt.setText(name);
        Glide.with(this).load(hinh).into(img);
        btnsave = (Button) findViewById(R.id.btnsave);
        btnsave.setOnClickListener(view -> {
            Data_favorite data = new Data_favorite();
            data.setName(name);
            data.setIntro(gt);
            data.setImage(hinh);
            dbHelper.addTEAM(data);
            Toast.makeText(getApplicationContext(), "SAVE", Toast.LENGTH_SHORT).show();
            Log.e("dddddddddddddddddd", String.valueOf(data));
        });
//        RatingBar r = (RatingBar)findViewById(R.id.ratingbar);
//        r.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_UP) {
////                    Toast.makeText(getBaseContext(),"ahihi",Toast.LENGTH_SHORT).show();
//                    Intent i = new Intent(DetailsActivity.this , LoginActivity.class);
//                startActivity(i);
//                }
//                return true;
//            }
//        });
        Button com = (Button)findViewById(R.id.idcommit);
        com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetailsActivity.this , LoginActivity.class);
                startActivity(i);
            }
        });
        ShareButton shareButton = (ShareButton) findViewById(R.id.idshare);
        ShareLinkContent content = new ShareLinkContent.Builder().setContentUrl(Uri.parse(hinh)).setQuote(name).build();
        shareButton.setShareContent(content);
        LikeView likeView = (LikeView)findViewById(R.id.idlike);
        likeView.setObjectIdAndType("https://www.facebook.com/danangtravelshopping/", LikeView.ObjectType.OPEN_GRAPH);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
