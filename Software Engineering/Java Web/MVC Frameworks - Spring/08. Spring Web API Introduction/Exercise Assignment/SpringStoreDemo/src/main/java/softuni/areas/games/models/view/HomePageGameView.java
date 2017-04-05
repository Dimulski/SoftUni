package softuni.areas.games.models.view;

public class HomePageGameView {

    private Long id;

    private String title;

    private double size;

    private double price;

    private String thumbnail;

    private String trailer;

    private String summary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getSummary() {
        return summary;
    }

        public void setSummary(String summary) {
        this.summary = summary.substring(0, Math.min(300, summary.length())) + "...";;
    }

    public void validate(){
        if(thumbnail == null || thumbnail.equals("")){
            this.thumbnail = String.format("https://i.ytimg.com/vi/%s/maxresdefault.jpg", this.getTrailer());
        }
    }
}
