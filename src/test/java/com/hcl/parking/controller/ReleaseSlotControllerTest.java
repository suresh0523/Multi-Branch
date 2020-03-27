package com.hcl.parking.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.parking.dto.ResponseDto;
import com.hcl.parking.service.ReleaseSlotService;

@RunWith(MockitoJUnitRunner.class)
public class ReleaseSlotControllerTest {
	@Mock
	ReleaseSlotService releaseSlotService;

	@InjectMocks
	ReleaseSlotController releaseSlotController;
	MockMvc mockMvc;

	ResponseDto responseDto = new ResponseDto();

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(releaseSlotController).build();

	}

	@Test
	public void testReleaseSlot() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/releaseSlot").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(responseDto))).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
