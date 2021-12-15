package com.codecool.progresstracker.data_sample;

import com.codecool.progresstracker.dao.UserStoryDao;
import com.codecool.progresstracker.model.Project;
import com.codecool.progresstracker.model.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserStoryCreator {

    private final UserStoryDao userStoryDao;
    private final int BASE_STATUS = 0;

    @Autowired
    public UserStoryCreator(UserStoryDao userStoryDao) {
        this.userStoryDao = userStoryDao;
    }

    public void initialize(Project project, String name, int max_progress, int currentProgress, boolean isFavourite) {
        UserStory userStory = new UserStory(
                UUID.randomUUID(),
                name,
                max_progress,
                currentProgress,
                this.BASE_STATUS,
                isFavourite
        );

        userStoryDao.add(userStory);
        project.addStory(userStory);
    }
}
