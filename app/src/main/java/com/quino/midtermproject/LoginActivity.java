package com.quino.midtermproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.quino.midtermproject.api.RequestPlaceholder;
import com.quino.midtermproject.api.RetrofitBuilder;
import com.quino.midtermproject.pojos.login;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    public EditText username, password;
    public MaterialButton loginBtn;
    public TextView result;

    public RetrofitBuilder retrofitBuilder;
    public RequestPlaceholder requestPlaceholder;
    //private String token, id, name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);

        retrofitBuilder = new RetrofitBuilder();
        requestPlaceholder = retrofitBuilder.getRetrofit().create(RequestPlaceholder.class);

        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (username.getText() != null && password.getText() != null) {
                    Call<login> loginCall = requestPlaceholder.login(new login(null, username.getText().toString(), null, null, password.getText().toString()));

                    loginCall.enqueue(new Callback<login>() {
                        @Override
                        public void onResponse(Call<login> call, Response<login> response) {
                            if (!response.isSuccessful()) {

                                if(response.code() == 404){
                                    Toast.makeText(LoginActivity.this, "User not found.", Toast.LENGTH_SHORT).show();
                                    Log.e("LOGGING_ERR", response.message());
                                } else {
                                    Toast.makeText(LoginActivity.this, "There was an error upon logging in the API", Toast.LENGTH_SHORT).show();
                                    Log.e("LOGGING_ERR", response.message());
                                }


                            }else {
                                if (response.code() == 200){
                                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<login> call, Throwable t) {

                            Toast.makeText(LoginActivity.this, "There was an error upon logging in the API", Toast.LENGTH_SHORT).show();
                            Log.e( "LOGGING_ERR", t.getMessage());
                        }
                    });

                    }else {
                        Toast.makeText(LoginActivity.this, "Please supply the fields to login!", Toast.LENGTH_SHORT).show();
                    }



            }
        });


    }
}