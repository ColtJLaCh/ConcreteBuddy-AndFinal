package coltonlachance.com.concretecalculator;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CustomViewPageAdapter extends FragmentStateAdapter {

    public CustomViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public Fragment createFragment(int position) {
        switch(position) {
            case 0: return VPTipsFragment.newInstance("P1","P2");

            default: return VPTipsFragment.newInstance("NULL","NULL");
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}