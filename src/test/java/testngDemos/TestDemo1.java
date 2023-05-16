package testngDemos;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDemo1 {
	
	@Test(groups = {"smoke"})
	void test1() {
		int a=5;
		int b=6;
		System.out.println("the sum value is:"+a+b);
	}
	
	@Test(groups = {"sanity"})
	@Parameters({"c","d"})
	void test2sub(int k, int j) {
		
		System.out.println("the sub(parameterized) value is:"+k+j);
	}

	@Test(groups = {"smoke"})
	void test3multiply() {
		int a=5;
		int b=6;
		System.out.println("the multiply value is:"+a*b);
	}

}
