package dev.trials.spring.services.eventdispatch;

import org.junit.Before;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

public abstract class DomainEventDispatchContractTestBase {

	@Before
	public void setup(){
		RestAssuredMockMvc.standaloneSetup(new DomainEventController());
	}
}