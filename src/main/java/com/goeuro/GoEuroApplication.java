package com.goeuro;

import com.goeuro.configs.RestConfig;
import com.goeuro.domain.Location;
import com.goeuro.location.client.LocationClient;
import com.goeuro.service.LocationChecker;
import com.goeuro.utils.CSVFileWriter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.util.Map;

@SpringBootApplication
@Slf4j
public class GoEuroApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(GoEuroApplication.class);
        LocationClient locationClient = ctx.getBean("locationClient", LocationClient.class);
        LocationChecker locationChecker = ctx.getBean("locationChecker", LocationChecker.class);
        CSVFileWriter csvFileWriter = ctx.getBean("CSVFileWriter", CSVFileWriter.class);
        Map<String, String> stringMap = locationChecker.checkInputPrameters(args);
        if (stringMap==null){
            return;
        }

        Location[] response = null;

        try {
            response = locationClient.getResponse(stringMap.get("cityName"));
        } catch (HttpClientErrorException e) {
            log.error(e.getLocalizedMessage());
        }

        try {
            csvFileWriter.generateCsvFile(response, stringMap.get("pathToFile"));
            log.warn("The file creation is successful");
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        }
    }
}


