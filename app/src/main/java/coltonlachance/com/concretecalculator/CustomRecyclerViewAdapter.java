package coltonlachance.com.concretecalculator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**CustomRecyclerViewAdapter
 * Used to hold list of concrete listings in a recycler view
 * @author Colton LaChance
 */
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter {

    private ArrayList<Listings> myListings;

    public CustomRecyclerViewAdapter(ArrayList<Listings> myListings) {
        this.myListings = myListings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,null,false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final Listings listings = myListings.get(position);
        final CustomViewHolder holder1 = (CustomViewHolder) holder;
        holder1.name.setText((listings.getName()));
        holder1.description.setText((listings.getDefinition()));
        holder1.price.setText((listings.getPrice()));
    }

    @Override
    public int getItemCount() {
        System.out.println("MY LISTINGS SIZE : " + myListings.size());
        return myListings.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;
        protected TextView description;
        protected TextView price;


        public CustomViewHolder(View view) {
            super(view);
            this.name = view.findViewById(R.id.name);
            this.description = view.findViewById(R.id.description);
            this.price = view.findViewById(R.id.price);
        }
    }
}
