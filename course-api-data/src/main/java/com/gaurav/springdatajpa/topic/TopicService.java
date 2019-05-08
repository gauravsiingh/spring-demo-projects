package com.gaurav.springdatajpa.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicsRepository topicsRepository;
	/*
	private List<Topic> topics = new ArrayList<Topic>(
			Arrays.asList(new Topic("spring", "Spring Framework", "Spring Framework Description"),
					new Topic("java", "Core Java", "Core Java Description"),
					new Topic("javascript", "Javascript", "Javascript Description")));*/

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		
		topicsRepository.findAll().forEach(topics :: add);
		
		return topics;
	}

	public Optional<Topic> getTopicById(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		return topicsRepository.findById(id);

	}

	public void addTopic(Topic topic) {
		topicsRepository.save(topic);
	}

	public void updateTopicById(Topic topic, String id) {
		/*for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}*/
		
		topicsRepository.save(topic);

	}

	public void deleteTopicById(Topic topic, String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		
		topicsRepository.deleteById(id);
	}
}
