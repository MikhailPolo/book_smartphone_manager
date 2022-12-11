package ru.netology.java;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class ProductManagerTest {

    @Test
    public void testAdd(){
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        Book book1 = new Book(1, "Harry 1", 100, "author 1" );
        Book book2 = new Book(2, "Harry 2", 200, "author 1" );
        Book book3 = new Book(3, "Prince ", 300, "author 2" );

        Smartphone smartphone1 = new Smartphone(10, "Samsung S10", 1000, "manufacture 1");
        Smartphone smartphone2 = new Smartphone(11, "Samsung S20", 2000, "manufacture 1");
        Smartphone smartphone3 = new Smartphone(12, "Iphone 14", 3000, "manufacture 2");


        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);


        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSearch() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        Smartphone smartphone1 = new Smartphone(10, "Samsung S10", 1000, "manufacture 1");
        Smartphone smartphone2 = new Smartphone(11, "Samsung S20", 2000, "manufacture 1");
        Smartphone smartphone3 = new Smartphone(12, "Iphone 14", 3000, "manufacture 2");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);


        Product[] expected = {smartphone1, smartphone2};
        Product[] actual = manager.searchBy("Samsung");

        Assertions.assertArrayEquals(expected, actual);
    }
}
