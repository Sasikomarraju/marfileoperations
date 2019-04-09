package springlearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BasicSpringApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//BinarySearchImpl  binarySearchObj = new BinarySearchImpl(new QuickSortAlgorithm());
		
		
		ApplicationContext applicationContext = SpringApplication.run(BasicSpringApplication.class,args);
		
		BinarySearchImpl binarySearchImpl = applicationContext.getBean(BinarySearchImpl.class);
		
		
		//int result = binarySearchObj.binarySearch(new int[] {12,4,6,3},3);
		int result = binarySearchImpl.binarySearch(new int[] {12,4,6,3},3);
		
		System.out.println("result is : " + result); 
		System.out.println("New Output = " + binarySearchImpl);
		SpringApplication.run(BasicSpringApplication.class, args);
		
	}

}
