package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findWhiskiesByYear(){
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskyByYear(1987);
		assertTrue(foundWhiskies.size() > 0);
	}

	@Test
	public void findDistilleriesByRegion(){
		List<Distillery> foundDistilleries = distilleryRepository.findDistilleryByRegion("Highland");
		assertTrue(foundDistilleries.size() > 0);
	}

	@Test
	public void findWhiskiesFromADistilleryThatAreCertainAge(){
		List<Whisky> foundWhiskies = whiskyRepository.findByAgeAndDistilleryId(15, 1L);
		assertTrue(foundWhiskies.size() > 0);
	}


}
