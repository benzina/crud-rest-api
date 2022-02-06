package com.crud.api.crudrestapitutoriel.controller;

import com.crud.api.crudrestapitutoriel.model.Employe;
import com.crud.api.crudrestapitutoriel.model.dto.EmployeDto;
import com.crud.api.crudrestapitutoriel.model.mapper.EmployeMapper;
import com.crud.api.crudrestapitutoriel.service.EmployeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = EmployeController.class)
public class EmployeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeService employeeService;

    @MockBean
    private EmployeMapper mapper;

    EmployeDto mockEmploye = new EmployeDto("said", "saadi", "said@gmail.com");


    List<Employe> mockCustomerList = Arrays.asList(new Employe("benzina","mahdi", "benzina@gmail.com"), new Employe("bilal","benzina", "bilal@gmail.com"));

    String employeJson = "{\"firstName,\":\"said\",\"lastName\":\"saadi\",\"email\": \"said@gmail.com\"}";

    @Test
    public void testgetAllEmployes() throws Exception {
        mockMvc.perform(get("/api/employes"))
                .andExpect(status().isOk());
    }

    @Test
    public void testgetEmployeById() throws Exception {
        mockMvc.perform(get("/api/employes/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testputUpdateEmploye() throws Exception {

        Employe employe = new Employe("said","saadi", "said@gmail.com");
        String expected = "{\"firstName,\":\"said\",\"lastName\":\"saadi\",\"email\": \"said@gmail.com\"}";
        Mockito.when(employeeService.getEmployeById(1L)).thenReturn(employe);
        Mockito.when(employeeService.updateEmploye(employe, 1L)).thenReturn(employe);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/api/employes/update/1")
                .accept(MediaType.APPLICATION_JSON).content(expected)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(200, response.getStatus());
    }

    @Test
    public void testdeleteEmploye() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(
                "/api/employes/1").accept(
                MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }

    @Test
    public void testsaveEmploye() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
                "/api/employes/new-employe").accept(
                MediaType.APPLICATION_JSON).content(employeJson).contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }
}
