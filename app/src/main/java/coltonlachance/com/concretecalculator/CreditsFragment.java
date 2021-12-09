package coltonlachance.com.concretecalculator;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**CreditsFragment extends Fragment
 * A credits page for ConcreteBuddy app
 * contains a list of attributions that are clickable,
 * showing a small paragraph below the list, describing the source
 * of the attribution.
 */
public class CreditsFragment extends Fragment {

    public TextView DataTypeDesc;
    public ListView list;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreditsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreditsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreditsFragment newInstance(String param1, String param2) {
        CreditsFragment fragment = new CreditsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_credits, container, false);
        DataTypeDesc = (TextView) view.findViewById(R.id.DataTypeDesc);
        list = (ListView) view.findViewById(R.id.dataTypeList);

        ArrayList<DataTypeItem> dataTypeList = new ArrayList<DataTypeItem>();

        dataTypeList.add(new DataTypeItem("Image on homepage","Created using Paint.net."));
        dataTypeList.add(new DataTypeItem("TIP #1 Image", "From https://pixabay.com/photos/dark-rain-windows-glass-windows-1850684/, edited."));
        dataTypeList.add(new DataTypeItem("TIP #2 Image", "From https://pixabay.com/photos/baseball-field-sports-field-1495657/, edited."));
        dataTypeList.add(new DataTypeItem("TIP #3 Image", "From https://pixabay.com/photos/construction-site-construction-worker-3279650/, edited."));
        dataTypeList.add(new DataTypeItem("Concrete Buddy App", "Created solely by Colton LaChance."));

        //ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,dataTypeList);
        CustomAdapter adapter = new CustomAdapter(getContext(), dataTypeList);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataTypeDesc.setText(((DataTypeItem)list.getItemAtPosition(position)).getDesc());
            }
        });

        Button shareButton = view.findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tweet = new Intent(Intent.ACTION_VIEW);
                tweet.setData(Uri.parse("http://twitter.com/?status=" + Uri.encode("This app's great for all concrete related projects!\nCheckout Concrete Buddy!")));
                startActivity(tweet);
            }
        });

        return view;
    }

    /**CustomAdapter extends ArrayAdapter
     * A list adapter for the list of attributions in the credits page
     * @author Colton LaChance
     * */
    public class CustomAdapter extends ArrayAdapter<DataTypeItem> {
        public CustomAdapter(Context context, ArrayList<DataTypeItem> items) {
            super(context,0,items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            DataTypeItem item = getItem(position);

            if (convertView == null) {
                //convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_view,parent,false);
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_item_view,parent,false);
            }

            TextView name = (TextView) convertView.findViewById(R.id.name);
            name.setText(item.getName());
            return convertView;
        }
    }
}