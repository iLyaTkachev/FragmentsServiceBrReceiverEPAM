package ilyatkachev.github.com.fragmentsservicesbrreceiverepam;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ilyatkachev.github.com.fragmentsservicesbrreceiverepam.fragments.Fragment1;
import ilyatkachev.github.com.fragmentsservicesbrreceiverepam.fragments.Fragment2;

public class FragmentsActivity extends AppCompatActivity implements Fragment1.onSomeEventListener {

    Fragment1 frag1;
    FragmentTransaction fTrans;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);
        initView();
    }

    private void initView() {
        frag1 = new Fragment1();
        replaceFragmentInContainer(R.id.fragments_cont, frag1, false);
    }

    private void replaceFragmentInContainer(int pI, Fragment pFragment, boolean pAddToBackStack) {
        fTrans = getFragmentManager().beginTransaction();
        fTrans.replace(pI, pFragment);
        if (pAddToBackStack) {
            fTrans.addToBackStack(null);
        }
        fTrans.commit();
    }

    @Override
    public void sendResult(String s) {
        Bundle bundle = new Bundle();
        bundle.putString(getString(R.string.key_for_result_string),s);
        Fragment2 frag2 = new Fragment2();
        frag2.setArguments(bundle);
        replaceFragmentInContainer(R.id.fragments_cont, frag2, true);
    }
}
