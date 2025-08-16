package rocks.mab.buplana.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "tag")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "tag_id")
    private Long id;

    @NotBlank
    @Column(name = "name", nullable = false, length = 20)
    private String name; // beliebige Bezeichnung, auch bei FIXED/VARIABLE

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tag_type", nullable = false, length = 20)
    private TagType tagType;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_id")
    private User user; // null = global/vordefinierter Tag

}