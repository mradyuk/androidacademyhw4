package androidacademy.minsk.lecture3lists;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidacademy.minsk.lecture3lists.data.Actor;
import androidacademy.minsk.lecture3lists.data.DataUtil;
import androidx.appcompat.app.AppCompatActivity;

public class ActorListActivity extends AppCompatActivity {

    private ActorListAdapter adapter;

    private final AdapterView.OnItemClickListener clickListener = (adapterView, view, position, id) -> {
        Actor actor = adapter.getItem(position);
        String clickMessage = getString(R.string.actor_click_action, actor.getName());

        Toast.makeText(this, clickMessage, Toast.LENGTH_SHORT).show();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_list);

        ListView list = findViewById(R.id.actorList);
        adapter = new ActorListAdapter(this, DataUtil.generateActors());
        list.setAdapter(adapter);
        list.setOnItemClickListener(clickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actor_list_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.switchList:
                startActivity(new Intent(this, ActorRecyclerActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
