package com.clinica.dto;

public class PacienteDTO {
    public record PacienteRequestDTO(String nome, String cpf, String telefone) {}
    public record PacienteResponseDTO(Long id, String nome, String cpf, String telefone) {}
}