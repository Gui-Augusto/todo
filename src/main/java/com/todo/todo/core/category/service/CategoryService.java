package com.todo.todo.core.category.service;

import com.todo.todo.controller.category.dto.CategoryDTO;
import com.todo.todo.controller.category.dto.CategoryPayload;
import com.todo.todo.controller.task.dto.TaskPayload;
import com.todo.todo.core.category.Category;
import com.todo.todo.core.task.Task;
import com.todo.todo.core.user.User;
import com.todo.todo.core.user.service.UserService;
import com.todo.todo.repository.category.ICategoryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    public List<CategoryDTO> getAllCategorys() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(category -> CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .idUser(category.getOwner().toString())
                .build()).toList();
    }

    public void addCategory(CategoryPayload categoryPayload) {
        Category category = Category.builder()
                .name(categoryPayload.getName())
                .description(categoryPayload.getDescription())
                .owner(new ObjectId(categoryPayload.getIdUser()))
                .build();
        categoryRepository.insert(category);
    }
}
