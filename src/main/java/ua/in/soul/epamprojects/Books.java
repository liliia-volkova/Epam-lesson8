package ua.in.soul.epamprojects;

import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;

public class Books {
    private int size;
    private Book[] books;
    private int nextBookIndex = 0;
    private View view = new View();
    private Validator validator = new Validator();

    public Books(int size) {
        this.size = size;
        this.books = new Book[size];
    }

    public String addBook(Book book) {
        if (nextBookIndex >= books.length) {
            return View.LIBRARY_IS_FULL;
        } else {
            books[nextBookIndex++] = book;
            return View.BOOK_ADDED;
        }
    }

    @Override
    public String toString() {
        if (nextBookIndex <= 0) {
            return View.LIBRARY_IS_EMPTY;
        } else {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < nextBookIndex; i++) {
                result.append(books[i].toString() + "\n");
            }
            return result.toString();
        }
    }

    public Books changePrice(int percent) {
        Books copyOfCurrent = new Books(nextBookIndex);
        for (int i = 0; i < nextBookIndex; i++) {
            copyOfCurrent.addBook(books[i].clone());
        }
        for (int i = 0; i < nextBookIndex; i++) {
            Book currentBook = copyOfCurrent.books[i];
            double currentPriсe = currentBook.getPrice();
            double newPrice = currentPriсe * (1 + (percent / 100.0));
            currentBook.setPrice(newPrice);
        }
        return copyOfCurrent;
    }

    public Books findAuthor(String author) {
        Books booksOfCurrentAuthor = new Books(size);
        for (Book element : books) {
            if (element.getAuthor() != null && element.getAuthor().equalsIgnoreCase(author)) {
                booksOfCurrentAuthor.addBook(element);
            }
        }
        return booksOfCurrentAuthor;
    }

    public Books findYearOfPublishing(int yearOfPublish) {
        try {
            int year = yearOfPublish;
            validator.validateYear(year);
            Books booksOfCurrentYears = new Books(size);
            for (Book element : books) {
                if (element.getYearOfPublishing() != 0 && element.getYearOfPublishing() > yearOfPublish) {
                    booksOfCurrentYears.addBook(element);
                    return booksOfCurrentYears;
                }
            }
        } catch (InputMismatchException e) {
            view.printErrorMessage(View.VALIDATE_YEAR);
        }
        return new Books(0);
    }

    public boolean isEmpty() {
        return nextBookIndex == 0;
    }


    private String viewBooks(Book[] array, int index) {
        StringBuilder result = new StringBuilder();
        result.append("Sorted library:\n");
        for (int i = 0; i < index; i++) {
            result.append("\n" + array[i] + "\n");
        }
        return result.toString();
    }

    public String sortByAuthor() {
        Book[] newBooks = Arrays.copyOf(books, size);
        Arrays.sort(newBooks, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.getAuthor().compareTo(book2.getAuthor());
            }
        });
        return viewBooks(newBooks, size);
    }

    public String sortByPublishingHouse() {
        Book[] newBooks = Arrays.copyOf(books, size);
        Arrays.sort(newBooks, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.getPublishingHouse().compareTo(book2.getPublishingHouse());
            }
        });
        return viewBooks(newBooks, size);
    }

    class BookPriceComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Book book1 = (Book) o1;
            Book book2 = (Book) o2;
            if (book1.getPrice() > book2.getPrice()) return -1;
            if (book1.getPrice() < book2.getPrice()) return 1;
            return 0;
        }
    }

    public String sortByPrice() {
        Book[] newBooks = Arrays.copyOf(books, size);
        Arrays.sort(newBooks, new BookPriceComparator());
        {
        }
        ;
        return viewBooks(newBooks, size);
    }
}
