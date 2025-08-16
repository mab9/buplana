package rocks.mab.buplana.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "budget")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "budget_id")
    private Long id;

    @NotBlank
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy = "budget", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @JsonIgnore
    private Set<Expense> expenses = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    @ToString.Exclude
    @JsonIgnore
    private User user;

    // Convenience
    public void addExpense(Expense e){ expenses.add(e); e.setBudget(this); }
    public void removeExpense(Expense e){ expenses.remove(e); e.setBudget(null); }

}