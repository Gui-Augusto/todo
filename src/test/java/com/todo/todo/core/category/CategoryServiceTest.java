package com.todo.todo.core.category;

import com.todo.todo.controller.category.dto.CategoryDTO;
import com.todo.todo.controller.category.dto.CategoryPayload;
import com.todo.todo.core.category.service.CategoryService;
import com.todo.todo.repository.category.ICategoryRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    ICategoryRepository categoryRepository;

    @InjectMocks
    CategoryService categoryService;

    @Test
    void testGetAllCategorys() {
        List<Category> categories = new ArrayList();
        ObjectId objectId = new ObjectId("64e1b6a7c9a8b7b1c2d3e4f5"); // Example ObjectId

        Category category1 = Category.builder()
                .id("64e1b6a7c9a8b7b1c2d3e4f5")
                .name("Category 1")
                .description("Description 1")
                .owner(objectId)
                .build();

        Category category2 = Category.builder()
                .id("64e1b6a7c9a8b7b1c2d3e4f5")
                .name("Category 2")
                .description("Description 2")
                .owner(objectId)
                .build();

        categories.add(category1);
        categories.add(category2);

        when(categoryRepository.findAll()).thenReturn(categories);

        List<CategoryDTO> categoryDTOs = categoryService.getAllCategorys();

        assertEquals(2, categoryDTOs.size());
        assertEquals("Category 1", categoryDTOs.get(0).getName());
        assertEquals("Category 2", categoryDTOs.get(1).getName());
        assertEquals(objectId.toString(), categoryDTOs.get(0).getIdUser());
    }

    @Test
    void testAddCategory() {
        CategoryPayload categoryPayload = CategoryPayload.builder()
                .name("Test Category")
                .description("Test Description")
                .idUser("64e1b6a7c9a8b7b1c2d3e4f5")
                .build();

        Category category = Category.builder()
                .name("Test Category")
                .description("Test Description")
                .owner(new ObjectId("64e1b6a7c9a8b7b1c2d3e4f5"))
                .build();

        categoryService.addCategory(categoryPayload);

        verify(categoryRepository).insert(category);
    }
}
