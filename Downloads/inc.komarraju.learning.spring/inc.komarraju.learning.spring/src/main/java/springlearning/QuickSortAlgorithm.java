package springlearning;

import org.springframework.stereotype.Component;

@Component
public class QuickSortAlgorithm implements SortAlgorithm{

	public int[] sort(int[] numbers) {
		System.out.print("In Quick Sort Class \n" );
		return numbers;
	}

	
}
