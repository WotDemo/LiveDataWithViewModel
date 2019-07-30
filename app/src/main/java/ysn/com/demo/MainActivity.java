package ysn.com.demo;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import ysn.com.demo.bean.User;
import ysn.com.demo.model.UserModel;
import ysn.com.demo.page.InstanceFragment;

/**
 * @Author yangsanning
 * @ClassName MainActivity
 * @Description 一句话概括作用
 * @Date 2019/7/30
 * @History 2019/7/30 author: description:
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private UserModel userModel;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.main_activity_content);
        getSupportFragmentManager().beginTransaction().replace(
                R.id.main_activity_container, InstanceFragment.newInstance()).commit();

        findViewById(R.id.main_activity_button).setOnClickListener(this);

        userModel = UserModel.get(this)
                .observe(this, new Observer<User>() {
                    @Override
                    public void onChanged(@Nullable User user) {
                        textView.setText(user.toString());
                    }
                });
    }

    @Override
    public void onClick(View view) {
        userModel.setValue(new User("MainActivity", "我来自Activity"));
    }
}
