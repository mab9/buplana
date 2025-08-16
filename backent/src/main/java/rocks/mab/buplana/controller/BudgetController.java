package rocks.mab.buplana.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocks.mab.buplana.model.Budget;
import rocks.mab.buplana.service.BudgetService;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "budgets")
@RequiredArgsConstructor
public class BudgetController {

    private final BudgetService budgetService;

    @GetMapping
    public ResponseEntity<List<Budget>> getBudgets() {
        return ResponseEntity.ok(budgetService.findAll());
    }

    @GetMapping("/{budgetId}")
    public ResponseEntity<Budget> getBudget(@PathVariable Long budgetId) {
        return ResponseEntity.ok(budgetService.findById(budgetId));
    }

    @PostMapping
    public ResponseEntity<Budget> createBudget(@Valid @RequestBody Budget budget) {
        Budget created = budgetService.create(budget);
        URI location = URI.create("/budgets/" + created.getId());
        return ResponseEntity.created(location).body(created);
    }


    @PutMapping("/{budgetId}")
    public ResponseEntity<Budget> updateBudget(@PathVariable Long budgetId, @Valid @RequestBody Budget budget) {
        return ResponseEntity.ok(budgetService.update(budgetId, budget));
    }

    @DeleteMapping("/{budgetId}")
    public ResponseEntity<Void> deleteBudget(@PathVariable Long budgetId) {
        budgetService.delete(budgetId);
        return ResponseEntity.noContent().build();
    }
}
