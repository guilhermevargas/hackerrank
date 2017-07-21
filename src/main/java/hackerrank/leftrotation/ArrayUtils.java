package hackerrank.leftrotation;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayUtils {
	public static int[] rotate(int[] arrays, int d) {
		IntStream initSlice = slice(arrays, 0, d);
		IntStream endSlice = slice(arrays, d, arrays.length);
		
		return IntStream.concat(endSlice, initSlice).toArray();
	}
	
	public static void print(int[] arrays) {		
		String collect = Arrays.stream(arrays)
			.mapToObj(String::valueOf)
			.collect(Collectors.joining(" "));
		
		System.out.println(collect);
	}

	private static IntStream slice(int[] arrays, int init, int end) {
		return IntStream.range(init, end).map(i -> arrays[i]);
	}
}
