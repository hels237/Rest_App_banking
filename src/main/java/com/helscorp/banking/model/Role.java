package com.helscorp.banking.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role extends AbstractEntity{

    private String name ;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user ;

}
