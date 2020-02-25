import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Barbara Molnar
 *  @version HT 2020
 */

class SortComparison {

	/**
	 * Sorts an array of doubles using InsertionSort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order.
	 *
	 */
	//based on code from lecture notes
	static double[] insertionSort(double a[]){

		//code for insertionSort
		int i, j;
		double index;
		int size = a.length;

		//check if array is empty
		if(size == 0)
		{
			return null;
		}

		for(i = 0; i < size; i++)
		{
			index = a[i];
			j = i;
			while((j > 0) && (a[j-1] > index))
			{
				a[j] = a[j-1];
				j = j-1;
			}
			a[j] = index;
		}
		return a;


	} //end insertionSort

	/**
	 * Sorts an array of doubles using Selection Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	//based on code from lecture notes
	static double[] selectionSort(double a[]){

		//code for selectionSort
		int size = a.length;

		//check if array is empty
		if(size == 0)
		{
			return null;
		}

		//one by one move boundary of unsorted array
		for(int i = 0; i< size-1; i++)
		{
			//find smallest element in unsorted array
			int smallest = i;
			for(int j = i + 1; j < size; j++)
			{
				if(a[j] < a[smallest])
				{
					smallest = j;
				}
			}

			//swap found smallest element with first element of array
			double tmp = a[smallest];
			a[smallest] = a[i];
			a[i] = tmp;
		}
		return a;

	} //end selectionSort

	/**
	 * Sorts an array of doubles using Quick Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */

	//code based on lecture notes
	static double[] quickSort(double a[]){

		//code for quickSort

		//check if array is empty
		if(a.length == 0)
		{
			return null;
		}
		recursiveQuick(a, 0, a.length-1);
		return a;

	}

	static void recursiveQuick(double a[], int lo, int hi)
	{
		if(hi <= lo) {
			return;
		}
		int pivotPos = partition(a, lo, hi);
		recursiveQuick(a, lo, pivotPos-1);
		recursiveQuick(a, pivotPos+1, hi);
	}

	static private int partition(double[] numbers, int lo, int hi)
	{
		int i = lo;
		int j = hi+1;
		double pivot = numbers[lo];
		while(true) {
			while(numbers[++i] < pivot)
			{
				if(i == hi)
				{
					break;
				}
			}
			while(pivot < numbers[--j])
			{
				if(j == lo)
				{
					break;
				}
			}
			if(i >= j)
			{
				break;
			}

			double tmp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = tmp;
		}
		numbers[lo] = numbers[j];
		numbers[j] = pivot;
		return j;
	} //end quickSort


	/**
	 * Sorts an array of doubles using Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	/**
	 * Sorts an array of doubles using iterative implementation of Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted order.
	 */

	//based on code from lecture notes
	static double[] mergeSortIterative(double a[]) {

		//code for mergeSortIterative
		int size = a.length;

		if(size == 0)
		{
			return null;
		}

		double[] aux = new double[size];
		for(int subsize = 1; subsize < size; subsize = subsize + subsize)
		{
			for(int lo = 0; lo < size-subsize; lo += subsize+subsize)
			{
				merge(a, aux, lo, lo+subsize-1, Math.min(lo+subsize+subsize-1,  size-1));
			}
		}
		return a;


	} // end of mergeSortIterative


	/**
	 * Sorts an array of doubles using recursive implementation of Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted order.
	 */

	//based on code from lecture notes
	static double[] mergeSortRecursive(double a[])
	{
		//code for mergeSortRecursive
		if(a.length == 0)
		{
			return null;
		}

		//		for(int i = 0; i < a.length; i++)
		//		{
		//			System.out.println("Unsorted " + a[i]);
		//		}

		double[] aux = new double[a.length];
		sort(a, aux, 0, a.length - 1);

		//		for(int j = 0; j < a.length; j++)
		//		{
		//			System.out.println("Sorted " + a[j]);
		//		}
		return a;

	}//end mergeSortIterative

	private static void sort(double[] a, double[] aux, int lo, int hi)
	{
		if(hi <= lo)
		{
			return;
		}
		int mid = lo + (hi-lo)/2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}

	private static void merge(double a[], double[] aux, int lo, int mid, int hi)
	{
		for(int k = lo; k <= hi; k++)
		{
			aux[k]=a[k];
		}
		int i = lo, j = mid + 1;
		for(int k = lo; k <= hi; k++)
		{
			if(i > mid)
			{
				a[k] = aux[j++];
			}
			else if(j > hi)
			{
				a[k] = aux[i++];
			}
			else if(aux[j] < aux[i])
			{
				a[k] = aux[j++];
			}
			else
			{
				a[k] = aux[i++];
			}
		}
	}

	//end mergeSortRecursive

	//discussed with Roisin Burke
	public static void main(String[] args) {
		//todo: do experiments as per assignment instructions
		int size = 10;

		File file = new File("numbers10.txt");
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
			insertionSort(a);
			double end = System.nanoTime();
			double result = (end - start) /1000000;
			System.out.println("Insertion sort: " + result + " milliseconds");

			double start2 = System.nanoTime();
			selectionSort(b);
			double end2= System.nanoTime();
			double result2 = (end2 - start2) /1000000;
			System.out.println("Selection sort:" + result2 + " milliseconds");

			double start3 = System.nanoTime();
			quickSort(c);
			double end3 = System.nanoTime();
			double result3 = (end3 - start3) /1000000;
			System.out.println("Quicksort:" + result3 + " milliseconds");

			double start4 = System.nanoTime();
			mergeSortIterative(d);
			double end4= System.nanoTime();
			double result4 = (end4 - start4) /1000000;
			System.out.println("Iterative mergesort:" + result4 + " milliseconds");

			double start5 = System.nanoTime();
			mergeSortRecursive(e);
			double end5= System.nanoTime();
			double result5 = (end5 - start5) /1000000;
			System.out.println("Recursive mergesort:" + result5 + " milliseconds");

			scan.close();
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		}


	}

} //end class
