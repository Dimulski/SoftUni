package Problem2BookShop.models;

public class Book {
    private String title;
    private String author;
    private Double price;

    public Book(String author, String title, Double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    private String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        if (title == null || title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    private String getAuthor() {
        return this.author;
    }

    private void setAuthor(String author) {
        if (author == null || !this.isAuthorNameValid(author)) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    protected Double getPrice() {
        return this.price;
    }

    private void setPrice(Double price) {
        if (price < 1) { // this is not how "If the price is zero or it is negative" should look like
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    private boolean isAuthorNameValid(String author) {
        String[] authorNames = author.split("\\s+");
        if (authorNames.length > 1 && Character.isDigit(authorNames[1].charAt(0))){
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();
    }
}
