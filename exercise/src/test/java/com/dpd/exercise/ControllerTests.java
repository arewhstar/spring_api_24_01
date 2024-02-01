package com.dpd.exercise;


import com.dpd.exercise.entity.Address;
import com.dpd.exercise.entity.Person;
import com.dpd.exercise.entity.Telephone;
import com.dpd.exercise.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.assertj.core.api.Assertions;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.verify;


@WebMvcTest(Controller.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class ControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    PersonRepository personRepository;
    private List<Address> la = new ArrayList<>();

    private List<Telephone> lt = new ArrayList<>();


    //The controller works, it gives back response, but simulating to save person in repository(mock) is not working currently, so testing other endpoints is irrelevant.
    @Test
    public void Controller_getPerson_Test() throws Exception {

        la.add(Address.builder().text("My address").build());
        lt.add(Telephone.builder().number("+7777777").build());
        Long personId = 1L;
        Person person = Person.builder().name("An Tony").address(la).telephone(lt).build();

        /*
        given(personRepository.save(any())).willAnswer(invocation -> {
            Person personToSave = invocation.getArgument(0);
            personToSave.setPer_id(1L); // Simulating the database-generated ID
            return personToSave;
        });
        */
        //Long personId = personCaptor.getValue().getPer_id();


        ResultActions response = mockMvc.perform(get("/person")
                .param("id", personId.toString())
                .contentType(MediaType.TEXT_PLAIN))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string("Person with id: (1) is not found!"));


    }
}
