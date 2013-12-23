package codeguru.connect4;

import codeguru.connect4.Connect4.PlayerType;
import com.badlogic.gdx.ApplicationListener;

import android.os.Bundle;
import android.view.Menu;
import com.badlogic.gdx.backends.android.AndroidApplication;

public class Connect4Main extends AndroidApplication {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PlayerType[] types = new PlayerType[]{PlayerType.HUMAN, PlayerType.HUMAN};
        ApplicationListener app = new Connect4(types);
        this.initialize(app, false);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
