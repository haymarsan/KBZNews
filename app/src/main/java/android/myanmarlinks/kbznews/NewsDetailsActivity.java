package android.myanmarlinks.kbznews;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class NewsDetailsActivity extends AppCompatActivity {

    News n;
   // private String[] newMoreDetail;
    private TextView tvNewsDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

//        Resources res=getParentActivityIntent().getResources();
//        newMoreDetail=res.getStringArray(R.array.newsMoreDetails);




            Gson gson=new Gson();
            n=gson.fromJson(getIntent().getStringExtra("News"),News.class);

            tvNewsDetails = findViewById(R.id.news_details);

            tvNewsDetails.setText(n.getNewsDetails());



       // Toast.makeText(this,"Title = "+n.getNewsTitle(),Toast.LENGTH_SHORT).show();
    }
}
