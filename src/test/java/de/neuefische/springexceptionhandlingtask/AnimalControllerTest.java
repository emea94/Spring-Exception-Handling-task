package de.neuefische.springexceptionhandlingtask;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class AnimalControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAnimalSpecies_whenSpeciesIsCat_ThenReturnExceptionHandling() throws Exception {
        mvc.perform(get("/api/animals/cat")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isMethodNotAllowed())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                            "errorMsg": "Only 'dog' is allowed",
                            "errorCode": "METHOD_NOT_ALLOWED"
                        }
                """));
                // Mit JsonPath kann man checken, ob Feld vorhanden oder befüllt ist, aber nicht den tatsächlichen Wert
                // Das macht vor allem Sinn bei ID oder Ist-Zeit Angaben
                // .andExcept(MockMvcResultMatchers.jsonPath("$.timestamp").isNotEmpty());
    }
}