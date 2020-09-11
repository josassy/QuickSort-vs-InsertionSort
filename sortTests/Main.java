package sortTests;
import java.io.FileNotFoundException;

/**
 * The Main class instantiates the Tests class and runs the Tests::runTests()
 * function to test all the desired sorting algorithms
 * 
 * @author  Rufus R Mathew, Josiah R Lansford
 * @since   2020-09-11
 *  File:   Main.java
 */
class Main {
  public static void main (final String[] args) throws FileNotFoundException {
    Tests testRunner = new Tests();
    testRunner.runTests();
  }
};

