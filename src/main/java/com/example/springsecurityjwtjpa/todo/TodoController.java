package com.example.springsecurityjwtjpa.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin(origins = "*")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(method = RequestMethod.GET, value = "/user/todos")
    public ResponseEntity<?> getAllTodos(@RequestParam String userName) {
        return ResponseEntity.ok(todoService.getTodoByUserName(userName));
    }

    @GetMapping("/user/todos/{id}")
    public ResponseEntity<?> getTodo( @PathVariable long id){
        return ResponseEntity.ok(todoService.getTodoById(id));
    }

    @PostMapping("/user/todos")
    public ResponseEntity<Void> createTodo(@RequestBody TodoRequestDTO todoRequestDTO){
        Todo createdTodo = todoService.addTodoDetail(todoRequestDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
