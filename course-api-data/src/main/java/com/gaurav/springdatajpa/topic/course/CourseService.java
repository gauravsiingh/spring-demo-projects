package com.gaurav.springdatajpa.topic.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	/*
	private List<Topic> topics = new ArrayList<Topic>(
			Arrays.asList(new Topic("spring", "Spring Framework", "Spring Framework Description"),
					new Topic("java", "Core Java", "Core Java Description"),
					new Topic("javascript", "Javascript", "Javascript Description")));*/

	public List<Course> getAllCourses(String Id) {
		List<Course> course = new ArrayList<>();
		
		courseRepository.findAll().forEach(course :: add);
		
		return course;
	}

	public Optional<Course> getCourseById(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		return courseRepository.findById(id);

	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourseById(Course course, String id) {
		/*for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}*/
		
		courseRepository.save(course);

	}

	public void deleteCourseById(Course course, String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		
		courseRepository.deleteById(id);
	}
}
