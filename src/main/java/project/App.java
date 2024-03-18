package project;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class App {

    private static final String PATH = "src/main/resources/Players.csv";
    public static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException, CsvValidationException {

        LOGGER.info("Starting CSV parsing demo...");

        List<Player> playersFromCsv = parseCsvToPlayers();
        LOGGER.info("Parsed Players from CSV: {}", playersFromCsv);

        LOGGER.info("Parsed Players Line by Line: {}", parseCsvToPlayersLineByLine());

        printCsvContentWithScanner();

        printCsvContent(PATH);

        LOGGER.info("CSV parsing demo completed.");

    }

    public static List<Player> parseCsvToPlayers() {
        try {
            LOGGER.info("Parsing CSV to Player objects.");
            return new CsvToBeanBuilder<Player>(new FileReader(PATH))
                    .withType(Player.class)
                    .withSkipLines(1)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            LOGGER.error("The file was not found: {}", e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    public static List<Player> parseCsvToPlayersLineByLine() {
        LOGGER.info("Parsing CSV to Player objects line by line...");
        List<Player> playerList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(PATH);
             CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build()) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                Player player = new Player(Integer.parseInt(nextRecord[0]), nextRecord[1], nextRecord[2], Integer.parseInt(nextRecord[3]), Integer.parseInt(nextRecord[4]));
                playerList.add(player);
            }
        } catch (Exception e) {
            LOGGER.error("Error occurred while parsing CSV: {}", e.getMessage(), e);
        }
        return playerList;
    }

    public static void printCsvContentWithScanner() {
        LOGGER.info("Printing CSV content using Scanner...");
        try (Scanner scanner = new Scanner(new File(PATH))) {
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                LOGGER.info(scanner.next() + " ");
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("CSV file not found: {}", e.getMessage(), e);
        }
    }

    public static void printCsvContent(String fileName) throws IOException, CsvValidationException {
        LOGGER.info("Printing CSV content line by line...");
        try (FileReader fileReader = new FileReader(fileName);
             CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build()) {
            String[] players;
            while ((players = csvReader.readNext()) != null) {
                for (String cell : players) {
                    LOGGER.info(cell + ", ");
                }
                LOGGER.info("");
            }
        }
    }

}