package br.com.joao.dbflowsandbox.onetomany;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import br.com.joao.dbflowsandbox.R;

public class OneToManyActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_to_many);

        editText = (EditText) findViewById(R.id.editText);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save:
                save();
                break;
            case R.id.deletar:
                delete();
                break;
            case R.id.verificar:
                verify();
                break;
            case R.id.deleteAll:
                deleteAll();
                break;
        }
    }

    private Student student;

    private void save() {
        student = new Student();
        student.setName("Student...");
//        student.getInterests().add(new Interest("Interest 1"));
        student.addInterest(new Interest("Interest 1"));

        student.save();

//        Interest interest = new Interest("Interest 1");
//        interest.setStudentId(student.getId());
//        interest.save();
    }

    private void delete() {
        if (student != null) {
            student.delete();
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        }
    }

    private void verify() {
        List<Student> students =
                SQLite.select().from(Student.class).queryList();

        StringBuilder sb = new StringBuilder();
        for (Student s : students) {
            sb.append(s.toString()).append("\n");
        }

        editText.setText(sb.toString());
    }

    private void deleteAll() {
        SQLite.delete().from(Interest.class).execute();
        SQLite.delete().from(Student.class).execute();
    }

}
