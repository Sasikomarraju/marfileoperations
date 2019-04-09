package springlearning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springlearning.SortAlgorithm;

@Component
public class BinarySearchImpl {

	//Sorting an array
	//Search the array
	//Return the result
	@Autowired
	private SortAlgorithm sortAlgorithmObj;
	
	public BinarySearchImpl(SortAlgorithm sortAlgorithmObj) {
		super();
		this.sortAlgorithmObj = sortAlgorithmObj;
	}

	public int binarySearch(int[] numbers, int numberToSearchFor) {
		//Implementing Sort Logic
		
		System.out.println("In BinarySearch function");
		System.out.println("Getting ready for Sorting data");
		//BubbleSortAlgorithm bubbleSortAlgorithmObj = new BubbleSortAlgorithm();
		//int [] sortedNumbers = bubbleSortAlgorithmObj.bubbleSort(numbers);
		
		int[] sortedNumbers = sortAlgorithmObj.sort(numbers);
		System.out.println(sortAlgorithmObj);
		
		System.out.println("Sorting is complete");
		
		//Search the array
				// Return
		System.out.println("Getting ready for Searching data");
		
		return 3;
	}
	
}
