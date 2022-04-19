package br.antony.todoapi.services;

import br.antony.todoapi.models.Task;
import br.antony.todoapi.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void create(Task taskEntity) {
        taskEntity.setId(null);
        taskEntity.setChecked(false);
        taskRepository.save(taskEntity);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public void update(Task taskEntity) {
        taskRepository.save(taskEntity);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public void deleteAll() {
        taskRepository.deleteAll();
    }
}
