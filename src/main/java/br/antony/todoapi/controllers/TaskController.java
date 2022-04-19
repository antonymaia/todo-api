package br.antony.todoapi.controllers;

import br.antony.todoapi.models.Task;
import br.antony.todoapi.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController()
@RequestMapping("/task")
public class TaskController{

    @Autowired
    private TaskService taskService;

    @GetMapping()
    public ResponseEntity<List<Task>> findAll(){
        List<Task> taskList = taskService.findAll();
        return ResponseEntity.ok(taskList);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody Task taskEntity){
        taskService.create(taskEntity);
        return ResponseEntity.created(null).build();
    }

    @PutMapping()
    public ResponseEntity<Void> update(@RequestBody Task taskEntity){
        taskService.update(taskEntity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteAll(){
        taskService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
