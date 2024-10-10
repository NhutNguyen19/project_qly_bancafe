package project.duan.qlybancafe.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    LocalDateTime checkIn;
    LocalDateTime checkOut;

    String status;

    @ManyToOne(fetch = FetchType.EAGER)
    TableFood table;

    double discount;
    double totalPrice;
}
