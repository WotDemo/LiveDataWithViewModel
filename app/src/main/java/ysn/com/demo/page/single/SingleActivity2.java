package ysn.com.demo.page.single;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import ysn.com.demo.R;
import ysn.com.demo.bean.User;
import ysn.com.demo.model.SingleUserModel;

/**
 * @Author yangsanning
 * @ClassName SingleActivity1
 * @Description 一句话概括作用
 * @Date 2019/7/30
 * @History 2019/7/30 author: description:
 */
public class SingleActivity2 extends AppCompatActivity implements View.OnClickListener {

    SingleUserModel viewModel;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single2);

        setTitle(R.string.text_single);

        textView = findViewById(R.id.single2_activity_content);

        viewModel = SingleUserModel.get(this).observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                Log.d("test", "SingleActivity2-onChanged: " + user.toString());
                textView.setText(user.toString());
            }
        });

        findViewById(R.id.single2_activity_refresh).setOnClickListener(this);
        findViewById(R.id.single2_activity_close).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.single2_activity_refresh:
                viewModel.setValue(new User("SingleActivity2", "我来自SingleActivity2"));
                break;
            case R.id.single2_activity_close:
                finish();
                break;
            default:
                break;
        }
    }
}