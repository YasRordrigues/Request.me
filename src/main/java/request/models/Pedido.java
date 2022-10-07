package request.models;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    private Long id;

    private String box;
}
