package com.clinica.service;

import com.clinica.dto.PacienteDTO.PacienteRequestDTO;
import com.clinica.dto.PacienteDTO.PacienteResponseDTO;
import com.clinica.model.Paciente;
import com.clinica.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public List<PacienteResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(p -> new PacienteResponseDTO(p.getId(), p.getNome(), p.getCpf(), p.getTelefone()))
                .collect(Collectors.toList());
    }

    public PacienteResponseDTO salvar(PacienteRequestDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setNome(dto.nome());
        paciente.setCpf(dto.cpf());
        paciente.setTelefone(dto.telefone());
        
        Paciente salvo = repository.save(paciente);
        return new PacienteResponseDTO(salvo.getId(), salvo.getNome(), salvo.getCpf(), salvo.getTelefone());
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
