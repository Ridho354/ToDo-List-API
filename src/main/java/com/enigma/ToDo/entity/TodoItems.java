package com.enigma.ToDo.entity;

import com.enigma.ToDo.constant.Constant;
import com.enigma.ToDo.constant.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = Constant.table_todo)
public class TodoItems {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name="title", nullable=false)
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="due_date")
    private String dueDate;
    
    @Column(name="status", nullable=false)
    private Status status;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
}
