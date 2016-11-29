package com.goeuro.utils;

import au.com.bytecode.opencsv.CSVWriter;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.goeuro.domain.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author July on 28.11.2016.
 * @project GoEuroTest
 */
@Component
@Slf4j
public class CSVFileWriter {

    public void generateCsvFile(Location[] locations, String pathToFile) throws IOException {

        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(Location.class);

        ObjectWriter writer = mapper.writer(schema.withLineSeparator("\n"));

        if (pathToFile == null){
            pathToFile = "locations.csv";
        }

        writer.writeValue(new File(pathToFile),locations);

    }
}
