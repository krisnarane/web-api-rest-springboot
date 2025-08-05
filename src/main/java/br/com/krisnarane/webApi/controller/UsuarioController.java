package br.com.krisnarane.webApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.krisnarane.webApi.model.Usuario;
import br.com.krisnarane.webApi.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/users") // atribui /users para todos, prefixo
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    @GetMapping("/users")
    public List<Usuario>getUsers(){
        return repository.findAll();
    }

    @GetMapping("/{username}")
    public Usuario getOne(@PathVariable("username")  String username){
        return repository.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(Integer id){
         repository.deleteById(id);
    }

    @PostMapping()     // implicitamente tem o /users
    public void postUser(@RequestBody Usuario usuario){
        repository.save(usuario);
    }
}
