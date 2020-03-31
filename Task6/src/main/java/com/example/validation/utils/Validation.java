package com.example.validation.utils;

import com.example.validation.utils.ValidatingAnnotation;

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
