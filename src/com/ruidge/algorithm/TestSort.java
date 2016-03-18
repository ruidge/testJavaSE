package com.ruidge.algorithm;

public class TestSort {
	public static void main(String[] args) {

		int[] array = { 20, 3, 2, 1, 40, 23, 54, 5, 56, 7, 9, 89, 10, 7, 6 };
		TestSort self = new TestSort();
		self.printArray(array);
		// self.printArray(self.mergeSort(array));
		// self.quickSort(array, 0, array.length - 1);
		// self.quick_sort(array, 0, array.length - 1);
		self.printArray(self.mergeSort(array));
		self.printArray(array);
		self.myQuickSort(array, 0, array.length - 1);
		self.printArray(array);
	}

	private void myQuickSort(int[] source, int left, int right) {
		if (left < right) {
			int i = left;
			int j = right;
			int key = source[right];
			//大于key的都放到右面,小于key的都放到左面
			while (i < j) {
				while (i < j && source[i] <= key) {
					i++;
				}
				if (i < j) {
					source[j] = source[i];
					j--;
				}
				while (i < j && source[j] > key) {
					j--;
				}
				if (i < j) {
					source[i] = source[j];
					i++;
				}
			}
			source[i] = key;
			myQuickSort(source, left, i - 1);
			myQuickSort(source, i + 1, right);
		}
	}

	private void printArray(int[] array) {
		StringBuilder sb = new StringBuilder();
		for (int i : array) {
			sb.append(i + " ");
		}
		System.out.println(sb.toString());
	}

	private int[] mergeSort(int[] source) {
		if (source.length == 1) {
			return source;
		} else {
			int mid = source.length / 2;
			int[] leftInit = new int[mid];
			int[] rightInit = new int[source.length - mid];
			for (int i = 0; i < mid; i++) {
				leftInit[i] = source[i];
			}
			for (int i = 0; i + mid < source.length; i++) {
				rightInit[i] = source[i + mid];
			}
			int[] leftResult = mergeSort(leftInit);
			int[] rightResult = mergeSort(rightInit);
			return mergeList(leftResult, rightResult);
		}
	}

	private int[] mergeList(int[] leftResult, int[] rightResult) {
		int[] result = new int[leftResult.length + rightResult.length];
		int i = 0;
		int j = 0;
		int index = 0;
		while (i < leftResult.length && j < rightResult.length) {
			if (leftResult[i] <= rightResult[j]) {
				result[index] = leftResult[i];
				i++;
			} else {
				result[index] = rightResult[j];
				j++;
			}
			index++;
		}
		if (i == leftResult.length) {
			while (j < rightResult.length) {
				result[index] = rightResult[j];
				index++;
				j++;
			}
		} else {
			while (i < leftResult.length) {
				result[index] = leftResult[i];
				index++;
				i++;
			}
		}
		return result;
	}

	void quick_sort(int s[], int left, int right) {
		if (left < right) {
			int i = left, j = right, x = s[left];
			while (i < j) {
				while (i < j && s[j] >= x)
					// 从右向左找第一个小于x的数
					j--;
				if (i < j)
					s[i++] = s[j];
				while (i < j && s[i] < x)
					// 从左向右找第一个大于等于x的数
					i++;
				if (i < j)
					s[j--] = s[i];
			}
			s[i] = x;
			quick_sort(s, left, i - 1); // 递归调用
			quick_sort(s, i + 1, right);
		}
	}
}
