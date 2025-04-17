package triage;

import triage.enums.MedicalUnitsEnum;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        try {
            final int index = checkArgIsValid(args);
            triagePatientFromIndex(index);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void triagePatientFromIndex(int index) {
        String result = Stream.of(MedicalUnitsEnum.values())
                .filter(unit -> index % unit.getIndex() == 0)
                .map(MedicalUnitsEnum::getName)
                .collect(Collectors.joining(", "));

        System.out.println(result + ".");
    }

    public static Integer checkArgIsValid(String[] args) {
        try {
            return Integer.parseInt(args[0]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Argument must be an integer");
        }
    }
}