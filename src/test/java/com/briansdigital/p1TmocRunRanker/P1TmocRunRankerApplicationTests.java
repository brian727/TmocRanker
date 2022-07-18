package com.briansdigital.p1TmocRunRanker;

import com.briansdigital.p1TmocRunRanker.tmocker.TmockerRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class P1TmocRunRankerApplicationTests {

	@Autowired
	private TmockerRepo tmockerRepo;


	@Test
	void contextLoads() {
	}



//	@Test
//	public void testCreateTmocker() {
//		Tmocker tmocker = new Tmocker();
//		tmocker.setName("bitch");
//		tmocker.setEmail("bitch@aol.com");
//		tmockerRepo.save(tmocker);
//	}

}
