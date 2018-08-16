package androidacademy.minsk.lecture3lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

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


    public ActorRecyclerAdapter(@NonNull Context context, @NonNull List<Actor> actors, @Nullable OnItemClickListener clickListener) {

      //  @Nullable OnItemClickListener clickListener
        this.actors = actors;
        this.context = context;
        this.clickListener = clickListener;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // LayoutInflater.from(context);


    }

    @Override
    public ActorRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.list_item_actor_main, parent, false), clickListener);
    }

    @Override
    public void onBindViewHolder(ActorRecyclerAdapter.ViewHolder holder, int position) {
        Actor actor = actors.get(position);
        Glide.with(context).load(actor.getAvatar()).into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return this.actors.size();
    }

    public Actor getItem(int position) {
        return actors.get(position);
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView avatar;

        ViewHolder(@NonNull View itemView, @Nullable OnItemClickListener listener) {
            super(itemView);

            itemView.setOnClickListener((view -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position);
                }
            }));

            avatar = itemView.findViewById(R.id.avatar);
        }
    }


}
