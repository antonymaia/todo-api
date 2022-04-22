package br.antony.todoapi.services;

import br.antony.todoapi.models.TaskModel;
import br.antony.todoapi.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public TaskModel create(TaskModel taskEntity) {
        taskEntity.setChecked(false);
        return taskRepository.save(taskEntity);
    }

    public List<TaskModel> findAll() {
        return taskRepository.findAll();
    }

    public TaskModel update(TaskModel taskModel) {
        return taskRepository.save(taskModel);
    }

    public void delete(UUID id) {
        taskRepository.deleteById(id);
    }

    public void deleteAll() {
        taskRepository.deleteAll();
    }
}
