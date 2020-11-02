package exercises;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayPlanner {
    private final List<DaySchedule> daySchedules;

    public DayPlanner(List<DaySchedule> daySchedules) {
        this.daySchedules = daySchedules;
    }

    public void addActivity(Day day, String activity) {

        for (DaySchedule daySchedule : daySchedules) {
            if (activity == null) {
                throw new NoActivityException("That is not an activity");
            } else if (daySchedule.getDay() == day) {
                daySchedule.getActivities().add(activity);
            }
        }
    }

    public void removeActivity(Day day, String activity) {
        for (DaySchedule daySchedule : daySchedules) {
            if (daySchedule.getDay() == day) {
                if (daySchedule.getActivities().contains(activity)) {
                    daySchedule.getActivities().remove(activity);
                } else {
                    throw new NoActivityException("This activity is not in the activities list");
                }


            }
        }
    }

    public List<String> getActivities(Day day) {
        for (DaySchedule daySchedule : daySchedules) {
            if (daySchedule.getDay() == day) {
                return daySchedule.getActivities();
            }
        }
        return null;
    }

    public List<DaySchedule> getDaySchedules() {
        return daySchedules;
    }

    public void printPlanner() {
        for (DaySchedule daySchedule : daySchedules) {
            System.out.println(daySchedule);
        }
    }

    public Map<Day, List<String>> endPlanning(Day day) throws NoActivityForDayException {
        Map<Day, List<String>> result = new HashMap<>();

        for (DaySchedule daySchedule : daySchedules) {
            if (daySchedule.getDay() == day) {
                if (daySchedule.getActivities() == null) {
                    throw new NoActivityForDayException(daySchedule.getDay() + " ->  No activities for this day");
                }
                result.put(daySchedule.getDay(), daySchedule.getActivities());


            }
        }
        return result;
    }
}
