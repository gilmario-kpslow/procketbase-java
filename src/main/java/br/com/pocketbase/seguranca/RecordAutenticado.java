/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pocketbase.seguranca;

import br.com.pocketbase.generic.RecordModel;
import java.time.LocalDateTime;

/**
 *
 * @author gilmario
 */
public class RecordAutenticado extends RecordModel {

    private LocalDateTime created;
    private String email;
    private boolean emailVisibility;
    private LocalDateTime updated;
    private boolean verified;

    public RecordAutenticado() {
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailVisibility() {
        return emailVisibility;
    }

    public void setEmailVisibility(boolean emailVisibility) {
        this.emailVisibility = emailVisibility;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

}
