package com.apexion.domain;

public enum AccountStatus {

    PENDING_VERIFICATION, // Acount created but not verified by admin
    ACTIVE, // Account is active and in good standing
    SUSPENDED, // Account is suspended possible due to violation
    DEACTIVATED, // Account is deactivated
    BANNED, // Account Permanenlty banned due to servere violations
    CLOSED // Account permanenlty closed at user request

}
