package androidacademy.minsk.lecture3lists;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidacademy.minsk.lecture3lists.data.Actor;
import androidacademy.minsk.lecture3lists.data.DataUtil;
import androidx.appcompat.app.AppCompatActivity;

public class ActorDetailsActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actor_details);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        List<Actor> actors = DataUtil.generateActors();

        Actor actor = actors.get(position);

        ImageView avatar = findViewById(R.id.avatar_full);
        TextView text = findViewById(R.id.actor_txt);

        Glide.with(ActorDetailsActivity.this).load(actor.getAvatar()).into(avatar);
        text.setText(actor.getDetails());



    }
}
