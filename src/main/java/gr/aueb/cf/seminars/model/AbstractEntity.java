package gr.aueb.cf.seminars.model;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity implements IdentifiableEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Override
    public Long getId() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
