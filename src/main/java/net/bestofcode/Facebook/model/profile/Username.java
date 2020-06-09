package net.bestofcode.Facebook.model.profile;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Username implements Credential{

    private String username;

    public Username(String error) {
        this.username = error;
    }

    @Override
    public String getValue() {
        return username;
    }
}
