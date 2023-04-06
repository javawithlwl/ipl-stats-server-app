package com.lwl.iplstats;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class IplStatsServerAppApplicationTests {

	@Test
	void contextLoads() {
			int a = 10;
			assertTrue(a >=10,"value of a should >=10");
	}

}
