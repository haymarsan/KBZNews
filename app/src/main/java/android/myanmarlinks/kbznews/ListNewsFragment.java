package android.myanmarlinks.kbznews;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import java.util.ArrayList;
public class ListNewsFragment extends Fragment {

    private String[] newsTitle;
    //private String[] newsDetails={"aaaaaaaaaa","bbbbbbbbbbbb","ccccccccccccc","ddddddddddd","eeeeeeeeeee","ffffffffffffffff"};
    private String [] newsDetails;
    private int[] newsImage={R.drawable.kbz_img1,R.drawable.kbz_img2,R.drawable.agd_img1,R.drawable.agd_img2,R.drawable.aya_img1,R.drawable.aya_img2};

    private ArrayList<News> newsList;
    RecyclerView newsRecyclerView;
    private NewsAdapter newsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Resources res=getContext().getResources();
        newsTitle=res.getStringArray(R.array.title);

        newsDetails=res.getStringArray(R.array.details);

        //
        //newsImage=res.getIntArray(R.array.image);

        Log.e("Title Size >>",newsTitle.length+" ");
        newsList=new ArrayList<>();
        for (int i=0; i<newsTitle.length;i++){
            News news=new News();
            news.setNewsID(String.valueOf(i+1));
            news.setNewsTitle(newsTitle[i]);
            news.setNewsDetails(newsDetails[i]);
            news.setNewsImage(newsImage[i]);
            newsList.add(news);
        }
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_list_news,container,false);
        newsRecyclerView=view.findViewById(R.id.news_recycler_view);

        //newsRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(getResources()));
        // use default DividerItemDecoration Class
        newsRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private void updateUI(){
        newsAdapter=new NewsAdapter(newsList);
        newsRecyclerView.setAdapter(newsAdapter);
    }

    private class NewsHolder extends RecyclerView.ViewHolder {

        private News mNews;
        public ImageView imgNews;
        public TextView tvTitle;
        public TextView tvDetail;

        public NewsHolder(View itemView) {
            super(itemView);
            imgNews=itemView.findViewById(R.id.imgNews);
            tvTitle=itemView.findViewById(R.id.tvTitle);
            tvDetail=itemView.findViewById(R.id.tvDetails);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Gson gson = new Gson();
                    String newsJson = gson.toJson(mNews);


                    Intent intent=new Intent(getActivity(),NewsDetailsActivity.class);
                    intent.putExtra("News", newsJson);
                    startActivity(intent);
                }
            });
        }

        public void bindData(News n){
            mNews=n;
            imgNews.setImageResource(n.getNewsImage());
            tvTitle.setText(n.getNewsTitle());
            tvDetail.setText(n.getNewsDetails());
        }
    }

    private class NewsAdapter extends RecyclerView.Adapter<NewsHolder> {
        private ArrayList<News> mNews;

        public NewsAdapter(ArrayList<News> mNews) {
            this.mNews = mNews;
        }

        @NonNull
        @Override
        public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
            View view=layoutInflater.inflate(R.layout.content_news_list,parent,false);

            return new NewsHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
            News n=mNews.get(position);
            holder.bindData(n);
        }

        @Override
        public int getItemCount() {
            return mNews.size();
        }
    }
}