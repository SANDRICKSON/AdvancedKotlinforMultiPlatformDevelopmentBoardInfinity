package com.example.advancedkotlinformulti_platformdevelopmentboardinfinity.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.mmk.kmpauth.google.rememberGoogleAuthState
import com.mmk.kmpauth.uihelper.google.GoogleSignInButton
import dev.gitlive.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

@Composable
fun LoginButtonWrapperMobile(
    modifier: Modifier = Modifier,
    onLogin: (idToken: String) -> Unit,
    onError: (String) -> Unit = {}
) {
    val scope = rememberCoroutineScope()

    // 🔥 Google Auth State - ახალი API 3.0.5
    val googleSignInState = rememberGoogleAuthState(
        linkAccount = false,
        filterByAuthorizedAccounts = false,
        isAutoSelectEnabled = true,
        scopes = listOf("email", "profile"),
        onResult = { result ->
            result.onSuccess { user ->
                // Firebase User-ის მიღება
                val firebaseUser = user.raw as? FirebaseUser

                if (firebaseUser != null) {
                    // ID Token-ის ასინქრონულად მიღება
                    firebaseUser.getIdToken(false)
                        .addOnSuccessListener { tokenResult ->
                            val idToken = tokenResult.token
                            if (!idToken.isNullOrEmpty()) {
                                onLogin(idToken)
                            } else {
                                onError("Failed to get ID token")
                            }
                        }
                        .addOnFailureListener { error ->
                            onError("Failed to get ID token: ${error.message}")
                        }
                } else {
                    onError("Firebase user is null")
                }
            }.onFailure { error ->
                onError("Google Sign-In failed: ${error.message}")
            }
        }
    )

    // 🔘 Google Sign-In Button
    GoogleSignInButton(
        modifier = modifier,
        onClick = {
            scope.launch {
                googleSignInState.launch()
            }
        }
    )
}