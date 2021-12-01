package coltonlachance.com.concretecalculator;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**CustomViewPageAdapter
 * An adapter for a viewpager2
 * @author Colton LaChance
 */
public class CustomViewPageAdapter extends FragmentStateAdapter {

    public CustomViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public Fragment createFragment(int position) {
        switch(position) {
            case 0: return VPTipsFragment.newInstance(position+1,"Check The Weather!",R.drawable.rainoutside,"Always check the weather ahead of time to see when the best days to set your concrete would be.\n\nRemember!\n\nWhether or not your concrete sets properly is mostly based on the weather!");
            case 1: return VPTipsFragment.newInstance(position+1,"Clear out the bubbles!",R.drawable.rakeconcrete,"After pouring your concrete,\ngrab yourself a rake or something similar.\n\nSwish the concrete around to get out any air bubbles that would otherwise weaken the after setting!");
            case 2: return VPTipsFragment.newInstance(position+1,"Get multiple people for the job!",R.drawable.construction,"Although it may seem easier to just do it all yourself...\n\nHaving multiple people there to assist you will speed up the progress, \n\nMakes it more likely you get your concrete set properly!\n\nThese are especially when using ready-mix concrete.");
            default: return VPTipsFragment.newInstance(0,"NULL",R.drawable.normalbagofconcrete,"NULL");
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}