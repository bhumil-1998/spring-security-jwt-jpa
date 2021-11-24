package com.example.springsecurityjwtjpa.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public List<Todo> getTodoByUserName(String userName) {
        return todoRepository.findByUsername(userName);
    }

    public Todo getTodoById(Long id) {
        Optional<Todo> todos = todoRepository.findById(id);
        return todos.orElse(null);
    }

    public Todo addTodoDetail(TodoRequestDTO todoRequestDTO) {
        Todo todo = new Todo();

        todo.setUsername(todoRequestDTO.getUserName());
        todo.setTargetDate(todoRequestDTO.getTargetDate());
        todo.setDescription(todoRequestDTO.getDescription());
        todo.setDone(todoRequestDTO.getIsDone());

        return todoRepository.save(todo);

    }
}
