package sg.edu.rp.c346.mymovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 17010617 on 25/7/2018.
 */

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Data> dataList;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Data> objects) {
        super(context, resource, objects);
        this.parent_context = context;
        this.layout_id = resource;
        this.dataList = objects;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvDetails = rowView.findViewById(R.id.tvDetails);
        ImageView rating = rowView.findViewById(R.id.imageView);

        Data currentMovie = dataList.get(position);
        tvTitle.setText(currentMovie.getTitle());
        tvDetails.setText(currentMovie.getYear() + " - " + currentMovie.getGenre());
        if(currentMovie.getRated().equalsIgnoreCase("g")){
            rating.setImageResource(R.drawable.rating_g);
        }
        else if (currentMovie.getRated().equalsIgnoreCase("pg")){
            rating.setImageResource(R.drawable.rating_pg);
        }
        else if (currentMovie.getRated().equalsIgnoreCase("pg13")){
            rating.setImageResource(R.drawable.rating_pg13);
        }
        else if (currentMovie.getRated().equalsIgnoreCase("m18")){
            rating.setImageResource(R.drawable.rating_m18);
        }
        else if (currentMovie.getRated().equalsIgnoreCase("nc16")){
            rating.setImageResource(R.drawable.rating_nc16);
        }
        else if (currentMovie.getRated().equalsIgnoreCase("r21")){
            rating.setImageResource(R.drawable.rating_r21);
        }


        return rowView;
    }
}
