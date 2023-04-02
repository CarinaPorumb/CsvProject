package project;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final String PATH = "src/main/resources/Players.csv";

    public static void main(String[] args) throws IOException, CsvValidationException {

        readDataSc();
        readDataFromCSV(PATH);
        System.out.println(readData());
        System.out.println(readDataLineByLine());
    }

    public static List<Player> readData() {
        try {
            return new CsvToBeanBuilder<Player>(new FileReader(PATH))
                    .withType(Player.class)
                    .withSkipLines(1)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static List<Player> readDataLineByLine() {
        List<Player> playerList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(PATH);
             CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build()) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                Player player = new Player(Integer.parseInt(nextRecord[0]), nextRecord[1], nextRecord[2], Integer.parseInt(nextRecord[3]), Integer.parseInt(nextRecord[4]));
                playerList.add(player);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return playerList;
    }

    public static void readDataSc() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(PATH));
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            System.out.print(scanner.next() + " ");
        }
        scanner.close();
    }

    public static void readDataFromCSV(String fileName) throws IOException, CsvValidationException {
        FileReader fileReader = new FileReader(fileName);
        CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
        String[] players;
        while ((players = csvReader.readNext()) != null) {
            for (String cell : players) {
                System.out.print(cell + ", ");
            }
            System.out.println();
        }
    }
}