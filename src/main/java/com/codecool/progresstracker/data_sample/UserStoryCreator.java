package com.codecool.progresstracker.data_sample;

import com.codecool.progresstracker.dao.UserStoryDao;
import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.UserStory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class UserStoryCreator {

    private final UserStoryDao userStoryDao;

    @Autowired
    public UserStoryCreator(UserStoryDao userStoryDao) {
        this.userStoryDao = userStoryDao;
    }

    public void initialize(Project project, String name, boolean isFavourite, double currentPercent) {
        UserStory userStory = new UserStory(
                UUID.randomUUID(),
                name,
                currentPercent,
                isFavourite,
                new ArrayList<>()
        );

        userStoryDao.add(userStory);
        project.addStory(userStory);
    }
}
