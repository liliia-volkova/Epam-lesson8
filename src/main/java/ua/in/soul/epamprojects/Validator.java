package ua.in.soul.epamprojects;

import java.util.InputMismatchException;

public class Validator {
    public void validateYear(int year) {
        if (year < 1445 || year > 2019) {
            throw new InputMismatchException();
        }
    }
}
