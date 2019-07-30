package ysn.com.demo.page;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ysn.com.demo.R;
import ysn.com.demo.bean.User;
import ysn.com.demo.model.UserModel;

/**
 * @Author yangsanning
 * @ClassName InstanceFragment
 * @Description 一句话概括作用
 * @Date 2019/7/30
 * @History 2019/7/30 author: description:
 */
public class InstanceFragment extends Fragment implements View.OnClickListener {

    private UserModel userModel;

    private TextView textView;

    public static InstanceFragment newInstance() {
        Bundle args = new Bundle();
        InstanceFragment fragment = new InstanceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_instance, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.instance_fragment_content);
        view.findViewById(R.id.instance_fragment_button).setOnClickListener(this);

        userModel = UserModel.get(getActivity())
                .observe(this, new Observer<User>() {
                    @Override
                    public void onChanged(@Nullable User user) {
                        textView.setText(user.toString());
                    }
                });
    }

    @Override
    public void onClick(View view) {
        userModel.postValue(new User("InstanceFragment", "我来自Fragment"));
    }
}
