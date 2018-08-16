package androidacademy.minsk.lecture3lists;

import android.os.Bundle;
import android.widget.Toast;

import androidacademy.minsk.lecture3lists.data.Actor;
import androidacademy.minsk.lecture3lists.data.DataUtil;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ActorRecyclerActivity extends AppCompatActivity {

    private ActorRecyclerAdapter adapter;

    private final ActorRecyclerAdapter.OnItemClickListener clickListener = position -> {
        Actor actor = adapter.getItem(position);
        String clickMessage = getString(R.string.actor_click_action, actor.getName());

        Toast.makeText(this, clickMessage, Toast.LENGTH_SHORT).show();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_recycler);

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        RecyclerView list = findViewById(R.id.actorList);
        adapter = new ActorRecyclerAdapter(this, DataUtil.generateActors(), clickListener);
        list.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
