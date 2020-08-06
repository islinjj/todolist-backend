package com.ita.todolist.repository;

import com.ita.todolist.entity.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author LINVI7
 * @Date 8/6/2020 6:57 PM
 * @Version 1.0
 */
@Repository
public interface ToDoItemRepository extends JpaRepository<ToDoItem,Integer> {

}
