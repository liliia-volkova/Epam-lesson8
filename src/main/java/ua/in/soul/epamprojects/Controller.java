package ua.in.soul.epamprojects;

import java.util.Scanner;

public class Controller {

    private static View view = new View();

    public void start() {

        Scanner scanner = new Scanner(System.in);

        int size = askIntValue(View.ENTER_COUNT_OF_BOOKS, scanner);
        Books books = new Books(size);

        if (books.isEmpty()) {
            view.printErrorMessage(View.LIBRARY_IS_EMPTY);
        }

        for (int i = 0; i < size; i++) {
            System.out.println(books.addBook(enterBook(scanner)));
        }

        boolean shouldContinue = true;
        while (shouldContinue) {
            int choice = askIntValue(View.QUESTIONS, scanner);
            shouldContinue = chooseAction(choice, books, scanner);
        }
    }

    private static int askIntValue(String question, Scanner scanner) {
        while (true) {
            try {
                System.out.println(question);
                String value = scanner.nextLine();
                return Integer.valueOf(value);
            } catch (NumberFormatException ex) {
                view.printErrorMessage(View.INVALID_DATA);
            }
        }
    }

    private static double askDoubleValue(String question, Scanner scanner) {
        while (true) {
            try {
                System.out.println(question);
                String value = scanner.nextLine();
                return Double.valueOf(value);
            } catch (NumberFormatException ex) {
                view.printErrorMessage(View.INVALID_DATA);
            }
        }
    }

    private static String askStringValue(String question, Scanner scanner) {
        while (true) {
            try {
                System.out.println(question);
                return scanner.nextLine();
            } catch (NumberFormatException ex) {
                view.printErrorMessage(View.INVALID_DATA);
            }
        }
    }

    public static Book enterBook(Scanner scanner) {
        int id = askIntValue(View.ID, scanner);
        String title = askStringValue(View.TITLE, scanner);
        String author = askStringValue(View.AUTHOR, scanner);
        String publishingHouse = askStringValue(View.PUBLISHING_HOUSE, scanner);
        int yearOfPublishing = askIntValue(View.YEAR_OF_PUBLISHING, scanner);
        int numberOfPages = askIntValue(View.NUMBER_OF_PAGES, scanner);
        double price = askDoubleValue(View.PRICE, scanner);

        return new Book(id, title, author, publishingHouse, yearOfPublishing, numberOfPages, price);
    }

    public static boolean chooseAction(int choice, Books books, Scanner scanner) {
        switch (choice) {
            case 1: {
                System.out.println(books);
                break;
            }
            case 2: {
                int percent = askIntValue(View.PERCENT, scanner);
                Books booksChangePrice = books.changePrice(percent);
                view.resultBooks(booksChangePrice);
                break;
            }
            case 3: {
                String author = askStringValue(View.AUTHOR, scanner);
                Books booksOfAuthor = books.findAuthor(author);
                if (booksOfAuthor.isEmpty()) {
                    view.printMessage(View.AUTHOR_NOT_FOUND);
                } else {
                    view.resultBooks(booksOfAuthor);
                }
                break;
            }
            case 4: {
                int yearOfPub = askIntValue(View.YEAR_OF_PUBLISHING, scanner);
                Books booksBeforeYear = books.findYearOfPublishing(yearOfPub);
                if (booksBeforeYear.isEmpty()) {
                    view.printMessage(View.BOOKS_NOT_FOUND);
                } else {
                    view.resultBooks(booksBeforeYear);
                }
                break;
            }
            case 5: {
                String sortedBooks = books.sortByAuthor();
                System.out.println(sortedBooks);
                break;
            }
            case 6: {
                String sortedBooks = books.sortByPublishingHouse();
                System.out.println(sortedBooks);
                break;
            }
            case 7: {
                String sortedBooks = books.sortByPrice();
                System.out.println(sortedBooks);
                break;
            }
            case 8: {
                view.printMessage(View.DONE);
                return false;
            }
            default: {
                view.printMessage(View.INVALID_DATA);
            }
        }
        return true;
    }
}
