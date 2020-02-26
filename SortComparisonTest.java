/*	
 * a. Which of the sorting algorithms does the order of input have an impact on? Why?
 * 
 * 	- insertion sort, because we try to find the correct position of the current element we are sorting. If they are sorted,
 * 	  we compare each element to the next and never have to change the position of any of them. However, because we go from
 * 	  smallest index to the largest, if the elements are in reverse order, this makes insertion sort incredibly inefficient 
 * 	  due to all the switching we have to do.
 * 
 * b. Which algorithm has the biggest difference between the best and worst performance, based
 * on the type of input, for the input of size 1000? Why?
 * 
 * 	- insertion sort, because we try to find the correct position of the current element we are sorting. If they are sorted,
 * 	  we compare each element to the next and never have to change the position of any of them. However, because we go from
 * 	  smallest index to the largest, if the elements are in reverse order, this makes insertion sort incredibly inefficient 
 * 	  due to all the switching we have to do.
 * 
 * c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
 * based on the input size? Please consider only input files with random order for this answer.
 * 
 * 	- best: quick sort
 * 	- worst: insertion sort
 * 
 * d. Did you observe any difference between iterative and recursive implementations of merge
 * sort?
 * 
 * 	- iterative merge sort is a lot more scalable than recursive merge sort
 * 
 * e. Which algorithm is the fastest for each of the 7 input files?
 * 
 * 	- 10 random: selection sort
 * 	- 100 random: insertion sort
 * 	- 1000 random: quick sort
 * 	- 1000 duplicates: quick sort
 * 	- 1000 nearly ordered: quick sort
 * 	- 1000 reverse order: quick sort
 * 	- sorted: insertion sort
 * 
 * ms = milliseconds
 * 							insertion		selection		merge recursive		merge iterative		quick
 * 10 random				0.0087ms		0.0082ms		0.0255ms			0.1108ms			0.0134ms
 * 100 random				0.0847ms		0.1656ms		0.1513ms			0.1304ms			0.0955ms
 * 1000 random				9.6318ms		8.0544ms		6.4469ms			0.6427ms			0.328ms
 * 1000 duplicates			7.2043ms		11.6969ms		2.9979ms			0.7294ms			0.3382ms
 * 1000 nearly ordered		1.4359ms		10.7021ms		7.0117ms			0.8651ms			0.3692ms
 * 1000 reverse order		7.5224ms		6.8331ms		5.5462ms			0.6991ms			0.2956ms
 * sorted					0.0714ms		8.9602ms		6.7761ms			0.8899ms			0.4069ms
 * 
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
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
		int size = 1000;
		File file = new File("numbersSorted1000.txt");
		Scanner scan;

		try {
			scan = new Scanner(file);
			double[] a = new double[size];
			double[] b = new double[size];
			double[] c = new double[size];
			double[] d = new double[size];
			double[] e = new double[size];

			for(int i = 0; i < size; i++)
			{
				a[i] = scan.nextDouble();
			}

			b = a; c = a; d = a; e = a;

			double start = System.nanoTime();
			SortComparison.insertionSort(a);
			double end = System.nanoTime();
			double result = (end - start) /1000000;
			System.out.println("Insertion sort: " + result + " milliseconds");

			double start2 = System.nanoTime();
			SortComparison.selectionSort(b);
			double end2= System.nanoTime();
			double result2 = (end2 - start2) /1000000;
			System.out.println("Selection sort:" + result2 + " milliseconds");

			double start3 = System.nanoTime();
			SortComparison.quickSort(c);
			double end3 = System.nanoTime();
			double result3 = (end3 - start3) /1000000;
			System.out.println("Quicksort:" + result3 + " milliseconds");

			double start4 = System.nanoTime();
			SortComparison.mergeSortIterative(d);
			double end4= System.nanoTime();
			double result4 = (end4 - start4) /1000000;
			System.out.println("Iterative mergesort:" + result4 + " milliseconds");

			double start5 = System.nanoTime();
			SortComparison.mergeSortRecursive(e);
			double end5= System.nanoTime();
			double result5 = (end5 - start5) /1000000;
			System.out.println("Recursive mergesort:" + result5 + " milliseconds");

			scan.close();

		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		}	}

}
