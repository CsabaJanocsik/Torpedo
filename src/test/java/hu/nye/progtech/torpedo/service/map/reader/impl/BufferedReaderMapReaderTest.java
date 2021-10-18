package hu.nye.progtech.torpedo.service.map.reader.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.doThrow;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import hu.nye.progtech.torpedo.service.exception.MapReadingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BufferedReaderMapReaderTest {

    private static final String LINE_1 = "line_1";
    private static final String LINE_2 = "line_2";

    @Mock
    private BufferedReader reader;

    private BufferedReaderMapReader underTest;

    @BeforeEach
    public void setUp() {
        underTest = new BufferedReaderMapReader(reader);
    }

    @Test
    public void testReadMapShouldReturnReadLinesFromBufferedReader() throws MapReadingException, IOException {
        //given
        given(reader.readLine()).willReturn(LINE_1, LINE_2, null);

        //when
        List<String> result = underTest.readMap();

        //then
        assertEquals(List.of(LINE_1,LINE_2),result);
    }

    @Test
    public void testReadMapShouldThrowMapReadingExceptionWhenMapReadingFails() throws IOException {
        //given
        doThrow(IOException.class).when(reader).readLine();

        //when - then
        assertThrows(MapReadingException.class, () -> {
            underTest.readMap();
        });
    }

}
