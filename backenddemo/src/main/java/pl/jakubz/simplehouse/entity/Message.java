package pl.jakubz.simplehouse.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Table(
        name = "messages"
)
@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private int id;
    @Size(
            min = 3,
            max = 40,
            message = "Has to be between 3-40"
    )
    @NotBlank(
            message = "is requiered"
    )
    @Column(
            name = "name"
    )
    private String name;
    @Email
    @NotBlank(
            message = "is requiered"
    )
    @Column(
            name = "email"
    )
    private String email;
    @Size(
            message = "has to be at least 20 long and shorter than 255",
            min = 20,
            max = 255
    )
    @NotBlank(
            message = "is requiered"
    )
    @Column(
            name = "message"
    )
    private String messageText;
    @Column(
            name = "is_read"
    )
    private boolean isRead;

}