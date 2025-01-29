package com.example.progresscheckerforcbc;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;
import android.util.Base64;

import java.security.KeyStore;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

import kotlin.text.Charsets;

public class CryptoManager {
    private final KeyStore keyStore;
    private final Context mcontext;
    public CryptoManager(Context context) throws Exception {
        keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        mcontext=context;
    }



    public SecretKey getKey() throws Exception {
        KeyStore.Entry entry = keyStore.getEntry("MySecureKey", null);
        if (entry instanceof KeyStore.SecretKeyEntry) {
            return ((KeyStore.SecretKeyEntry) entry).getSecretKey();
        } else {
            return create_Key();
        }
    }

//    private SecretKey createKey() throws Exception {
//        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
//        keyGenerator.init(
//                new KeyGenParameterSpec.Builder("secret", KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
//                        .setBlockModes(BLOCK_MODE)
//                        .setEncryptionPaddings(PADDING)
//                        .setUserAuthenticationRequired(false)
//                        .setRandomizedEncryptionRequired(true)
//                        .build()
//        );
//        return keyGenerator.generateKey();
//    }

    public byte[] encrypth(String data,SecretKey jk) throws Exception{
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, jk);
        byte[] iv = cipher.getIV(); // Initialization vector

//     byte[] encryptedData = cipher.doFinal(Base64.decode(data,Base64.DEFAULT));
        byte[] encryptedData=cipher.doFinal(data.getBytes(Charsets.ISO_8859_1));
        SharedPreferences pp=mcontext.getSharedPreferences("mytok",MODE_PRIVATE);
        SharedPreferences.Editor editor = pp.edit();
//     editor.putString("encryptedmessage",Base64.encodeToString(encryptedData, Base64.DEFAULT));
        editor.putString("encryptedmessage",new String(encryptedData,Charsets.ISO_8859_1));
        editor.putString("iv", Base64.encodeToString(iv, Base64.DEFAULT));
        // editor.putString("iv",new String(iv,Charsets.ISO_8859_1));
        editor.apply();
        return iv;
    }



    public String decrypt_m(SecretKey kl) throws Exception{
        SharedPreferences jk=mcontext.getSharedPreferences("mytok",MODE_PRIVATE);
        String ivg=jk.getString("iv","");
        String encryptedData=jk.getString("encryptedmessage","");
        byte[] iv= Base64.decode(ivg,Base64.DEFAULT);
//       byte[] iv=ivg.getBytes(Charsets.ISO_8859_1);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.DECRYPT_MODE, kl, spec);
        // SharedPreferences jk=getSharedPreferences("mytok",MODE_PRIVATE);

//       byte[] decryptedData = cipher.doFinal(Base64.decode(encryptedData,Base64.DEFAULT));
        byte[] decryptedData = cipher.doFinal(encryptedData.getBytes(Charsets.ISO_8859_1));
//       return Base64.encodeToString(decryptedData, Base64.DEFAULT);
        return new String(decryptedData,Charsets.ISO_8859_1);
    }



    private SecretKey create_Key() throws Exception{
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES);
        keyGenerator.init(
                new KeyGenParameterSpec.Builder("MySecureKey",
                        KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                        .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                        .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                        .setUserAuthenticationRequired(false)
                        .build()
        );
        return keyGenerator.generateKey();
    }

}
