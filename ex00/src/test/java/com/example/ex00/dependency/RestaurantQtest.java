package com.example.ex00.dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.ex00.dependency.qualifier.Restaurants;

import lombok.Builder.Default;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class RestaurantQtest {
	@Autowired
	@Qualifier("outback")
	private Restaurants outback;
	
	@Autowired
	@Qualifier("vips")
	private Restaurants vips;
	
	@Autowired
	@Default
	private Restaurants res;
	
	@Test
	public void testRestaurantD() {
		log.info("=====================");
		log.info("restaurant : "+outback);
		log.info("stake : "+outback.getStakePrice());
		log.info("stake : "+outback.getStakePrice()+" " +outback.steak);
		log.info("sidebar : "+outback.hasSidebar());
		log.info("=====================");
		log.info("restaurant : "+vips);
		log.info("stake : "+vips.getStakePrice());
		log.info("sidebar : "+vips.hasSidebar());
		log.info("=====================");
		log.info("restaurant : "+res);
		log.info("stake : "+res.getStakePrice());
		log.info("sidebar : "+res.hasSidebar());

	}

}
