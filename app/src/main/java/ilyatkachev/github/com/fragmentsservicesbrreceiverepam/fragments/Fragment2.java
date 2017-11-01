package ilyatkachev.github.com.fragmentsservicesbrreceiverepam.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ilyatkachev.github.com.fragmentsservicesbrreceiverepam.R;

public class Fragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, null);
        String resultText = getArguments().getString("resultString");
        TextView resTextView = view.findViewById(R.id.result_textView);
        resTextView.setText(resultText);
        return view;
    }
}
