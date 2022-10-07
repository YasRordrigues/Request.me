package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import request.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
