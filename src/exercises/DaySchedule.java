package exercises;

import java.util.List;

public class DaySchedule {
    private final Day day;
    private final List<String> activities;

    public DaySchedule(Day day, List<String> activities) {
        this.day = day;
        this.activities = activities;
    }

    public Day getDay() {
        return day;
    }

    public List<String> getActivities() {
        return activities;
    }

    @Override
    public String toString() {
        return "DaySchedule{" +
                "day=" + day +
                ", activities=" + activities +
                '}';
    }
}
