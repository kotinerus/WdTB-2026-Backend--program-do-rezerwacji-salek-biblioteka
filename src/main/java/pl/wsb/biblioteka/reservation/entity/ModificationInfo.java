package pl.wsb.biblioteka.reservation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

/**
 * Kto i kiedy ostatnio zmienił wiersz. Klasa wbudowana: jej pola są kolumnami tabeli encji, która ją zawiera.
 */
@Embeddable
public class ModificationInfo {

    @Column(name = "modification_date", nullable = false)
    private LocalDateTime modificationDate;

    @Column(name = "modified_by", nullable = false, length = 60)
    private String modifiedBy;

    protected ModificationInfo() {
    }

    public ModificationInfo(LocalDateTime modificationDate, String modifiedBy) {
        this.modificationDate = modificationDate;
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }
}
