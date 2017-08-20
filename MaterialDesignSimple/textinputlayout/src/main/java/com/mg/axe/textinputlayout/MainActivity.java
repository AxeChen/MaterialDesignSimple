package com.mg.axe.textinputlayout;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private TextInputLayout nameInput;
    private EditText edName;

    private TextInputLayout passwordInput;
    private EditText edPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nameInput = (TextInputLayout) findViewById(R.id.tilayoutUserName);
        edName = (EditText) findViewById(R.id.et_name);
        nameInput.setErrorEnabled(true);


        passwordInput = (TextInputLayout) findViewById(R.id.tilayoutPassword);
        passwordInput.setErrorEnabled(true);
        edPassword = (EditText) findViewById(R.id.et_pwd);

        initListener();
    }

    private void initListener() {
        edName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkName(s.toString());
            }
        });
    }

    private void checkName(String s) {
        if (s.length() < 10) {
            nameInput.setError("名字长度太短");
        } else {
            nameInput.setError(null);
        }
    }

    public void login(View view) {
        String password = passwordInput.getEditText().getText().toString();
        if (!TextUtils.isEmpty(password) && password.length() < 10) {
            passwordInput.setError("密码长度太短！");
        } else {
            passwordInput.setError(null);
        }
    }


}
