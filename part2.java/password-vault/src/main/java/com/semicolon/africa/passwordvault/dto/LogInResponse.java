package com.semicolon.africa.passwordvault.dto;
import com.semicolon.africa.passwordvault.models.ValuablesInVault;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
@Data
public class LogInResponse {
    private List<ValuablesInVault> usersValuables = new ArrayList<>();
    private String username;
    private boolean isActive;
}
