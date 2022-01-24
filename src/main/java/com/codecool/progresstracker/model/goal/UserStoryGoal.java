package com.codecool.progresstracker.model.goal;

import com.codecool.progresstracker.model.Statuses;
import com.codecool.progresstracker.model.UserStory;

import java.util.Date;
import java.util.UUID;

public class UserStoryGoal extends Goal{

    private UserStory parentStory;

    public UserStoryGoal(){super();}

    public UserStoryGoal(UUID id, String text, Statuses status, Date deadline, UserStory parentStory) {
        super(id, text, status, deadline, GoalType.USER_STORY_GOAL);
        this.parentStory = parentStory;
    }

}
