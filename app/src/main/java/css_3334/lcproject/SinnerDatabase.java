package css_3334.lcproject;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Sinner.class}, version = 1)
public abstract class SinnerDatabase extends RoomDatabase{
    public abstract SinnerDao sinnerDao();
    private static SinnerDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static SinnerDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SinnerDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    SinnerDatabase.class, "sinner_database_2")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
