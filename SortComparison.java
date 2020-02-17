// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
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
	static double[] quickSort(double a[]){

		//code for quickSort

	}//end quickSort

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
		double[] aux = new double[size];
		for(int sz = 1; sz < size; sz = sz + sz)
		{
			for(int lo = 0; lo < size-sz; lo += sz+sz)
			{
				merge(a, aux, lo, lo+sz+1, Math.min(lo+sz+sz-1,  size-1));
			}
		}
		return aux;


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
		double[] aux = new double[a.length];
		sort(a, aux, 0, a.length - 1);
		return aux;

	}//end mergeSortIterative

	private static void sort(double[] a, double[] aux, int lo, int hi)
	{
		if(hi <= lo)
		{
			return;
		}
		int mid = lo + (hi+lo)/2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}

	private static void merge(double a[], double[] aux, int lo, int mid, int hi)
	{
		for(int k = lo; k <= hi; k++)
		{
			aux[k]=a[k];
		}
		int i = lo, j = mid+1;
		for(int k = lo; k <= hi; k++)
		{
			if(i>mid)
			{
				a[k] = aux[j++];
			}
			else if(j>hi)
			{
				a[k] = aux[j++];
			}
			else if(aux[j] < aux[i])
			{
				a[k] = aux[j++];
			}
			else
			{
				a[k] = aux[j++];
			}
		}
	}

	//end mergeSortRecursive


	public static void main(String[] args) {

		//todo: do experiments as per assignment instructions
	}

}//end class
