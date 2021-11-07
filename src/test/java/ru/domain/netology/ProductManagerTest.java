package ru.domain.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductManager manager = new ProductManager(new ProductRepository());

    Product first = new Book(1, "The green miles", 560, "King");
    Product second = new Book(2, "Harry Potter and the Camber of Secrets", 1500, "Rowling");
    Product third = new Book(3, "Dunno on the Moon", 1000, "Nosov");
    Product fourth = new Book(4, "Harry Potter and the Philosopher's Stone", 930, "Rowling");
    Product fifth = new Smartphone(5, "iPhone 6", 400, "Apple");
    Product sixth = new Smartphone(6, "Samsung 9", 1000, "SamsunG");
    Product seventh = new Smartphone(7, "iPhone 13", 1100, "Apple");
    Product eighth = new Smartphone(8, "Samsung 7", 1100, "SamsunG");

    Product tshirt = new Tshirt(9, "Polo", 250, "Nike");

    Product one = new Book(25, "Paris", 350, "Guid");
    Product two = new Book(25, "Paris", 350, "Guid");
    Product three = new Book(26, "Paris", 350, "Guid");
    Product four = new Book(25, "England", 350, "Guid");
    Product five = new Book(25, "Paris", 360, "Guid");
    Product six = new Book(25, "Paris", 350, "Roar");

    @Test
    void shouldSetNameOfProduct() {
        Product item = new Product();
        item.setName("Book");
        String actual = item.getName();
        String expected = "Book";

        assertEquals(actual, expected);
    }


    @Test
    void shouldSaveBookAndFilm() {
        manager.save(first);
        manager.save(second);
        manager.save(sixth);
        manager.save(eighth);

        manager.getAll();
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{first, second, sixth, eighth};
        assertArrayEquals(actual, expected);


    }

    @Test
    void shouldSaveOneBookOrFilm() {
        manager.save(fifth);

        manager.getAll();
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{fifth};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSaveEightBookOrFilm() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);


        manager.getAll();
        Product[] actual = manager.getAll();
//        Product[] expected = new Product[]{eighth, seventh, sixth, fifth, fourth, third};
        Product[] expected = new Product[]{first, second, third, fourth, fifth, sixth, seventh, eighth};
        assertArrayEquals(actual, expected);
    }


    @Test
    void removeById() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);

        manager.removeById(4);

        manager.getAll();

        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{first, second, third, fifth, sixth, seventh, eighth};
        assertArrayEquals(actual, expected);


    }

    @Test
    void shouldSearchByNameBook() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);


        Product[] actual = manager.searchBy("Harry");
        Product[] expected = new Product[]{second, fourth};
        assertArrayEquals(actual, expected);


    }

    @Test
    void shouldSearchByAuthorBook() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);


        Product[] actual = manager.searchBy("Rowling");
        Product[] expected = new Product[]{second, fourth};
        assertArrayEquals(actual, expected);


    }

    @Test
    void shouldSearchByNameSmartphone() {
        manager.save(fifth);
        manager.save(second);
        manager.save(seventh);
        manager.save(eighth);


        Product[] actual = manager.searchBy("iPhone");
        Product[] expected = new Product[]{fifth, seventh};
        assertArrayEquals(actual, expected);

    }

    @Test
    void shouldSearchByProduceSmartphone() {
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);


        Product[] actual = manager.searchBy("SamsunG");
        Product[] expected = new Product[]{sixth, eighth};
        assertArrayEquals(actual, expected);

    }

    @Test
    void shouldNotSearchByProduct() {
        manager.save(tshirt);

        Product[] actual = manager.searchBy("Nike");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);

    }

    @Test
    void shouldUseEqualsSmartphoneOneEqualsTwo() {

        Product one = new Smartphone(13, "iPhone", 1200, "Apple");
        Product two = new Smartphone(13, "iPhone", 1200, "Apple");
        assertEquals(one, two);

    }

    @Test
    void shouldUseEqualsBookOneNotEquals() {

        Product one = new Book(28, "Book", 18, "Booker");
        assertFalse(one.equals(sixth));

    }

    @Test
    void shouldUseEqualsDifferentSmartphone() {
        manager.save(sixth);
        manager.save(seventh);

        assertFalse(seventh.equals(sixth));
    }

    @Test
    void shouldUseEqualsSmartphoneWithNull() {

        manager.save(sixth);
        manager.save(seventh);

        sixth = null;
        assertFalse(seventh.equals(sixth));
    }


    @Test
    void shouldUseEqualsDifferentBook() {
        manager.save(first);
        manager.save(second);

        assertFalse(first.equals(second));
    }

    @Test
    void shouldUseEqualsBookWithNull() {

        manager.save(third);
        manager.save(fourth);

        fourth = null;
        assertFalse(third.equals(fourth));
    }

    @Test
    void shouldUseEqualsProductOneEqualsTwo() {

        assertEquals(one, two);
    }

    @Test
    void shouldUseEqualsProductOneNotEqualsThree() {

        assertNotEquals(one, three);
    }

    @Test
    void shouldUseEqualsProductOneNotEqualsFour() {

        assertNotEquals(one, four);
    }

    @Test
    void shouldUseEqualsProductOneNotEqualsFive() {

        assertNotEquals(one, five);
    }

    @Test
    void shouldUseEqualsProductOneNotEqualsSix() {

        assertNotEquals(one, six);
    }


}