package codeguru.connect4;

import android.os.Bundle;
import android.view.Menu;
import com.badlogic.gdx.backends.android.AndroidApplication;

public class Connect4Main extends AndroidApplication {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initialize(new Connect4(), false);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
