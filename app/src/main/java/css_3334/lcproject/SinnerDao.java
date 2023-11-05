package css_3334.lcproject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SinnerDao {
    @Query("SELECT * FROM Sinner")
    LiveData<List<Sinner>> getAll();

    @Insert
    void insert(Sinner sinner);

    @Delete
    void delete(Sinner sinner);

}
