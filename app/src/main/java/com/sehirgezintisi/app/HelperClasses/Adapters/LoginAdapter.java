package com.sehirgezintisi.app.HelperClasses.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.sehirgezintisi.app.Common.LoginSignUp.LoginFragment;
import com.sehirgezintisi.app.Common.LoginSignUp.SignUpFragment;

public class LoginAdapter extends FragmentStateAdapter {

    public LoginAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if (position == 0) {
            return new LoginFragment();
        }
        else {
            return new SignUpFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
