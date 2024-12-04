package com.job_portal.exceptions;

import java.io.Serial;

public class JobPortalException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public JobPortalException(String message) {
        super(message);
    }
}
