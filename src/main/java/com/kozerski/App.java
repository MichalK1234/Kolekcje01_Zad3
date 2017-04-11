package com.kozerski;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{

    //PROGRAM WYKONANY W RAMACH SZKOLENIA KM-PROGRAMS
    //http://km-programs.pl/


    public static void main(String[] args) {


        List<Book> b = new ArrayList<>();

        b.add(new Book("Alicja w Krainie czarow", " Lewis Carroll", "fantasy", 320));
        b.add(new Book("Alicja w Krainie czarow 2", " Lewis Carroll", "fantasy", 429));
        b.add(new Book("Eragon", "Christopher Paolini", "fantasy", 400));



        b.add(new Book("Sherlock Holmes 1", "Doyle Arthur Conan", "crime", 492));
        b.add(new Book("Sherlock Holmes 2", "Doyle Arthur Conan", "crime", 521));
        b.add(new Book("Sherlock Holmes 3", "Doyle Arthur Conan", "crime", 600));


        b.add(new Book("Winnie the Pooh", "A. A. Milne", "children's literature", 50));


        Map<String, List<Book>> map = Book.generateMap(b);

        map.entrySet().forEach(e -> {
            System.out.println(e.getKey() + " " + e.getValue());
        });

        System.out.println(Book.avgPagesInType(map));


    }
}
