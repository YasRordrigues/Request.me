package request.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario{
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    private String password;
}
