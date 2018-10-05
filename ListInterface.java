interface ListInterface{

    /**

     * Description: add number to the end of a list

     * @param num the number to be added to the list

     * @return true if the number can be added successfully,

    false if not

     */

    public abstract boolean add(double num);

    /**

     * Description: get the values from the list at the specified

     index

     * @param index the index to get the value from the list

     * @return the value at the index of the list if

    successfully retrieve,

     * else, throw an ArrayIndexOutOfBoundsException

     */

    public abstract double get(int index);

    /**

     * Description: set the value at the specified index of the list

     with a new value

     * @param index the index of the list to set the old value with

    the new value

     * @param newNum the new value for the method

     * @return newNum if successfully "setted",

     * else, throw an ArrayIndexOutOfBoundsException

     */

    public abstract double set(int index, double newNum);

    /**

     * Description: get the values from the list at the specified

     index

     * @param index the index of the list to remove the element

     * @return the value that was removed if the operation was

    successful,

     * else, throw an ArrayIndexOutOfBoundsException

     */

    public abstract double remove(int index);

    /**

     * Description: returns the size of the list

     * @return the size of the list

     */

    public abstract int size();

}
