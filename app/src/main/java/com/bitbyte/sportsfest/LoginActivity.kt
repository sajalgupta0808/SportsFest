package com.bitbyte.sportsfest

import android.os.Bundle
import android.os.Process
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.android.gms.common.SignInButton
import kotlin.system.exitProcess


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val providers = arrayListOf(AuthUI.IdpConfig.GoogleBuilder().build())
        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
        findViewById<SignInButton>(R.id.google_signin).setOnClickListener{signInLauncher.launch(signInIntent)}
    }

    override fun onBackPressed() {
        val alertDialogBuilder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Exit Application?")
        alertDialogBuilder
            .setCancelable(false)
            .setPositiveButton("Yes"
            ) { _, _ ->
                moveTaskToBack(true)
                Process.killProcess(Process.myPid())
                exitProcess(1)
            }
            .setNegativeButton("No") { dialog, _ -> dialog.cancel() }
        val alertDialog: android.app.AlertDialog? = alertDialogBuilder.create()
        alertDialog?.show()
    }

    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == RESULT_OK) {
            finish()
        } else if(response?.error!!.errorCode!=0){
            val errorMsg = response.error?.localizedMessage
            Toast.makeText(this,errorMsg, Toast.LENGTH_LONG).show()
        }
    }

    private val signInLauncher = registerForActivityResult(FirebaseAuthUIActivityResultContract()){
            res -> this.onSignInResult(res)
    }
}