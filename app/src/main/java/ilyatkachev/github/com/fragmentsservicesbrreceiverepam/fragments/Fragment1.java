package ilyatkachev.github.com.fragmentsservicesbrreceiverepam.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import ilyatkachev.github.com.fragmentsservicesbrreceiverepam.R;

public class Fragment1 extends Fragment {

    private EditText mMessageEditText;

    public interface onSomeEventListener {

        void sendResult(String s);
    }

    onSomeEventListener someEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            someEventListener = (onSomeEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, null);
        mMessageEditText = view.findViewById(R.id.string_edit_text);

        view.findViewById(R.id.send_button).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                someEventListener.sendResult(mMessageEditText.getText().toString());
            }
        });
        return view;
    }
}
