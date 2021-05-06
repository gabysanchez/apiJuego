package com.gabysanchez.apiJuego.encryptors;

public class EncryptionCesar {
    private static EncryptionCesar encryptionCesar = null;
    private static int cypher = 5;

    private EncryptionCesar(){}
    public static EncryptionCesar getInstance()  {
        if(encryptionCesar == null){
            encryptionCesar = new EncryptionCesar();
        }
        return encryptionCesar;
    }


    public String ecode(String text) {
        StringBuilder cifrado = new StringBuilder();
        cypher = cypher % 26;
        for (int i = 0; i < text.length(); i++) {
            int i1 = text.charAt(i) + cypher - 26;
            if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
                if ((text.charAt(i) + cypher) > 'z') {
                    cifrado.append((char) i1);
                } else {
                    cifrado.append((char) (text.charAt(i) + cypher));
                }
            } else if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') {
                if ((text.charAt(i) + cypher) > 'Z') {
                    cifrado.append((char) i1);
                } else {
                    cifrado.append((char) (text.charAt(i) + cypher));
                }
            }
        }
        return cifrado.toString();
    }


    public String decode(String text) {
        StringBuilder cifrado = new StringBuilder();
        cypher = cypher % 26;
        for (int i = 0; i < text.length(); i++) {
            int i1 = text.charAt(i) - cypher + 26;
            if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
                if ((text.charAt(i) - cypher) < 'a') {
                    cifrado.append((char) i1);
                } else {
                    cifrado.append((char) (text.charAt(i) - cypher));
                }
            } else if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') {
                if ((text.charAt(i) - cypher) < 'A') {
                    cifrado.append((char) i1);
                } else {
                    cifrado.append((char) (text.charAt(i) - cypher));
                }
            }
        }
        return cifrado.toString();
    }
}
