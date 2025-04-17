package triage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import triage.enums.MedicalUnitsEnum;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @BeforeEach
    public void resetOutputStream() {
        outContent.reset();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.0", "string", ""})
    @NullSource
    void checkInputArgsTest_invalidValues(String value) {
        assertThrows(IllegalArgumentException.class, () -> Main.checkArgIsValid(new String[]{value}));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "545486", "-1"})
    void checkInputArgsTest_validValues(String value) {
        assertDoesNotThrow(() -> Main.checkArgIsValid(new String[]{value}));
    }

    @Test
    void checkIndexForTraumatologieTest(){
        Main.triagePatientFromIndex(55);
        assertEquals(MedicalUnitsEnum.TRAUMATOLOGIE.getName() + ".", outContent.toString().trim());
    }

    @Test
    void checkIndexForCardiologieTest(){
        Main.triagePatientFromIndex(33);
        assertEquals(MedicalUnitsEnum.CARDIOLOGIE.getName() + ".", outContent.toString().trim());
    }

    @Test
    void checkIndexForTraumatologieAndCardiologieTest(){
        Main.triagePatientFromIndex(15);
        assertEquals(MedicalUnitsEnum.CARDIOLOGIE.getName() + ", " + MedicalUnitsEnum.TRAUMATOLOGIE.getName() + ".",
                outContent.toString().trim());
    }
}