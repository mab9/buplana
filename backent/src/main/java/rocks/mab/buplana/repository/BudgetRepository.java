package rocks.mab.buplana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rocks.mab.buplana.model.Budget;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
}