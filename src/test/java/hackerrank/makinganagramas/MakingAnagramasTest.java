package hackerrank.makinganagramas;

import org.junit.Assert;
import org.junit.Test;

public class MakingAnagramasTest {
	@Test
	public void mustCountNumberNeededBecomeAnagramTest() {
		String a = "cde";
		String b = "abc";
		
		int numberNeeded = MakingAnagram.numberNeeded(a, b);
		Assert.assertEquals(4, numberNeeded);
	}
	
	@Test
	public void mustReturnZeroToPerfectAnagramTest() throws Exception {
		String a = "abc";
		String b = "bca";
		
		int numberNeeded = MakingAnagram.numberNeeded(a, b);
		Assert.assertEquals(0, numberNeeded);
	}
	
	@Test
	public void mustReturnTwoToBecomeAnagramTest() throws Exception {
		String a = "bacdc";
		String b = "dcbad";
		
		int numberNeeded = MakingAnagram.numberNeeded(a, b);
		Assert.assertEquals(2, numberNeeded);
	}
	
	@Test
	public void mustToReturnFourToWordSmallerThanOtherTest() throws Exception {
		String a = "bacdc";
		String b = "a";
		
		int numberNeeded = MakingAnagram.numberNeeded(a, b);
		Assert.assertEquals(4, numberNeeded);
	}
}
