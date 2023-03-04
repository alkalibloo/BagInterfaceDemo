/**************************
 * Module 2 Critical Thinking
 * ShoppingCart class
 * CSC400
 * Prof. Shaher Daoud
 * Charles Emerson
 * 3/4/23
 **************************/

public class ShoppingCart<MyType> implements BagInterface<MyType> {

	/* Variables and data comprising a "Shopping Cart" */
	private final MyType[] myBag; // Array used as bag
	private int numberOfProducts; // int keeps track of bag size
	public static final int DEFAULT_CAPACITY = 25; // Default bag size

	/* Creates an empty bag of variable capacity */
	public ShoppingCart(int capacity) {
		numberOfProducts = 0;

		@SuppressWarnings("unchecked") // Suppressing unchecked cast warning
		MyType[] tempBag = (MyType[]) new Object[capacity];// Casting type object
															// to type MyType
		myBag = tempBag;
	} // end ShoppingCart(int capacity)

	/* Default constructor creates an empty bag whose capacity is 25. */
	public ShoppingCart() {
		this(DEFAULT_CAPACITY);
	} // end ShoppingCart default constructor

	/* Find out if the shopping cart is full. Returns boolean to that effect */
	private boolean isFull() {
		return numberOfProducts == myBag.length;
	} // end isFull

	/* Get and return current number of items in shopping cart */
	@Override
	public int getCurrentSize() {
		return myBag.length;
	} // end getCurrentSize

	/* Find out if the shopping cart is full. Returns boolean to that effect */
	@Override
	public boolean isEmpty() {
		return numberOfProducts == 0;
	} // end isEmpty

	/*
	 * Add an item to the shopping cart Return false if shopping cart was already
	 * full
	 */
	@Override
	public boolean add(MyType anEntry) {
		boolean result = true;
		if (isFull()) {
			result = false;
		} else { // assertion: result is true here
			myBag[numberOfProducts] = anEntry; // add new item to end of
												// shopping cart
			numberOfProducts++;
		} // end if
		return result;
	} // end add

	/* Remove an unspecified item from the bag */
	@Override
	public MyType remove() {
		MyType result = removeEntry(numberOfProducts - 1);
		return result;
	} // end remove()

	/* Removes a specific item from the bag */
	@Override
	public boolean remove(MyType anEntry) {
		int index = getIndexOf(anEntry);
		MyType result = removeEntry(index);
		return anEntry.equals(result);
	} // end remove(Item)

	@Override
	public int getFrequencyOf(MyType anEntry) {
		// TODO Auto-generated method stub
		return -1;
	} // end getFrequencyOf()

	@Override
	public boolean contains(MyType anEntry) {

		boolean result = false;
		for (int i = 0; i < myBag.length; i++) {
			if (myBag[i] == anEntry) {
				result = true;
			}
		}

		return result;
	} // end contains()

	/* Puts the bag into a separate array for the programmer to work with */
	@Override
	public MyType[] toArray(int capacity) {

		@SuppressWarnings("unchecked")
		MyType[] result = (MyType[]) new Object[capacity]; // unchecked

		for (int index = 0; index < numberOfProducts; index++) {
			result[index] = myBag[index];
		} // end for
		return result;
	} // end toArray

	/* Private removeEntry removes an item at a given index */
	private MyType removeEntry(int givenIndex) {
		MyType result = null;
		if (!isEmpty() && (givenIndex > +0)) {
			result = myBag[givenIndex]; // Entry to remove
			myBag[givenIndex] = myBag[numberOfProducts - 1]; // Replace it with last entry
			myBag[numberOfProducts - 1] = null; // Remove last entry
			numberOfProducts--;
		} // End if
		return result;
	} // end removeEntry

	/* Private getIndexOf finds index position of an item in the bag. Returns index
	 * of item if located, else "-1"*/
	private int getIndexOf(MyType anEntry) {
		int where = -1;
		boolean found = false;
		int index = 0;
		while (!found && (index < numberOfProducts)) {
			if (anEntry.equals(myBag[index])) {
				found = true;
				where = index;
			} else
				index++;
		} // end while
			// Assertion: If where > -1, anEntry is in the array bag, and
			// equals bag[where]; otherwise, anEntry is not in the array
		return where;
	} // end getIndexOf

}