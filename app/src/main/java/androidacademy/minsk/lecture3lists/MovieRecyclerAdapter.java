package androidacademy.minsk.lecture3lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import androidacademy.minsk.lecture3lists.movie.Movie;
import androidx.recyclerview.widget.RecyclerView;

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.ViewHolder> {


    private List<Movie> movies;
    private final Context context;
    private final LayoutInflater inflater;

    private final RequestOptions imageOption;

    public MovieRecyclerAdapter(Context context, List<Movie> movies) {
        this.movies = movies;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        this.imageOption = new RequestOptions()
                .placeholder(R.drawable.avatar_default_list)
                .fallback(R.drawable.avatar_default_list)
                .centerCrop();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.list_item_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = movies.get(position);

        Glide.with(context).load(movie.getPoster()).apply(imageOption).into(holder.poster);
        holder.title.setText(movie.getTitle());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public Movie getItem(int position) {
        return movies.get(position);
    }

    public void setItems(List<Movie> movies) {
        this.movies = movies;

        notifyDataSetChanged();
    }

  /*  public interface OnItemClickListener {
        void onItemClick(int position);
    }*/

    static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView poster;
        final TextView title;

        ViewHolder(View itemView) {
            super(itemView);

            poster = itemView.findViewById(R.id.poster);
            title = itemView.findViewById(R.id.title);

        }
    }
}
