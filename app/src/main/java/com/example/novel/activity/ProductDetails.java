package com.example.novel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.novel.R;
import com.example.novel.tabs.FollwFragment;


public class ProductDetails extends AppCompatActivity {


    ImageView img,back2;
    TextView proName,proPrice,proDesc;
    String name,price,desc;
    int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Intent intent =getIntent();
        name=intent.getStringExtra("name");
        image=intent.getIntExtra("image",R.drawable.readinglab);
        price=intent.getStringExtra("price");
        desc=intent.getStringExtra("desc");

        proName=findViewById(R.id.productName);
        proDesc=findViewById(R.id.proDesc);
        proPrice=findViewById(R.id.proPrice);
        img=findViewById(R.id.big_image);

        back2=findViewById(R.id.back2);

        proName.setText(name);
        proPrice.setText(price);
        proDesc.setText(desc);
        img.setImageResource(image);

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductDetails.this, FollwFragment.class);
                intent.putExtra("id",1);
                startActivity(intent);
                finish();
            }
        });

    }
}