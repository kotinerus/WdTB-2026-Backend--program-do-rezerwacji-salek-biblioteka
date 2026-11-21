# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 8 (w tym tabele łączące @ManyToMany: room_equipment) · kolumny: 41 · relacje: 4 × @ManyToOne, 1 × @OneToMany, 1 × @OneToOne, 1 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| building | Building | 5 | — |
| equipment | Equipment | 5 | — |
| library_card | LibraryCard | 6 | user_account_id |
| notification | Notification | 5 | user_account_id |
| reservation | Reservation | 9 | room_id, user_account_id |
| room | Room | 6 | building_id |
| user_account | UserAccount | 5 | — |

```mermaid
erDiagram
    building {
        Long id PK
        String address
        String city
        String name
        String postal_code
    }
    equipment {
        Long id PK
        boolean active
        String category
        String inventory_number
        String name
    }
    library_card {
        Long id PK
        boolean active
        String card_number
        LocalDate expires_at
        LocalDate issued_at
        Long user_account_id FK
    }
    notification {
        Long id PK
        LocalDateTime created_at
        String message
        String template
        Long user_account_id FK
    }
    reservation {
        Long id PK
        LocalDateTime end_time
        LocalDateTime modification_date
        String modified_by
        String note
        Long room_id FK
        LocalDateTime start_time
        ReservationStatus status
        Long user_account_id FK
    }
    room {
        Long id PK
        Long building_id FK
        int capacity
        int floor
        String name
        RoomType room_type
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    building ||--o{ room : "building_id"
    room ||--o{ reservation : "room_id"
    room }o--o{ equipment : "room_equipment"
    user_account ||--o{ notification : "user_account_id"
    user_account ||--o{ reservation : "user_account_id"
    user_account ||--o| library_card : "user_account_id"
```
