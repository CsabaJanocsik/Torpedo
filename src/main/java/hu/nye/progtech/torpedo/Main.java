package hu.nye.progtech.torpedo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import hu.nye.progtech.torpedo.service.exception.MapReadingException;
import hu.nye.progtech.torpedo.service.map.reader.MapReader;
import hu.nye.progtech.torpedo.service.map.reader.impl.BufferedReaderMapReader;

public class Main {

    public static void main(String[] args){

        String playerName;
        Scanner input = new Scanner(System.in);

        System.out.println("Name:");
        playerName = input.nextLine();

        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("map/playerMap");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        MapReader mapReader = new BufferedReaderMapReader(reader);

        try{
            List<String> playerString = mapReader.readMap();
            for (String element : playerString)
                System.out.println(element);
        } catch (MapReadingException e) {
            e.printStackTrace();
        }

    }

}