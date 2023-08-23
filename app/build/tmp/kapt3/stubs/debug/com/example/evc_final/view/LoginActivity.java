package com.example.evc_final.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000  2\u00020\u0001:\u0001 B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\u0012\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/example/evc_final/view/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/evc_final/databinding/ActivityLoginBinding;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "googleLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "isEmailOk", "", "isPasswordOk", "sharedPreferences", "Landroid/content/SharedPreferences;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupViews", "signInFirebaseWithEmail", "email", "", "password", "signInWithEmailPassword", "signInWithGoogle", "signUpWithEmailPassword", "signinFirebaseWithGoogle", "idToken", "validarContrase\u00f1a", "validarEmail", "validateInput", "Companion", "app_debug"})
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.evc_final.databinding.ActivityLoginBinding binding;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> googleLauncher;
    private com.google.firebase.auth.FirebaseAuth firebaseAuth;
    private android.content.SharedPreferences sharedPreferences;
    private boolean isEmailOk = false;
    private boolean isPasswordOk = false;
    @org.jetbrains.annotations.NotNull
    public static final com.example.evc_final.view.LoginActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SESSION_PREFERENCE = "SESSION_PREFERENCES";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String EMAIL = "EMAIL";
    
    public LoginActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void signinFirebaseWithGoogle(java.lang.String idToken) {
    }
    
    private final void setupViews() {
    }
    
    private final void signUpWithEmailPassword() {
    }
    
    private final void signInWithEmailPassword() {
    }
    
    private final void signInFirebaseWithEmail(java.lang.String email, java.lang.String password) {
    }
    
    private final void signInWithGoogle() {
    }
    
    private final void validarEmail(java.lang.String email) {
    }
    
    private final void validarContraseña(java.lang.String password) {
    }
    
    private final boolean validateInput(java.lang.String email, java.lang.String password) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/evc_final/view/LoginActivity$Companion;", "", "()V", "EMAIL", "", "SESSION_PREFERENCE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}