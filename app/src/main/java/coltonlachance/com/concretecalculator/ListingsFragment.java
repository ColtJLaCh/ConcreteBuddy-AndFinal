package coltonlachance.com.concretecalculator;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListingsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecyclerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListingsFragment newInstance(String param1, String param2) {
        ListingsFragment fragment = new ListingsFragment();
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
        View view = inflater.inflate(R.layout.fragment_listings, container, false);
        ArrayList<Listings> listings = new ArrayList<Listings>();
        listings.add(new Listings("Bag Of Premixed", "A 4oz bag of pre-mixed concrete.", "19.99"));
        listings.add(new Listings("Bag Of Regular", "A 4oz bag of regular strength concrete.", "35.00"));
        listings.add(new Listings("Concrete Block SLIGHTLY CHIPPED", "Found these two concrete blocks in my back yard, trying to get rid of them.", "10.00"));
        listings.add(new Listings("Concrete Lovin' by Lil Sandman", "Topping 30th on the worlds most obscure hip-hop artists you should know about, comes Lil Sandmans new album.", "18.99"));
        listings.add(new Listings("5 bags of concrete", "Bought these for my porch, not gonna use them.", "50.00"));
        listings.add(new Listings("Concrete - EXTRA STRENGTH", "An 8oz bag of extra strength", "70.99"));
        listings.add(new Listings("HIRE ME - CONCRETE", "Give me a call, I'll come by to your house and do your concrete!", "0.00"));
        listings.add(new Listings("Bag of concrete, fiber glass mix.", "A 4oz bag of fiber glass strengthened concrete.", "29.99"));
        listings.add(new Listings("SLABS", "I got 30+ slabs I want to get rid of, real cheap!", "2.50"));

        Button listingsButton = view.findViewById(R.id.listingsButton);
        listingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "concrete listings");
                startActivity(intent);
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);

        CustomRecyclerViewAdapter adapter = new CustomRecyclerViewAdapter(listings);
        recyclerView.setAdapter(adapter);

        return view;
    }
}