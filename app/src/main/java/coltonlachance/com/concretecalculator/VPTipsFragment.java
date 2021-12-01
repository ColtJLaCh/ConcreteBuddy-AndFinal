package coltonlachance.com.concretecalculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**VPTipsFragment
 * The .java class for the fragment_v_p_tips.xml, takes in parameters and using
 * the CustomViewPageAdapter.java, creates a new fragment for the ViewPager2
 * @author Colton LaChance
 */
public class VPTipsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_NUM = "0";
    private static final String ARG_TITLE = "title";
    private static final String ARG_IMG_ID = "id";
    private static final String ARG_DESC = "desc";

    // TODO: Rename and change types of parameters
    private int mNum;
    private String mTitle;
    private int mImgId;
    private String mDesc;

    public VPTipsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param num Parameter 1.
     * @param title Parameter 2.
     * @param imgId Parameter 3.
     * @param desc Parameter 4.
     * @return A new instance of fragment VPTipsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VPTipsFragment newInstance(int num, String title, int imgId, String desc) {
        VPTipsFragment fragment = new VPTipsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_NUM, num);
        args.putString(ARG_TITLE, title);
        args.putInt(ARG_IMG_ID, imgId);
        args.putString(ARG_DESC, desc);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mNum = getArguments().getInt(ARG_NUM);
            mTitle = getArguments().getString(ARG_TITLE);
            mImgId = getArguments().getInt(ARG_IMG_ID);
            mDesc = getArguments().getString(ARG_DESC);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_v_p_tips, container, false);
        TextView tipNumTV = view.findViewById(R.id.tipNumberTV);
        TextView tipTitleTV = view.findViewById(R.id.tipTitleTV);
        ImageView tipIV = view.findViewById(R.id.tipIV);
        TextView tipDescTV = view.findViewById(R.id.tipDescTV);

        if (mTitle != null) tipTitleTV.setText(mTitle);

        String pageNumStr = "Tip #" + mNum;
        if (mNum != 0) tipNumTV.setText(pageNumStr);

        if (mImgId != -1) tipIV.setImageResource(mImgId);

        if (mDesc != null) tipDescTV.setText(mDesc);


        return view;
    }
}