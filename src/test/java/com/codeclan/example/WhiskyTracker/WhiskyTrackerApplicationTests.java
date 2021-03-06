package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

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
	public void findWhiskyByYear() {
		List<Whisky> found = whiskyRepository.findWhiskyByYear(1991);
		assertEquals("The Rosebank 12 - Flora and Fona", found.get(0).getName());
	}

	@Test
	public void findDistilleryByRegion() {
		List<Distillery> found = distilleryRepository.findDistilleryByRegion("Highland");
		assertEquals("Glendronach", found.get(0).getName());
	}

	@Test
	public void canFindWhiskyThatHasDistilleryAndYear() {
		List<Whisky> found = whiskyRepository.findWhiskyThatHasDistilleryAndYear("Glendronach", 2018);
		assertEquals("The Glendronach Revival", found.get(0).getName());
	}

	@Test
	public void findWhiskyByDistilleryIdAndYear() {
		List<Whisky> found = whiskyRepository.findWhiskyByDistilleryIdAndYear(1L, 2018);
		assertEquals("The Glendronach Revival", found.get(0).getName());
	}

	@Test
	public void findWhiskyByDistilleryRegion() {
		List <Whisky> found = whiskyRepository.findWhiskyByDistilleryRegion("Speyside");
		assertEquals("The Macallan Anniversary Malt", found.get(0).getName());
	}

	@Test
	public void findDistilleryByWhiskiesAge() {
		List<Distillery> found = distilleryRepository.findDistilleryByWhiskiesAge(25);
		assertEquals("Macallan", found.get(0).getName());
	}





}
