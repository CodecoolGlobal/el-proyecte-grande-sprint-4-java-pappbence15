package com.codecool.progresstracker.data_sample;

import com.codecool.progresstracker.model.*;
import com.codecool.progresstracker.model.goal.Goal;
import com.codecool.progresstracker.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreateMockData {
    private final UserService userService;
    private final ProjectService projectService;
    private final UserStoryService userStoryService;

    private final SimpleDateFormat dateFormat;

    @Autowired
    public CreateMockData(UserService userService, ProjectService projectService, UserStoryService userStoryService){
        this.userService = userService;
        this.projectService = projectService;
        this.userStoryService = userStoryService;


        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void spamMockData(){

        User user = new User(UserType.PROJECT_OWNER,"John Smith", "John", "john@gmail.com","John123", new UserSettings());
        userService.createNewUser(user);
        userService.createNewUser(new User(UserType.PROJECT_OWNER,"Ruth Gilbert", "Ruth", "ruth@gmail.com", "Ruth123", new UserSettings()));
        userService.createNewUser(new User(UserType.PROJECT_OWNER,"Gillian Medina", "Gillian", "gillian@gmail.com", "Gillian123", new UserSettings()));
        userService.createNewUser(new User(UserType.PROJECT_OWNER,"Travis Hart", "Travis", "travis@gmail.com", "Travis123", new UserSettings()));
        userService.createNewUser(new User(UserType.PROJECT_OWNER,"Sybil Bush", "Sybil", "sybil@gmail.com", "Sybil123", new UserSettings()));

        userService.createNewUser(new User(UserType.ADMIN,"Anna GrossBerg, ", "Anna", "anna@gmail.com", "Anna123", new UserSettings()));
        userService.createNewUser(new User(UserType.ADMIN,"Pat Lawrence", "Pat", "pat@gmail.com", "Pat123", new UserSettings()));
        userService.createNewUser(new User(UserType.ADMIN,"Wren Hodgson", "Wren", "wren@gmail.com", "Wren132", new UserSettings()));
        userService.createNewUser(new User(UserType.ADMIN,"Darren Fraley", "Darren", "darren@gmail.com", "Darren123", new UserSettings()));
        userService.createNewUser(new User(UserType.ADMIN,"Bonnie Briggs", "Bonnie", "bonnie@gmail.com", "Bonnie123", new UserSettings()));



        List<User> userList = userService.getAll();
        List<User> adminList = new ArrayList<>();
        List<UserStory> userStories = new ArrayList<>();
        adminList.add(userList.get(5));
        adminList.add(userList.get(6));

        userService.setLoggedInUser(userList.get(5));//set logged in user

        userStories.add(new UserStory("Security", 0.65, false));
        userStories.add(new UserStory("Front end update", 0.35, true));
        userStories.add(new UserStory("Greeting page", 0.45, true));
        userStories.add(new UserStory("More security", 0.55, false));

        projectService.createNewProject(new Project("Get rid of old plants", userList.get(0), adminList));
        projectService.createNewProject(new Project("Garden renovation", userList.get(0), adminList));
        projectService.createNewProject(new Project("Week-4", userStories, userList.get(0), adminList));
        List<Project> projects = projectService.getAll();


//        projectService.addUserStoryToProject(projects.get(0).getId(), new UserStory("Painting", 0.7, false));
//        projectService.addUserStoryToProject(projects.get(0).getId(), new UserStory("Furnishing", 0.3, false));
//
//        projectService.addUserStoryToProject(projects.get(1).getId(), new UserStory("Get rid of old plants", 0.62, false));
//        projectService.addUserStoryToProject(projects.get(1).getId(), new UserStory("Irrigation system", 0.3, true));
//        projectService.addUserStoryToProject(projects.get(1).getId(), new UserStory("New plants", 0.1, true));


//        goalService.createNewProjectGoal("A csempe megrendel??se", Statuses.IN_PROGRESS, dateFormat.parse("2021-12-15"), projects.get(0));
//
//        goalService.createNewUserStoryGoal("A csempe felhelyez??se", Statuses.NEW, dateFormat.parse("2021-12-15"),
//                projects.get(0).getUserStories().get(0)
//        );
    }
}
