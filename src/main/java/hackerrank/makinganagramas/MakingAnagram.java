package hackerrank.makinganagramas;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class MakingAnagram {
	
	public static int numberNeeded(String a, String b) {
		List<String> aList = Arrays.asList(a.split("\\s*"));
		List<String> bList = Arrays.asList(b.split("\\s*"));
		
		Map<String, Long> frequency = getFrequencyByChar(aList, bList);
		
		return countRemovedChars(frequency);
	}

	private static int countRemovedChars(Map<String, Long> frequency) {
		Iterator<String> it = frequency.keySet().iterator();
		
		int removedChars = 0;
		
		while(it.hasNext()) {
			Long count = frequency.get(it.next());
			if (count % 2 != 0) 
				removedChars++;
		}
		return removedChars;
	}

	private static Map<String, Long> getFrequencyByChar(List<String> aList, List<String> bList) {
		return Stream.concat(aList.stream(), bList.stream())
				.collect(groupingBy(identity(), counting()));
	}
}
