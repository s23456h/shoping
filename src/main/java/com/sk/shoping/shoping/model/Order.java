package com.sk.shoping.shoping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    String id;
    String recordId;
    String taskId;
    Integer partsPrice;
    Integer labourPrice;
    Integer amount;

}
