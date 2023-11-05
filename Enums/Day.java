package Enums;

public enum Day {
        MONDAY(1),
        TUESDAY(2),
        WEDNESDAY(3),
        THURSDAY(4),
        FRIDAY(5),
        SATURDAY(6),
        SUNDAY(7);

    private int day;

    private Day(int day){
        this.day = day;
    }

    public int getDay(){
        return this.day;
    }
}
