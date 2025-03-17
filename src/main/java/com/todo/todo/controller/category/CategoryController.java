package com.todo.todo.controller.category;

import com.todo.todo.controller.category.dto.CategoryDTO;
import com.todo.todo.controller.category.dto.CategoryPayload;
import com.todo.todo.controller.task.dto.TaskPayload;
import com.todo.todo.core.category.Category;
import com.todo.todo.core.category.service.CategoryService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("/addCategory")
    public ResponseEntity<Void> addCategory(@Valid @RequestBody CategoryPayload categoryPayload) {
        categoryService.addCategory(categoryPayload);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAllCategorys")
    public ResponseEntity<List<CategoryDTO>> getAllCategorys() {
        return ResponseEntity.ok(categoryService.getAllCategorys());
    }
}
