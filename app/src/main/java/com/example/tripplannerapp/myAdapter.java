/** ================================================================================================*/
/** FILE               : myAdapter.java                                                            */
/** PROJECT            : Trip Planner App (Assignment 2)                                            */
/** PROGRAMMER         : Ermiyas (Endalkachew) Gulti                                                */
/** FIRST VERSION      : 2024-March-14                                                              */
/** DESCRIPTION        : This file contains the implementation of the RecyclerView adapter used     */
/**                    : in the Trip Planner app. The adapter is responsible for binding data to    */
/**                    : the RecyclerView and creating ViewHolders as needed.It uses custom interface,*/
/**                    : RecyclerViewInterface, to handle interactions with RecyclerView items.     */
/**=================================================================================================*/

package com.example.tripplannerapp;

// imports
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/**
 * Adapter class for populating a RecyclerView with items representing food items in the Trip Planner app.
 */
public class myAdapter extends RecyclerView.Adapter<myViewHolder> {
    private final  RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<Items> itemList;

    /**
     * Constructor for myAdapter.
     *
     * @param context               The context in which the adapter is being used.
     * @param itemList              The list of items to be displayed in the RecyclerView.
     * @param recyclerViewInterface The interface for handling RecyclerView item interactions.
     */
    public myAdapter(Context context, ArrayList<Items> itemList,  RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.itemList = itemList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #onBindViewHolder(ViewHolder, int, List)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(ViewHolder, int)
     */
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        // Create a new instance of myViewHolder with the RecyclerViewInterface parameter
        return new myViewHolder(itemView, recyclerViewInterface);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link ViewHolder#getBindingAdapterPosition()} which
     * will have the updated adapter position.
     * <p>
     * Override {@link #onBindViewHolder(ViewHolder, int, List)} instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.foodNameTextView.setText(itemList.get(position).getFoodName());
        holder.foodDescriptionTextView.setText(itemList.get(position).getFoodDescription());
        holder.mealCategoriesTextView.setText(itemList.get(position).getMealCategories());
        holder.foodPriceTextView.setText(String.valueOf(itemList.get(position).getFoodPrice()));
        holder.foodImageView.setImageResource(itemList.get(position).getFoodImage());
        holder.preparationTimeTextView.setText(String.valueOf(itemList.get(position).getPreparationTimeMinutes()));
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return itemList.size();
    }


}
