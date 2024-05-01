package org.example.springdata.components.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CategoryController {

    private final Scanner scanner;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(Scanner scanner, CategoryRepository categoryRepository) {
        this.scanner = scanner;
        this.categoryRepository = categoryRepository;
    }


    public void createCategory() {
        Category category = readCategory();
        try {
            categoryRepository.save(category);
            System.out.println("Dodano kategorię");
            System.out.println(category);
        } catch (DataIntegrityViolationException e) {
            System.err.println("Nie dodano kategorii, możliwe, że nazwa jest już użyta");
        }
    }

    private Category readCategory() {
        Category category = new Category();
        System.out.println("Podaj nazwę kategorii:");
        category.setName(scanner.nextLine());
        System.out.println("Podaj opis kategorii:");
        category.setDescription(scanner.nextLine());
        return category;
    }

    public void removeCategory() {
        System.out.println("Podaj id kategorii, którą chcesz usunąć:");
        long categoryId = scanner.nextLong();
        Optional<Category> category = categoryRepository.findById(categoryId);
        category.ifPresentOrElse(categoryRepository::delete, () -> System.out.println("Brak kategorii o wskazanym ID"));
    }
}
