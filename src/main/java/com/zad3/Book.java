package com.zad3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Michal on 11.04.2017.
 */
public class Book {

    private String title;
    private String author;
    private String type;
    private int pages;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {


        if (pages <= 0) {

            throw new IllegalArgumentException();

        } else {


            this.pages = pages;

        }
    }

    public Book(String title, String author, String type, int pages) {
        this.title = title;
        this.author = author;
        this.type = type;
        setPages(pages);
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", pages=" + pages +
                '}';
    }

    public static String avgPagesInType(Map<String, List<Book>> map) {


        String typeMax = "";
        double pagesMax = 0;

        double pages;


        for (Map.Entry<String, List<Book>> e : map.entrySet()) {

            pages = e.getValue().stream().collect(Collectors.summarizingDouble(p -> p.getPages())).getAverage();

            if (pages > pagesMax) {

                pagesMax = pages;
                typeMax = e.getKey();

            }

        }


        return typeMax;
    }

    public static Map<String, List<Book>> generateMap(List<Book> b) {


        return b.stream().collect(Collectors.groupingBy(bo -> bo.getType()));

    }
}
