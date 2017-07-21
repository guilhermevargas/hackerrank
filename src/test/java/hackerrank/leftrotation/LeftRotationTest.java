package hackerrank.leftrotation;

import org.junit.Assert;
import org.junit.Test;

public class LeftRotationTest {
	@Test
	public void rotateTest() {
		int[] a = {1, 2, 3, 4, 5};
		int[] rotationated = ArrayUtils.rotate(a, 2);
		
		ArrayUtils.print(rotationated);
		Assert.assertEquals(5, rotationated.length);
	}
}
