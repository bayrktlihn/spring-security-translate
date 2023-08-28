package io.bayrktlihn.springapp.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseEntity {

    private boolean active = true;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime passiveDate;


    @PrePersist
    void prePersist() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    void preUpdate() {
        updatedDate = LocalDateTime.now();
    }


    public void makePassive() {
        active = false;
        passiveDate = LocalDateTime.now();
    }


    public boolean isPassive(){
        return !isActive();
    }


}
