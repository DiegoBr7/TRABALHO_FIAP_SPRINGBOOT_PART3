package br.com.fiap.gerenciamento.service;

import br.com.fiap.gerenciamento.model.Usuario;
import br.com.fiap.gerenciamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {

        String encodedPassword = new BCryptPasswordEncoder().encode(usuario.getPassword());
        usuario.setPassword(encodedPassword);

        return usuarioRepository.save(usuario);
    }


    //______________________________________________________________________________________________________________

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public void deleteUsuario(Long id) {

        Optional<Usuario> UsuarioOp = usuarioRepository.findById(id);
        if (UsuarioOp.isPresent()) {
            usuarioRepository.delete(UsuarioOp.get());
        } else {
            throw  new RuntimeException("Usuario não encontrado");
        }
}
}
