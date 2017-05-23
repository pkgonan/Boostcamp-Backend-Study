package com.study;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoostcampBackendStudyApplicationTests {
	private int cnt = 0;

	@Before
	public void before(){
		System.out.println(++cnt);
	}

	@Test
	public void test1() {
		System.out.println(++cnt);
	}

	@Test
	public void test2(){
		System.out.println(++cnt);
	}
}
