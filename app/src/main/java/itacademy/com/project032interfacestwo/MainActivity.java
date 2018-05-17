package itacademy.com.project032interfacestwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener,
        DeleteCallback,
        AdapterCallback {

    private ToDoAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        ArrayList<ToDoModel> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ToDoModel model = new ToDoModel("Action " + i, "do smth");
            arrayList.add(model);
        }

        listView.setAdapter(mAdapter = new ToDoAdapter(this, arrayList, this));
//        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DeleteDialogFragment
                .newInstance((String) parent.getItemAtPosition(position))
                .show(getSupportFragmentManager(), "delete");
    }


    @Override
    public void deleteItem(String item) {
//        mAdapter.remove(item);
//        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void deleteModel(ToDoModel model) {
        mAdapter.remove(model);
        mAdapter.notifyDataSetChanged();
    }
}
