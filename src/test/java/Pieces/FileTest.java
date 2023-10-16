package Pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

class FileTest {

    @ParameterizedTest
    @ValueSource(chars = {'a','b','c','d','e','f','g','h','1',' ','T','э','P','p','W','M','U',','})
    @DisplayName("File is null, if invalid value for fromChar()")
    void InvalidValueForFile(char ch){
        assertNull(File.fromChar(ch));
    }
    @ParameterizedTest
    @ValueSource(chars = {'A','B','C','D','E','F','G','H'})
    void ValidValueforFile(char ch){
        assertNotNull(File.fromChar(ch));
    }

   }
