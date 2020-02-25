import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Barbara Molnar
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
	//~ Constructor ........................................................
	@Test
	public void testConstructor()
	{
		new SortComparison();
	}

	//~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check that the methods work for empty arrays
	 */
	@Test
	public void testEmpty()
	{
		double[] arr = {};
		assertEquals("Testing empty array for insertion sort", null, SortComparison.insertionSort(arr));
		assertEquals("Testing empty array for selection sort", null, SortComparison.selectionSort(arr));
		assertEquals("Testing empty array for quicksort sort", null, SortComparison.quickSort(arr));
		assertEquals("Testing empty array for iterative mergesort sort", null, SortComparison.mergeSortIterative(arr));
		assertEquals("Testing sempty array for recursive mergesort", null, SortComparison.mergeSortRecursive(arr));

	}


	// TODO: add more tests here. Each line of code and ech decision in Collinear.java should
	// be executed at least once from at least one test.

	// test function for insertion sort
	@Test
	public void testInsertionSort()
	{
		double[] arr = {22.22, 3.21, 6.32, 19.86, 5.41};
		double[] result = {3.21, 5.41, 6.32, 19.86, 22.22};
		assertTrue(Arrays.equals(result, SortComparison.insertionSort(arr)));
	}

	// test function for selection sort
	@Test
	public void testSelectionSort()
	{
		double[] arr = {22.22, 3.21, 6.32, 19.86, 5.41};
		double[] result = {3.21, 5.41, 6.32, 19.86, 22.22};
		assertTrue(Arrays.equals(result, SortComparison.selectionSort(arr)));
	}

	// test function for quick sort
	@Test
	public void testQuickSort()
	{
		double[] arr = {22.22, 3.21, 6.32, 19.86, 5.41};
		double[] result = {3.21, 5.41, 6.32, 19.86, 22.22};
		assertTrue(Arrays.equals(result, SortComparison.quickSort(arr)));
	}

	// test function for iterative merge sort
	@Test
	public void testMergeSortIterative()
	{
		double[] arr = {22.22, 3.21, 6.32, 19.86, 5.41};
		double[] result = {3.21, 5.41, 6.32, 19.86, 22.22};
		assertTrue(Arrays.equals(result, SortComparison.mergeSortIterative(arr)));
	}

	// test function for recursive merge sort
	@Test
	public void testMergeSortRecursive()
	{
		double[] arr = {22.22, 3.21, 6.32, 19.86, 5.41};
		double[] result = {3.21, 5.41, 6.32, 19.86, 22.22};
		assertTrue(Arrays.equals(result, SortComparison.mergeSortRecursive(arr)));
	}


	// ----------------------------------------------------------
	/**
	 *  Main Method.
	 *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
	 * @throws FileNotFoundException
	 *
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		//TODO: implement this method
	}

}
