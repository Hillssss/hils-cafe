package org.hillsss.model.base;

import org.hibernate.annotations.UpdateTimestamp;
import org.hillsss.model.base.CreatedBase;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class UpdatedBase extends CreatedBase {
    @Column (name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}

