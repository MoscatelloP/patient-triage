package triage.enums;

public enum MedicalUnitsEnum {

    CARDIOLOGIE(3, "Cardiologie"),
    TRAUMATOLOGIE(5, "Traumatologie");

    private final int index;
    private final String name;

    MedicalUnitsEnum(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
