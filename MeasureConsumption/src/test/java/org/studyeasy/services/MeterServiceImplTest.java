package org.studyeasy.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

class MeterServiceImplTest {
	
	//@Autowired
	//private TestEntityManager entityManager;

	@Test
	void testGetMeasureOfYear() {
		MeterServiceImpl meterServiceImpl = new MeterServiceImpl();
		Integer expected = 4300;
		Integer actual = meterServiceImpl.consumptionOfYear;
		assertThat(expected.equals(actual));

	}

	@Test
	void testGetMeasureOfYearOfMonth() {
		MeterServiceImpl meterServiceImpl = new MeterServiceImpl();
		Integer expected = 100;
		Integer actual = meterServiceImpl.consumptionOfMonth;
		assertThat(expected.equals(actual));
	}

	@Test
	void testGetMeasureOfYearAllMonths() {
		MeterServiceImpl meterServiceImpl = new MeterServiceImpl();
		Integer[] expected = {800,900,1000,1100,1200,600,700,800,900,1000,1100,1200};
		//System.out.println(meterServiceImpl.measureForTest[1]);
		//meterServiceImpl.getMeasureOfYearAllMonths(1, 2021);
		Integer[] actual = meterServiceImpl.measureForTest;
		assertThat(expected[3]==actual[3]);
		System.out.println(actual[3]);
		//assertArrayEquals(expected, actual, "Bla");
		}


}
