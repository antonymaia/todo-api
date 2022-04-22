package br.antony.todoapi.controllers;

import br.antony.todoapi.dtos.TaskDto;
import br.antony.todoapi.models.TaskModel;
import br.antony.todoapi.services.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController()
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/task")
public class TaskController{

    @Autowired
    private TaskService taskService;

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody @Valid TaskDto taskDto){
        TaskModel taskModel = new TaskModel();
        BeanUtils.copyProperties(taskDto, taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(taskModel));
    }

    @GetMapping()
    public ResponseEntity<List<TaskModel>> findAll(){
        List<TaskModel> taskList = taskService.findAll();
        return ResponseEntity.ok(taskList);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody TaskDto taskDto){
        TaskModel taskModel = new TaskModel();
        BeanUtils.copyProperties(taskDto, taskModel);
        taskModel.setId(id);
        taskService.update(taskModel);
        return ResponseEntity.status(HttpStatus.OK).body(taskService.update(taskModel));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id){
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteAll(){
        taskService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
