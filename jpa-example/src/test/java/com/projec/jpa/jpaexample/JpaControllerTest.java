package com.projec.jpa.jpaexample;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc  //simular una llamada a codigo desde el cliente , simula peticion real http incluida la respuesta
public class JpaControllerTest {
    @LocalServerPort //trabjar con un servidor local
    private int port;
    @Autowired
    private TestRestTemplate restTemplate; // util para pruebas de integracion , permite consumir un api rest del caso de prueba

    @Test
    public void getAllCutomer() throws  Exception{
        ResponseEntity<List> response=
                this.restTemplate.getForEntity("http://localhost:"+ port +"/tienda/clientes",List.class);
        assertThat(response.getStatusCode(),equalTo(HttpStatus.OK));

    }


}
