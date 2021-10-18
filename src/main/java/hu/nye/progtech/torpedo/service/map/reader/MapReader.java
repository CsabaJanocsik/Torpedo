package hu.nye.progtech.torpedo.service.map.reader;

import java.util.List;

import hu.nye.progtech.torpedo.service.exception.MapReadingException;

public interface MapReader {

    List<String> readMap() throws MapReadingException;

}