package ru.nsu.fit.g18213.tromenshleger;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

class JSONParser {

    Employees readParameters(File parameters) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(parameters, Employees.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
