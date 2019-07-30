package ysn.com.demo.page.simple;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import ysn.com.demo.R;
import ysn.com.demo.bean.User;
import ysn.com.demo.model.UserModel;
import ysn.com.demo.page.SimpleFragment;

/**
 * @Author yangsanning
 * @ClassName SimpleActivity
 * @Description 一句话概括作用
 * @Date 2019/7/30
 * @History 2019/7/30 author: description:
 */
public class SimpleActivity extends AppCompatActivity implements View.OnClickListener {

    private UserModel userModel;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        setTitle(R.string.text_simple);

        textView = findViewById(R.id.simple_activity_content);
        getSupportFragmentManager().beginTransaction().replace(
                R.id.simple_activity_container, SimpleFragment.newInstance()).commit();

        userModel = UserModel.get(this)
                .observe(this, new Observer<User>() {
                    @Override
                    public void onChanged(@Nullable User user) {
                        textView.setText(user.toString());
                    }
                });

        findViewById(R.id.simple_activity_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        userModel.setValue(new User("SimpleActivity", "我来自Activity"));
    }
}