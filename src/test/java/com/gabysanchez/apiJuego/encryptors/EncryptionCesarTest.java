package com.gabysanchez.apiJuego.encryptors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptionCesarTest {

    @Test
    void ecode() {
        String expected = "password";
        System.out.println(EncryptionCesar.getInstance().ecode(expected));

    }

    @Test
    void decode() {
        String expected = "ufxxbtwi";
        System.out.println(EncryptionCesar.getInstance().decode(expected));
    }
}