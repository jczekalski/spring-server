package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping
public class TestApi {
    @Autowired
    private ActivityDatabase activityDatabase;

    @PostMapping(value = "activities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addActivity(@RequestBody Activity activity) {
        activityDatabase.addActivity(activity);
    }

    @GetMapping(value = "activities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Activity> getActivities(
            @Nullable @RequestParam("priority") Integer priority,
            @Nullable @RequestParam("name") String name
    ) {
        return activityDatabase.getActivityList(priority, name);
    }

    @GetMapping(value = "activities/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getActivity(@PathVariable("id") Integer id) {
        Activity activity = activityDatabase.getActivity(id);

        if (activity == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(activity);
    }

    @DeleteMapping(value = "activities/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteActivity(@PathVariable("id") Integer id) {
        if (activityDatabase.deleteActivity(id)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "activities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteActivities() {
        activityDatabase.deleteActivities();
    }
}