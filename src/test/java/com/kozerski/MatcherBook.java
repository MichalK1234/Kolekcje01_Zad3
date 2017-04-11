package com.kozerski;


import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michal on 11.04.2017.
 */
public class MatcherBook extends TypeSafeMatcher<Book> {


    private List<String> errors;

    private String authorRegex;
    private String typeRegex;
    private int pagesMin;

    public MatcherBook(String authorRegex, String typeRegex, int pagesMin) {

        errors = new ArrayList<>();

        this.authorRegex = authorRegex;
        this.typeRegex = typeRegex;
        this.pagesMin = pagesMin;
    }

    @Override
    protected boolean matchesSafely(Book book) {

        if (!book.getAuthor().matches(authorRegex)) {

            errors.add("author");
            return false;

        }
        if (!book.getType().matches(typeRegex)) {

            errors.add("type");
            return false;
        }
        if (book.getPages() <= pagesMin) {

            errors.add("pages");
            return false;
        }


        return true;
    }

    @Override
    public void describeTo(final Description description) {

        for (String s : errors) {

            description.appendText(s + "-ERROR");
        }

    }

    public static MatcherBook matcherBook(String authorRegex, String typeRegex, int pagesMin) {

        return new MatcherBook(authorRegex, typeRegex, pagesMin);

    }
}
