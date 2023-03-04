/**************************
 * Module 2 Critical Thinking
 * Item class
 * CSC400
 * Prof. Shaher Daoud
 * Charles Emerson
 * 3/4/23
 **************************/

public class Item {

	/* Variables and data comprising an "Item" */
	String itemName;
	double price;
	int customerNumber;

	/* Item constructor with parameter for naming item */
	public Item(String name) {
		itemName = name;
	}

	/* Gets the name of the item */
	public String getName() {
		return itemName;
	}

}
