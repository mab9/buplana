package rocks.mab.buplana.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocks.mab.buplana.model.Budget;
import rocks.mab.buplana.repository.BudgetRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }

    public Budget findById(Long budgetId) {
        return budgetRepository.findById(budgetId)
                .orElseThrow(() -> new EntityNotFoundException("Budget not found: " + budgetId));
    }

    @Transactional
    public Budget create(Budget budget) {
        return budgetRepository.save(budget);
    }

    @Transactional
    public Budget update(Long budgetId, Budget budget) {
        Budget existing = findById(budgetId);
        existing.setName(budget.getName());
        existing.setExpenses(budget.getExpenses());
        return budgetRepository.save(existing);
    }

    @Transactional
    public void delete(Long budgetId) {
        if (!budgetRepository.existsById(budgetId)) {
            throw new EntityNotFoundException("Budget not found: " + budgetId);
        }
        budgetRepository.deleteById(budgetId);
    }
}
