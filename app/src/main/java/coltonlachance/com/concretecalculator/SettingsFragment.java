package coltonlachance.com.concretecalculator;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.preference.Preference;
import androidx.preference.Preference.OnPreferenceClickListener;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }

    Preference feedback = (Preference) findPreference("feedback");
    @Override
    public boolean onPreferenceTreeClick(Preference myPref) {
        if (myPref.getKey().equals("feedback")) {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
            navController.navigate(R.id.nav_listings); //TODO: Change this to contact page
        }
        return super.onPreferenceTreeClick(myPref);
    }
}