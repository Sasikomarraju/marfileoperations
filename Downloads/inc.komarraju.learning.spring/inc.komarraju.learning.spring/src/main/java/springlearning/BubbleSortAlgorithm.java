package springlearning;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BubbleSortAlgorithm implements SortAlgorithm{

	public int[] sort(int[] numbers) {
		System.out.print("In Bubble Sort Class \n");
		return numbers;
	}
	
}
