package com.example.dialogbox;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 演示各种对话框
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 用户自定义对话框
     *
     * @param view
     */
    public void onCustomDialogButtonClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        // 创建一个view，并且将布局加入view中
        final View viewDialog = LayoutInflater.from(MainActivity.this).inflate(R.layout.customdialog, null, false);
        builder.setTitle("登录")
                .setView(viewDialog)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //取得用户输入内容，注意findViewById前面的viewDialog，表示在该view里面进行查找
                        EditText editTextUserId = viewDialog.findViewById(R.id.edittext_user_id);
                        EditText editTextUserPassword = viewDialog.findViewById(R.id.edittext_user_password);
                        if(editTextUserId.getText().toString().equals("abc") && editTextUserPassword.getText().toString().equals("123"))
                            Toast.makeText(MainActivity.this, "登陆成功" , Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "登陆失败" , Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.create().show();
    }
}