package androidacademy.minsk.lecture3lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import androidacademy.minsk.lecture3lists.data.Actor;
import androidx.annotation.NonNull;


public class ActorListAdapter extends BaseAdapter {
    @NonNull
    private final List<Actor> actors;
    @NonNull
    private final Context context;
    private final LayoutInflater inflater;
    @NonNull
    private final RequestOptions imageOption;

    public ActorListAdapter(@NonNull Context context, @NonNull List<Actor> actors) {
        this.actors = actors;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.imageOption = new RequestOptions()
                .placeholder(R.drawable.avatar_default_list)
                .fallback(R.drawable.avatar_default_list)
                .centerCrop();
    }

    @Override
    public int getCount() {
        return actors.size();
    }

    @Override
    public Actor getItem(int position) {
        return actors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = onCreateViewHolder(parent);
            convertView = holder.itemView;
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        onBindViewHolder(holder, position);

        return convertView;
    }

    private ViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new ViewHolder(inflater.inflate(R.layout.list_item_actor, parent, false));
    }

    private void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Actor actor = actors.get(position);

        Glide.with(context).load(actor.getAvatar()).apply(imageOption).into(holder.avatar);
        holder.name.setText(actor.getName());
        holder.oscar.setVisibility(actor.hasOscar() ? View.VISIBLE : View.GONE);
    }

    static class ViewHolder {
        final View itemView;

        final ImageView avatar;
        final TextView name;
        final ImageView oscar;

        ViewHolder(@NonNull View itemView) {
            this.itemView = itemView;
            this.avatar = itemView.findViewById(R.id.avatar);
            this.name = itemView.findViewById(R.id.name);
            this.oscar = itemView.findViewById(R.id.oscar);
        }
    }
}
