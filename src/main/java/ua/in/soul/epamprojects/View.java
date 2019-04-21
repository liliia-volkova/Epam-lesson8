package ua.in.soul.epamprojects;

public class View {

    public static final String LIBRARY_IS_FULL = "Library is full!";
    public static final String BOOK_ADDED = "Book succesfully added";
    public static final String ENTER_COUNT_OF_BOOKS = "Enter count of books";
    public static final String LIBRARY_IS_EMPTY = "Library is empty";
    public static final String QUESTIONS = "\nВыберите нужное действие: \n1 - посмотреть все книги; \n2 - изменить цену; " +
            "\n3 - найти книги автора; \n4 - найти книги по году издания; \n5 - сортировать по авторам; \n6 - сортировать по издательству; " +
            "\n7 - сортировать по убыванию цены; \n8 - завершить работу";
    public static final String INVALID_DATA = "Invalid data please re-enter";
    public static final String ID = "Enter ID: ";
    public static final String TITLE = "Enter title: ";
    public static final String AUTHOR = "Enter author: ";
    public static final String PUBLISHING_HOUSE = "Enter Publishing House: ";
    public static final String YEAR_OF_PUBLISHING = "Enter year of publishing: ";
    public static final String NUMBER_OF_PAGES = "Enter number of pages: ";
    public static final String PRICE = "Enter price: ";
    public static final String PERCENT = "Enter percent: ";
    public static final String AUTHOR_NOT_FOUND = "Author not found";
    public static final String BOOKS_NOT_FOUND = "Books not found";
    public static final String DONE = "The work is done";
    public static final String VALIDATE_YEAR = "Incorrect year value. Enter a value between 1445 and 2019";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void resultBooks(Books books) {
        System.out.println(books);
    }
}
