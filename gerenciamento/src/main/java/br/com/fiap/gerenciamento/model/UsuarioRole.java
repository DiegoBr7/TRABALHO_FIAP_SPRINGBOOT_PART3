package br.com.fiap.gerenciamento.model;

public enum UsuarioRole {

    ADMIN("ADMIN"), USER("USUARIO");

    private String role;

    UsuarioRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}