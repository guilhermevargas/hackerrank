package harckerrank.makeanagramas;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class MakingAnagramasTest {
	@Test
	public void makeAnagramasTest() throws Exception {
		String first = "cde";
		String second = "abc";
		
		int count = this.numberNeedComplicatedWayTest(first, second);
		Assert.assertEquals(count, 4);

		count = this.numberNeedSampleWayTest(first, second);
		Assert.assertEquals(count, 4);
	}
	
	public Integer numberNeedComplicatedWayTest(String first, String second) {
		ArrayList<Character> characters = new ArrayList<>();
		for (char c : first.toCharArray())
			characters.add(c);
		
		Map<Character, Integer> frequencyMap = characters.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
				
		Integer sum = 0;
		
		for (char c : second.toCharArray()) {
			Integer frequency = frequencyMap.get(c);
			
			if (frequency != null) {
				frequencyMap.put(c, --frequency);
			} else {
				sum++;
			}
		}
		
		for (Character c : frequencyMap.keySet()) {
			sum += frequencyMap.get(c);
		}
		
		return sum;
	}
	
	
	private int numberNeedSampleWayTest(String first, String second) {
		int[] lettercounts = new int[26];
		for(char c : first.toCharArray()){
			lettercounts[c-'a']++;
		}
		for(char c : second.toCharArray()){
			lettercounts[c-'a']--;
		}
		int result = 0;
		for(int i : lettercounts){
			result += Math.abs(i);
		}
		return result;		
	}
}
