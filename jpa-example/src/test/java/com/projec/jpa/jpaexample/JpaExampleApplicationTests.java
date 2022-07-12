package com.projec.jpa.jpaexample;

import com.projec.jpa.jpaexample.controller.CustomerController;
import com.projec.jpa.jpaexample.service.CustomerImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
class JpaExampleApplicationTests {

	@Autowired
	private MockMvc mockmvc; //mockea el incio de un servidor http y procesamiento de respuestas

	@MockBean
	CustomerImpl servicio; //mockea las dependencias dentro del controlador para invocacion al servicio

	@Test
	public void getAllCustomers() throws Exception {
		/**
		 * mockmvc.perform nos permite consumir un servicio
		 */
		mockmvc.perform(get("/tienda/clientes/"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json("[]"));
		verify(servicio,times(1)).listaCustomer();
	}



}
