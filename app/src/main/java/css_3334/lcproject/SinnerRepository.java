package css_3334.lcproject;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class SinnerRepository {
    private SinnerDao sinnerDao;
    private LiveData<List<Sinner>> allSinners;

    SinnerRepository(Application application) {
        SinnerDatabase db = SinnerDatabase.getDatabase(application);
        sinnerDao = db.sinnerDao();
        allSinners = sinnerDao.getAll();
        //allHeartrates = heartrateDao.getAll();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Sinner>> getAllSinners() {
        allSinners = sinnerDao.getAll();
        return allSinners;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(Sinner sinner) {
        SinnerDatabase.databaseWriteExecutor.execute(() -> {
            sinnerDao.insert(sinner);
        });
    }
}
