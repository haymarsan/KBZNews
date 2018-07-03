package android.myanmarlinks.kbznews;

public class News {
    private String newsID;
    private String newsTitle;
    private String newsDetails;
    private int newsImage;

    public News() {
    }

    public News(String newsID, String newsTitle, String newsDetails, int newsImage) {
        this.newsID = newsID;
        this.newsTitle = newsTitle;
        this.newsDetails = newsDetails;
        this.newsImage = newsImage;
    }

    public String getNewsID() {
        return newsID;
    }

    public void setNewsID(String newsID) {
        this.newsID = newsID;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDetails() {
        return newsDetails;
    }

    public void setNewsDetails(String newsDetails) {
        this.newsDetails = newsDetails;
    }

    public int getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(int newsImage) {
        this.newsImage = newsImage;
    }


}
