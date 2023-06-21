package com.example.springdemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class ActivityDatabase {
    private List<Activity> activityList = new ArrayList<>();

    private int activityIndex = 1;

    public List<Activity> getActivityList(Integer priority, String name) {
        if (priority == null && name == null) {
            return activityList;
        }
        List<Activity> filteredActivities = new ArrayList<>();
        for (Activity activity : activityList) {
            if (name == null && activity.getPriority().equals(priority)
                    || priority == null && activity.getName().equals(name)
                    || activity.getPriority().equals(priority) && activity.getName().equals(name)
            ) {
                filteredActivities.add(activity);
            }
        }
        return filteredActivities;
    }

    public void addActivity(Activity activity) {
        activity.setId(activityIndex);
        activityIndex++;
        activityList.add(activity);
    }

    public void deleteActivities() {
        activityList.clear();
    }

    public Activity getActivity(Integer id) {
        for (Activity activity : activityList) {
            if (activity.getId().equals(id)) {
                return activity;
            }
        }
        return null;
    }

    public Boolean deleteActivity(Integer id) {
        Activity activityToDelete = null;
        for (Activity activity : activityList) {
            if (activity.getId().equals(id)) {
                activityToDelete = activity;
            }
        }

        if (activityToDelete == null) {
            return false;
        }
        activityList.remove(activityToDelete);
        return true;
    }
}
