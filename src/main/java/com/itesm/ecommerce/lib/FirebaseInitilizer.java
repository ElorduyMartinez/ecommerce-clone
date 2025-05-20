package com.itesm.ecommerce.lib;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import io.quarkus.runtime.Startup;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.FileInputStream;
import java.io.IOException;

@ApplicationScoped
@Startup
public class FirebaseInitilizer {
    @PostConstruct
    public void init() throws IOException {
        if(FirebaseApp.getApps().isEmpty()){
            try {
                FileInputStream serviceAccount = new FileInputStream("src/main/resources/ecommercegrupo1-firebase-adminsdk-fbsvc-a20a0a8783.json");
                FirebaseOptions options= FirebaseOptions.builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .build();
                FirebaseApp.initializeApp(options);
                System.out.println("Firebase initialized successfully");
            } catch (Exception e) {
                throw new RuntimeException("Failed to initialize Firebase", e);
            }
        }
    }
}
