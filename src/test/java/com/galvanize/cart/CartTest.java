package com.galvanize.cart;
import java.util.*;

import com.galvanize.App;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {
    private Cart testCart;
    /*
        @BeforeClass
         void init() {
         testCart = new Cart();
        }

      Used for expensive setup, will run once for each class

    */

//    @AfterEach
//    void teardown() {
//        testCart.userCart.clear();
//    }

    @BeforeEach
    void init() {
        testCart = new Cart();
    }

    @Test
    public void testUserCartExists() {
//        Cart testCart = new Cart();

        assertNotNull(testCart.userCart, "User cart exists when customer starts shopping");
    }

    @Test
    public void checkUserCartType() {
//        Cart testCart = new Cart();
        assertTrue(testCart.userCart instanceof HashMap, "userCart is of type HashMap");
    }

    @Test
    public void isUserCartEmptyWhenFirstShopping() {
        Integer expected = 0;
//        Cart testCart = new Cart();

        assertEquals(expected, testCart.itemQuantity, "user cart should have zero items when first shopping");
    }

    @Test
    public void testTotalPriceExists() {
//        Cart testCart = new Cart();
        assertNotNull(testCart.totalPrice, "Total Price exists");
    }

    @Test
    public void testGetTotalPriceType() {
//        Cart testCart = new Cart();
        assertTrue(testCart.totalPrice instanceof Double, "Total price is type Double");
    }

    @Test
    public void testIsTotalPriceInitializedToZero () {
//        Cart testCart = new Cart();
        assertEquals(0.0, testCart.totalPrice, "Total price is initialized to 0.0");
    }

    @Test
    public void testCanGetTotalPriceOfOneItem() {
        Item testItem = new Item("Test Item", 1.01, true);
        double expectedSingleItemTotal = 1.01;
        testCart.addItem(testItem, 1);

        assertEquals(expectedSingleItemTotal, testCart.totalPrice, "Total price in the cart should be 1.01");
    }

    @Test
    public void testCanGetTotalPriceOfMultipleQuantities() {
        Item testItem = new Item("Test Item", 1.01, true);
        double expected = 1.01 * 2;
        testCart.addItem(testItem, 2);

        assertEquals(expected, testCart.totalPrice, "Total Price should be 2.02");
    }

    @Test
    public void testCanGetTotalPriceOfMultipleItems() {
        Item testItem1 = new Item("Test Item 1", 1.01, true);
        Item testItem2 = new Item("Test Item 2", 2.01, true);
        double expected = 3.02;

        testCart.addItem(testItem1, 1);
        testCart.addItem(testItem2, 1);

        assertEquals(expected, testCart.totalPrice, "Total Price should be 3.02");
    }

    @Test
    public void testCanAddItemToCart() {
        Item testItem = new Item("Test Item", 1.01, true);
        Integer expectedQuantity = 1;
        Integer expectedUserCartQuantity = 1;

        testCart.addItem(testItem, 1);
        Integer actualQuantity = testCart.itemQuantity;

        assertEquals(expectedQuantity, actualQuantity, "Expect cart to have 1 item");
        assertTrue(testCart.userCart.containsKey(testItem));
        assertEquals(expectedUserCartQuantity, testCart.userCart.get(testItem), "Expect user cart to have a quantity of 1 for test item");
        assertTrue(testCart.onSale.contains(testItem), "Expect cart to have test item on sale");
    }

    @Test
    public void testCanUpdateQuantityForAddingSameItem() {
        Item testItem = new Item("Test Item", 1.01, true);
        Integer expected = 2;

        testCart.addItem(testItem, 1);
        testCart.addItem(testItem, 1);

        assertEquals(expected, testCart.userCart.get(testItem));
    }

    @Test
    public void testItemizedList() {
        Item testItem1 = new Item("Test Item1", 1.01, true);
        Item testItem2 = new Item("Test Item2", 2.01, false);

        HashMap<Item, Integer> expected = new HashMap<Item, Integer>();
        expected.put(testItem1, 1);
        expected.put(testItem2, 1);

        testCart.addItem(testItem1, 1);
        testCart.addItem(testItem2, 1);
        HashMap<Item, Integer> actual = testCart.itemizedList();

        assertTrue(expected.equals(actual));
    }

    // Move to ItemTest
    @Test
    public void testNewItem() {
        Item testItem = new Item("Test Item", 1.01, true);
        String expectedName = "Test Item";
        Double expectedPrice = 1.01;
        boolean expectedSale = true;

        assertEquals(expectedName, testItem.name, "Name is Test Item");
        assertEquals(expectedPrice, testItem.price, "Price should be 1.01");
        assertEquals(expectedSale, testItem.onSale, "Item should be on sale");
    }



//    @Test
//    public void testAddItem() {
//        Cart testCart = new Cart();
//
//    }


//    @Test
//    public void testGetTotalPriceType1() {
//        Cart testCart = new Cart();
//        assertEquals("java.lang.Double", ((Object)(testCart.totalPrice)).getClass().getName());
//
//    }

    /*
        getTotalPrice()
        itemizedList()
        itemQuantities()
        onSaleItems()
        addItem(Item item, Integer quantity)
            update cart
                check key in userCart
                    if exists, upate quantity
                    if not exists, add to hash map
                 update total price
                 update item quantity
                 if item is on sale, add to sale items

        Cart
            HashMap<Item, integer> userCart
            double totalPrice;
            integer itemQuantity;
            Set<Item> saleItems;


        Item
            Fields
                double Price
                string name
                boolean onSale

            // http://vanillajava.blogspot.com/2011/08/double-your-money-again.html
            // uses round half up, or bankers' rounding
            public static double roundToTwoPlaces(double d) {
                return Math.round(d * 100) / 100.0;
            }
    */


//    @Test
//    public void testCartStartsEmpty() {
//        /* Cart
//            useCart []
//
//        */
//
//
//        //Setup
//        String[] expected = new String[]{};
//        Cart testCart = new Cart();
//
//        //Execute
//        String[] actual = testCart.userCart;
//
//        //Assertion
//        assertArrayEquals("When a user begins shopping, the cart should be empty", expected, actual);
//
//    }

}
