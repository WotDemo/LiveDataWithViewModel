package ysn.com.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ysn.com.demo.page.simple.SimpleActivity;

/**
 * @Author yangsanning
 * @ClassName MainActivity
 * @Description 一句话概括作用
 * @Date 2019/7/30
 * @History 2019/7/30 author: description:
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.main_activity_simple).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_activity_simple:
                startActivity(SimpleActivity.class);
                break;
            default:
                break;
        }
    }

    private void startActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
