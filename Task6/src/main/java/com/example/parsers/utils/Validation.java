package com.example.parsers.utils;

public class Validation {
    boolean valid;
    @ValidatingAnnotation()

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
