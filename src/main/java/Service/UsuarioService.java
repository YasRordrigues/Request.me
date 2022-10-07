package Service;

import lombok.Builder;
import org.springframework.stereotype.Service;
import repository.UsuarioRepository;
import request.models.Usuario;

import javax.persistence.*;
import java.util.List;

@Table(name = "resquest", schema = "public")
@Service
public class UsuarioService extends Usuario {
    UsuarioRepository usuarioRepository;

    public Usuario criaUsuario(Usuario user) {
        usuarioRepository.save(user);
        return user;
    }

    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    public void deletaUsuario(Usuario Id){

        usuarioRepository.deleteById(Id.getId());
    }
}
