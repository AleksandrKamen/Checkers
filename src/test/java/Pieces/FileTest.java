package Pieces;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    @Test
    void fromChar() {
        List<File> files = new ArrayList<>();
        for (int i = 65; i <= 72; i++) {
            files.add(File.fromChar((char) i));

            
        }
        
        assertAll(
                ()-> assertThat(files).isEqualTo(List.of(File.A, File.B, File.C, File.D, File.E,File.F, File.G,File.H)),
                ()-> assertNull(File.fromChar('a')),
                ()-> assertNull(File.fromChar('b')),
                ()-> assertNull(File.fromChar('c')),
                ()-> assertNull(File.fromChar('d')),
                ()-> assertNull(File.fromChar('e')),
                ()-> assertNull(File.fromChar('f')),
                ()-> assertNull(File.fromChar('g')),
                ()-> assertNull(File.fromChar('h')),
                ()-> assertNull(File.fromChar('.')),
                ()-> assertNull(File.fromChar('P')),
                ()-> assertNull(File.fromChar('!')),
                ()-> assertNull(File.fromChar(' ')),
                ()-> assertNull(File.fromChar('1'))

        );

        }


   }
