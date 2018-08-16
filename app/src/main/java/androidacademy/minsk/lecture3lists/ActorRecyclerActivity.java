package androidacademy.minsk.lecture3lists;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.Toast;

import androidacademy.minsk.lecture3lists.data.Actor;
import androidacademy.minsk.lecture3lists.data.DataUtil;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ActorRecyclerActivity extends AppCompatActivity {

    private ActorRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_recycler);

        RecyclerView list = findViewById(R.id.actorList);

        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE))
                .getDefaultDisplay();

        int orientation = display.getRotation();

        RecyclerView.LayoutManager layoutManager;
        if (orientation == Surface.ROTATION_90
                || orientation == Surface.ROTATION_270) {
            layoutManager = new GridLayoutManager(getApplicationContext(), 4);
        } else {
            layoutManager = new GridLayoutManager(getApplicationContext(), 2);

        }

        list.setLayoutManager(layoutManager);

        adapter = new ActorRecyclerAdapter(this, DataUtil.generateActors(), new ActorRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Actor actor = adapter.getItem(position);
                Intent myIntent = new Intent(ActorRecyclerActivity.this, ActorDetailsActivity.class);
                myIntent.putExtra("position", position); //Optional parameters
                startActivity(myIntent);
            }
        });
        list.setAdapter(adapter);

        ItemOffsetDecorator itemDecoration = new ItemOffsetDecorator(getApplicationContext(), R.dimen.item_offset);
        list.addItemDecoration(itemDecoration);

    }


}
