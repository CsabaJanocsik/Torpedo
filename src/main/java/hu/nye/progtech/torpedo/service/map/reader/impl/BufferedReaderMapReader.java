package hu.nye.progtech.torpedo.service.map.reader.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hu.nye.progtech.torpedo.service.exception.MapReadingException;
import hu.nye.progtech.torpedo.service.map.reader.MapReader;

public class BufferedReaderMapReader implements MapReader {

    private final BufferedReader reader;

    public BufferedReaderMapReader(BufferedReader reader) {
        this.reader = reader;
    }


    @Override
    public List<String> readMap() throws MapReadingException {
        String row;
        List<String> rows = new ArrayList<>();

        try {
            while ((row = reader.readLine()) != null) {
                rows.add(row);
            }
        } catch (IOException e) {
            throw new MapReadingException("Failed to read map");
        }

        return rows;
    }

}