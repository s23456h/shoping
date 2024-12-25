package com.sk.shoping.shoping.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;
@Entity
@Table(name="order_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orders {
    @Id
    String recordId;
    String taskId;
    Integer partsPrice;
    Integer labourPrice;
    Integer amount;
    String  status;
    List<String> reviewSummary;
    String  createdBy;
    String  updatedBy;
}
