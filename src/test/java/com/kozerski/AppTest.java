package com.kozerski;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    @Test
    public void test() {

        Book b = new Book("Alicja w Krainie czarow", "Lewis Carroll", "fantasy", 320);
        Book b2 = new Book("Winnie the Pooh", "A. A. Milne", "children's literature", 50);

        Assert.assertThat(b, MatcherBook.matcherBook("[A-Z][a-z]+\\s[A-Z][a-z]+", "[a-z]{4,}", 20));
        Assert.assertThat(b, MatcherBook.matcherBook("[A-Z]([a-z]+|\\.)\\s[A-Z]([a-z]+|\\.)(\\s[A-Z]([a-z]+|\\.))?", ".{4,}(\\s[a-z]+)?", 20));
        Assert.assertThat(b2, MatcherBook.matcherBook("[A-Z]([a-z]+|\\.)\\s[A-Z]([a-z]+|\\.)(\\s[A-Z]([a-z]+|\\.))?", ".{4,}(\\s[a-z]+)?", 20));


    }

    @Test
    public void test2() {

        Book b = new Book("Alicja w Krainie czarow", "Lewis Carroll", "fantasy", 320);

        Assert.assertThat("Error", b, Matchers.allOf(
                Matchers.hasProperty("title", Matchers.startsWith("A")),
                Matchers.hasProperty("author", Matchers.notNullValue()),
                Matchers.hasProperty("type", Matchers.notNullValue()),
                Matchers.hasProperty("pages", Matchers.notNullValue())
        ));

    }

    @Test
    public void test3() {

        Map<String, List<Book>> map = new HashMap<>();

        List<Book> b = new ArrayList<>();

        b.add(new Book("Sherlock Holmes 1", "Doyle Arthur Conan", "crime", 492));
        b.add(new Book("Sherlock Holmes 2", "Doyle Arthur Conan", "crime", 521));
        b.add(new Book("Sherlock Holmes 3", "Doyle Arthur Conan", "crime", 600));

        map.put("crime", b);
        map.put("fantasy", null);


        Assert.assertThat("Error", map, Matchers.hasKey("crime"));
        Assert.assertThat("Error - null value", map, Matchers.hasValue(Matchers.nullValue()));
        Assert.assertThat("Error - null value2", map.get("fantasy"), Matchers.nullValue());


    }

    @Test
    public void test4() {

        Book b = new Book("Alicja w Krainie czarow", "Lewis Carroll", "fantasy", 320);


        Assert.assertThat("Error - pages", b, Matchers.instanceOf(Book.class));
        Assert.assertThat("Error - pages", b.getPages(), Matchers.greaterThan(50));

    }

    @Test
    public void test5() {

        List<Book> b = new ArrayList<>();

        b.add(new Book("Alicja w Krainie czarow", " Lewis Carroll", "fantasy", 320));
        b.add(new Book("Alicja w Krainie czarow 2", " Lewis Carroll", "fantasy", 429));
        b.add(new Book("Eragon", "Christopher Paolini", "fantasy", 400));


        b.add(new Book("Sherlock Holmes 1", "Doyle Arthur Conan", "crime", 492));
        b.add(new Book("Sherlock Holmes 2", "Doyle Arthur Conan", "crime", 521));
        b.add(new Book("Sherlock Holmes 3", "Doyle Arthur Conan", "crime", 600));


        b.add(new Book("Winnie the Pooh", "A. A. Milne", "children's literature", 900));


        Map<String, List<Book>> map = Book.generateMap(b);


        Assert.assertEquals(Book.avgPagesInType(map), "children's literature");

    }



}
