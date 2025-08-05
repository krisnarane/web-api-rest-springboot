package br.com.krisnarane.webApi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.krisnarane.webApi.handler.BusinessException;
import br.com.krisnarane.webApi.model.Usuario;

@Repository
public class UsuarioRepository {
    private List<Usuario> usuarios = new ArrayList<>();
    private Integer nextId = 1;
    
    public Usuario save(Usuario usuario){
        if(usuario.getLogin() == null) {
            throw new BusinessException("Login é obrigatório");
        }
        
        if (usuario.getId() == null) {
            // Novo usuário
            usuario.setId(nextId++);
            usuarios.add(usuario);
        } else {
            // Atualizar usuário existente
            usuarios.removeIf(u -> u.getId().equals(usuario.getId()));
            usuarios.add(usuario);
        }
        
        System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        System.out.println(usuario);
        return usuario;
    }
    
    public void deleteById(Integer id){
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));
        usuarios.removeIf(u -> u.getId().equals(id));
    }
    
    public List<Usuario> findAll(){
        System.out.println("LIST - Listando os usuários do sistema");
        if (usuarios.isEmpty()) {
            // Dados de exemplo
            Usuario user1 = new Usuario("julia", "password");
            user1.setId(1);
            Usuario user2 = new Usuario("jukia", "masterpass");
            user2.setId(2);
            usuarios.add(user1);
            usuarios.add(user2);
            nextId = 3;
        }
        return new ArrayList<>(usuarios);
    }
    
    public Optional<Usuario> findById(Integer id){
        return usuarios.stream()
            .filter(u -> u.getId() != null && u.getId().equals(id))
            .findFirst();
    }

    public Optional<Usuario> findByUsername(String username){
        return usuarios.stream()
            .filter(u -> u.getLogin() != null && u.getLogin().equals(username))
            .findFirst();
    }
}
