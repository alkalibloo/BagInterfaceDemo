/**************************
 * Module 2 Critical Thinking
 * Bag Demo Class with Main()
 * CSC400
 * Prof. Shaher Daoud
 * Charles Emerson
 * 3/4/23
 **************************/

public class BagDemo {

	public static void main(String[] args) {

		BagInterface<Item> newCart = new ShoppingCart<>(5); // Create five-slot shopping cart

		testAdd(newCart); // Demonstrate filling the cart
		displayBag(newCart); // Demonstrate displaying the cart to the user

	}

	/* testAdd() adds some items to the shopping cart passed to it */
	public static void testAdd(BagInterface<Item> bag) {

		System.out.println("Adding test items to your shopping cart...\n\n");
		bag.add(new Item("Block of Cheese"));
		bag.add(new Item("Package of Sliced Ham"));
		bag.add(new Item("Box of Reese's Puffs"));
		bag.add(new Item("Apple"));
		bag.add(new Item("Spinach"));

	}

	/* displayBag() displays the formatted contents of the test bag to the user */
	public static void displayBag(BagInterface<Item> bag) {

		if (bag.isEmpty()) {
			System.out.println("There are no items in your cart to display.");
		} else {

			Object[] tempArray = bag.toArray(bag.getCurrentSize()); // Demo of toArray()

			System.out.println("Displaying your test shopping cart...\n");
			System.out.println("|=========================|");
			System.out.println("| Shopping Cart Contents  |");
			System.out.println("|=========================|");

			for (int i = 0; i < tempArray.length; i++) {

				System.out.printf("|- %-23s|\n", ((Item) tempArray[i]).getName());
			} // end for
			System.out.println("|=========================|\n");

		} // end if
	}

}
