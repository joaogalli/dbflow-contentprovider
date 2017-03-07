package br.com.joao.dbflowsandbox.onetomany;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.ArrayList;
import java.util.List;

import br.com.joao.dbflowsandbox.simplecrud.AppDatabase;

/**
 * Created by joao.galli on 09/02/2017.
 */
@Table(database = AppDatabase.class)
public class Student extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    long id;

    @Column
    String name;

    public List<Interest> interests;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", interests=" + interests +
                '}';
    }

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "interests")
    public List<Interest> getInterests() {
        if (interests == null || interests.isEmpty()) {
            interests = SQLite.select()
                    .from(Interest.class)
                    .where(Interest_Table.studentId_id.eq(id))
                    .queryList();
        }
        return interests;
    }

    public void addInterest(Interest interest) {
        if (interests == null) {
            interests = new ArrayList<>();
        }
        interests.add(interest);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }
}
