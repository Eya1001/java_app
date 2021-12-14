package services;

import models.entities.Course;
import models.repositories.CourseRepository;
import models.repositories.Repository;

public class CourseService extends Service<Course> {

    public CourseService() {
        super();
        this.repository = new CourseRepository();
    }
}
