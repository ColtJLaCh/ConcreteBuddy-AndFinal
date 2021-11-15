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
            case 0: return VPTipsFragment.newInstance(position+1,"Check The Weather!",R.drawable.normalbagofconcrete,"Always check the weather ahead of time to see when the best days to set your concrete would be.\n Remember!\nWhether or not your concrete sets properly is mostly based on the weather!");
            case 1: return VPTipsFragment.newInstance(position+1,"Clear out the bubbles!",R.drawable.normalbagofconcrete,"After pouring your concrete, grab yourself a rake or something similar and push and swish the concrete around to get out any air bubbles that would otherwise weaken the after setting.");
            case 2: return VPTipsFragment.newInstance(position+1,"Get multiple people for the job!",R.drawable.normalbagofconcrete,"It may seem easier to just do it all yourself, but having multiple people there to help not only speeds up the process, but makes it more likely you get your concrete set properly! Especially when using ready-mix concrete.");
            default: return VPTipsFragment.newInstance(0,"NULL",R.drawable.normalbagofconcrete,"NULL");
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}