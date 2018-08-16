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

import androidacademy.minsk.lecture3lists.data.Actor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


public class ActorRecyclerAdapter extends RecyclerView.Adapter<ActorRecyclerAdapter.ViewHolder> {
    @NonNull
    private final List<Actor> actors;
    @NonNull
    private final Context context;
    private final LayoutInflater inflater;
    @Nullable
    private final OnItemClickListener clickListener;
    @NonNull
    private final RequestOptions imageOption;

    public ActorRecyclerAdapter(@NonNull Context context, @NonNull List<Actor> actors,
            @Nullable OnItemClickListener clickListener) {
        this.actors = actors;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.clickListener = clickListener;
        this.imageOption = new RequestOptions()
                .placeholder(R.drawable.avatar_default_list)
                .fallback(R.drawable.avatar_default_list)
                .centerCrop();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.list_item_actor, parent, false), clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Actor actor = actors.get(position);

        Glide.with(context).load(actor.getAvatar()).apply(imageOption).into(holder.avatar);
        holder.name.setText(actor.getName());
        holder.oscar.setVisibility(actor.hasOscar() ? View.VISIBLE : View.GONE);
    }

    public Actor getItem(int position) {
        return actors.get(position);
    }

    @Override
    public int getItemCount() {
        return actors.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView avatar;
        final TextView name;
        final ImageView oscar;

        ViewHolder(@NonNull View itemView, @Nullable OnItemClickListener listener) {
            super(itemView);
            itemView.setOnClickListener((view -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position);
                }
            }));
            avatar = itemView.findViewById(R.id.avatar);
            name = itemView.findViewById(R.id.name);
            oscar = itemView.findViewById(R.id.oscar);
        }
    }
}
