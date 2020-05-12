package dev.trials.spring.services.eventdispatch;

import java.util.Calendar;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.http.HttpStatus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
@RunWith(SpringRunner.class)
@ActiveProfiles("staging")
public class DomainEvtControllerIntegrationTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;

	@Test
	public void shouldReturn400_forInvalidEvent() throws Exception {
		DomainEvtResource i_resource= DomainEvtResource.builder().timestamp(Calendar.getInstance().getTime().getTime()).build();
		String i_resource_str=mapper.writeValueAsString(i_resource);

		mockMvc.perform(MockMvcRequestBuilders.post("/domain/event/")
							.content(i_resource_str)
							.contentType("application/json")
							.accept("application/json"))
							.andExpect(MockMvcResultMatchers.status().isBadRequest())
							.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void shouldReturn200_forValidEvent() throws Exception {
		DomainEvtResource i_resource= DomainEvtResource.builder()
		.timestamp(Calendar.getInstance().getTime().getTime())
		.sourceRef("catalog-service")
		.domain("commerce")
		.type("NewProductAdded")
		//.desc("New Product Wings-Of-Fire Has Been Added to Catalog")
		.build();
		String i_resource_str=mapper.writeValueAsString(i_resource);

		mockMvc.perform(MockMvcRequestBuilders.post("/domain/event/")
							.content(i_resource_str)
							.contentType("application/json")
							.accept("application/json"))
							.andExpect(MockMvcResultMatchers.status().isAccepted())
							.andDo(MockMvcResultHandlers.print());
	}
}