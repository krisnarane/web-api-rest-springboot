package br.com.krisnarane.webApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.krisnarane.webApi.handler.BusinessException;
import br.com.krisnarane.webApi.model.Usuario;
import br.com.krisnarane.webApi.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;
    
    public List<Usuario> findAll() {
        return repository.findAll();
    }
    
    public Usuario findById(Integer id) {
        Optional<Usuario> usuario = repository.findById(id);
        if (usuario.isEmpty()) {
            throw new BusinessException("Usuário não encontrado com ID: %d", id);
        }
        return usuario.get();
    }
    
    public Usuario findByUsername(String username) {
        Optional<Usuario> usuario = repository.findByUsername(username);
        if (usuario.isEmpty()) {
            throw new BusinessException("Usuário não encontrado com username: %s", username);
        }
        return usuario.get();
    }
    
    public Usuario save(Usuario usuario) {
        if (usuario.getLogin() == null || usuario.getLogin().trim().isEmpty()) {
            throw new BusinessException("Login é obrigatório");
        }
        
        if (usuario.getPassword() == null || usuario.getPassword().trim().isEmpty()) {
            throw new BusinessException("Password é obrigatório");
        }
        
        // Verificar se já existe usuário com mesmo login
        try {
            findByUsername(usuario.getLogin());
            throw new BusinessException("Já existe um usuário com o login: %s", usuario.getLogin());
        } catch (BusinessException e) {
            // Se não encontrou, pode continuar
            if (!e.getMessage().contains("não encontrado")) {
                throw e;
            }
        }
        
        return repository.save(usuario);
    }
    
    public Usuario update(Usuario usuario) {
        if (usuario.getId() == null) {
            throw new BusinessException("ID é obrigatório para atualização");
        }
        
        // Verificar se existe
        findById(usuario.getId());
        
        if (usuario.getLogin() == null || usuario.getLogin().trim().isEmpty()) {
            throw new BusinessException("Login é obrigatório");
        }
        
        if (usuario.getPassword() == null || usuario.getPassword().trim().isEmpty()) {
            throw new BusinessException("Password é obrigatório");
        }
        
        return repository.save(usuario);
    }
    
    public void deleteById(Integer id) {
        // Verificar se existe antes de deletar
        findById(id);
        repository.deleteById(id);
    }
}
