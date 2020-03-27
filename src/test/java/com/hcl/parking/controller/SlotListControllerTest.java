package com.hcl.parking.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.parking.service.SlotListServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class SlotListControllerTest {

	@Mock
	SlotListServiceImpl slotListServiceImpl;

	@InjectMocks
	SlotListController slotListController;

	MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(slotListController).build();

	}

	@Test
	public void testGetsSlotList() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/slots").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL))
				.andExpect(status().isOk());
	}

}
