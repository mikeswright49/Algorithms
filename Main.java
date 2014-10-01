import java.text.*;
import java.util.Date;
import java.util.Random;

import SortingAlgorithms.*;


public class Main {

	public static void main(String[] args) {
		int[] randomValues=new int[100];
		Random random = new Random();
		for(int i=0;i<randomValues.length;i++){
			randomValues[i] = random.nextInt(100);
		}
		ISorter sorter = new MergeSort();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		randomValues = sorter.Sort(randomValues);
		
		for(int i=0;i<randomValues.length;i++){
			System.out.println(randomValues[i]);
		}
		System.out.println("FINISHED: ELEMENT COUNT:"+randomValues.length);
		System.out.println(dateFormat.format(new Date()));
	}

}
