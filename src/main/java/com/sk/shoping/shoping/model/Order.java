package com.sk.shoping.shoping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class Order {
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
