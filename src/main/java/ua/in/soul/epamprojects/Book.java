package ua.in.soul.epamprojects;

public class Book {

    private int id;
    private String title;
    private String author;
    private String publishingHouse;
    private int yearOfPublishing;
    private int numberOfPages;
    private double price;

    public Book(int id, String title, String author, String publishingHouse,
                int yearOfPublishing, int numberOfPages, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.yearOfPublishing = yearOfPublishing;
        this.numberOfPages = numberOfPages;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nID: " + id + "\nTitle: " + title + "\nAuthor: " + author + "\nPublishing House: " + publishingHouse
                + "\nYear of publishing: " + yearOfPublishing + "\nNumber of pages: " + numberOfPages + "\nPrice: " + price;
    }

    public Book clone() {
        return new Book(id, title, author, publishingHouse, yearOfPublishing, numberOfPages, price);
    }
}
