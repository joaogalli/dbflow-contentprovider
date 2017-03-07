package br.com.joao.dbflowsandbox.simplecrud;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import br.com.joao.dbflowsandbox.R;

public class SimpleCrudActivity extends AppCompatActivity implements PersonFragment.OnListFragmentInteractionListener {

    private EditText editText;
    private Person person;
    private PersonFragment personFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_crud);

        editText = (EditText) findViewById(R.id.nameEditText);

        FragmentManager fragmentManager = getSupportFragmentManager();
        personFragment = PersonFragment.newInstance(1);
        fragmentManager.beginTransaction().add(R.id.fragment_list, personFragment).commit();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            String name = editText.getText().toString();

            if (person == null)
                person = new Person();

            person.setName(name);
            person.save();
            person = null;

            editText.setText("");
            personFragment.update();
        }
    }

    @Override
    public void onListFragmentInteraction(Person person) {
        this.person = person;
        editText.setText(person.getName());
    }
}
