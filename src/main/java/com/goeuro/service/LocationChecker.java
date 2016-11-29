package com.goeuro.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author July on 28.11.2016.
 * @project GoEuro
 */
@Component
@Slf4j
public class LocationChecker {

    public Map<String, String> checkInputPrameters(String[] args){
        String cityName = null;
        String pathToFile = null;

        Map<String, String> stringMap = new HashMap<>();

		if(args.length >= 2){
			cityName = args[0];
			pathToFile = args[1];
			if (pathToFile == null || pathToFile==" "){
				log.warn("You have enter path to file parameter in correct way! Please, enter path to file! \n " +
						"For info type: \n " +
						"-jar \"filename\".jar /help");
				return null;
			}
		}else if(args.length == 1){
			cityName = args[0];
		}

		if(cityName == null || cityName==" "){
			log.warn("Please, enter city name! \n " +
                    "For info type: \n " +
					"-jar \"filename\".jar /help");
			return null;
		}

		if(pathToFile == null || pathToFile==" "){
			log.warn("Please, enter path to file! \n " +
					"For info type: \n " +
					"-jar \"filename\".jar /help");
			return null;
		}

		if(args[0].equals("help") || args[0].equals("/help")){
			showHelp();
			return null;
		}

		stringMap.put("cityName", cityName);
		stringMap.put("pathToFile", pathToFile);

        return stringMap;
    }

        public static void showHelp() {
        System.out.println("Please, enter parameters like this: \n\n" +
                "-jar \"filename\".jar \"CITY_NAME\"\n\n" +
                "Also you are able to specify the path for the file. \n" +
                "To do this just enter it next the city name: \n\n" +
                "-jar \"filename\".jar \"CITY_NAME\" \"PATH_TO_FILE\"");
    }

}
