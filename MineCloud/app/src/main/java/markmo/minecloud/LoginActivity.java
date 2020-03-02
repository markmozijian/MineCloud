package markmo.minecloud;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.exception.BmobException;

public class LoginActivity extends Activity {

    private Button mlogin,mregi;
    private EditText mname,mpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mname=(EditText) findViewById(R.id.etUsername);
        mpassword=(EditText) findViewById(R.id.etPassword);
        mlogin=(Button) findViewById(R.id.btn_login);
        mregi=(Button) findViewById(R.id.btn_sign);
    }

    //注册点击
    public void dregi(View view){
        Intent intentlogin = new Intent();
        intentlogin.setClass(LoginActivity.this,SignActivity.class);
        startActivity(intentlogin);

    }

    //登录点击
    public void dlogin(View view){
        String name=mname.getText().toString();
        String password=mpassword.getText().toString();
        if(name.equals("")||password.equals("")){
            Toast.makeText(this, "帐号或密码不能为空", Toast.LENGTH_LONG).show();
            return;
        }
        BmobQuery<user> query=new BmobQuery<user>();
        query.addWhereEqualTo("name", name);
        query.addWhereEqualTo("password", password);
        query.findObjects(new FindListener<user>() {

            @Override
            public void done(List<user> arg0, BmobException e) {
                // TODO Auto-generated method stub
                if (e == null) {
                    String gname = arg0.get(0).getName().toString();
                    String gpassword = arg0.get(0).getPassword().toString();
                    String name = mname.getText().toString();
                    String password = mpassword.getText().toString();
                    Toast.makeText(LoginActivity.this, gname+"，欢迎回来", Toast.LENGTH_LONG).show();
                    if (gname.equals(name) && gpassword.equals(password)) {
                        Intent seccess = new Intent();
                        seccess.setClass(LoginActivity.this, MainOneActivity.class);
                        startActivity(seccess);
                    }

                } else {
                    Toast.makeText(LoginActivity.this, "帐号或密码有误", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
