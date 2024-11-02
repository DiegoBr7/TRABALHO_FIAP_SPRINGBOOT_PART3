package br.com.fiap.gerenciamento.controller;

import br.com.fiap.gerenciamento.model.Usuario;
import br.com.fiap.gerenciamento.security.service.TokenService;
import br.com.fiap.gerenciamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    AuthenticationManager authenticationManager ;

    @Autowired
    TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Usuario usuario){

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        usuario.getEmail() ,
                        usuario.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

String token = tokenService.createToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(token);
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario register(@RequestBody Usuario usuario){
        Usuario newUsuario = usuarioService.save(usuario);
        return newUsuario;
    }

//--------------------------------------------------------------------------------------------------------------------------

    @GetMapping("/buscar")
    public List<Usuario> getAllUsers(){
        return usuarioService.getAllUsuarios();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
    }

//--------------------------------------------------------------------------------------------------------------------------------
}
