package com.fqy.bit;

public class QuickSort {
	private int[] numbers;
	private int number;

	public void sort(int[] values) {
		if (values == null || values.length == 0) {
			return;
		}
		this.numbers = values;
		number = values.length;
		quickSort(0, number - 1);
	}

	private void quickSort(int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		int pivot = numbers[low + (high - low) / 2]; // avoid overflow
		// Divide into two lists:
		while (i <= j) {
			/*
			 * If the current value from the left list is smaller than the pivot
			 * element then get the next element from the left list
			 */
			while (numbers[i] < pivot)
				i++;
			/*
			 * If the current value from the right list is larger that the pivot
			 * element then get the next element from the right list
			 */
			while (numbers[j] > pivot)
				j--;
			/*
			 * If we have found a value in the left list which is larger than
			 * the pivot element and if we have found a value in the right list
			 * which is smaller than the pivot then we exchange the values As we
			 * are done, we can increase i and decrease j
			 */
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j)
			quickSort(low, j);
		if (i < high)
			quickSort(i, high);

	}

	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
