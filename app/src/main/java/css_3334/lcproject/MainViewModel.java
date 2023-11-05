package css_3334.lcproject;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private SinnerRepository sinnerRepository;
    private LiveData<List<Sinner>> sinnerList;

    public MainViewModel(@NonNull Application application) {
        super(application);
        sinnerRepository = new SinnerRepository(application);
        sinnerList = sinnerRepository.getAllSinners();
    }

    public LiveData<List<Sinner>> getAll() {
        sinnerList = sinnerRepository.getAllSinners();
        return sinnerList;
    }

    public void insert(String name, String rarity, int health, int speedLow, int speedHigh, String blunt, String pierce, String slash, String attack1, String attack2, String attack3, String sin1, String sin2, String sin3) {
        Sinner sin = new Sinner(name, rarity, health, speedLow, speedHigh, blunt, pierce, slash, attack1, attack2, attack3, sin1, sin2, sin3);
        sinnerRepository.insert(sin);
    }
}
