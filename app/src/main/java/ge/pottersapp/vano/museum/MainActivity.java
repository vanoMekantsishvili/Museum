package ge.pottersapp.vano.museum;

import android.os.SystemClock;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.SoundEffectConstants;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import java.io.Console;
import java.security.SignatureSpi;
import java.util.ArrayList;

import ge.pottersapp.vano.museum.fragments.ExhibitionFragment;
import ge.pottersapp.vano.museum.fragments.MapFragment;
import ge.pottersapp.vano.museum.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {
    private BottomBar mBottomBar;
    Fragment fr;
    FragmentManager fm;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItemsFromMenu(R.menu.bottombar_menu, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.bottomBarItemOne) {
                    // The user selected item number one.
                    fr = new SearchFragment();
                    fm = getSupportFragmentManager();
                    fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container,fr);
                    fragmentTransaction.commit();

                }else if(menuItemId == R.id.bottomBarItemTwo){
                    fr = new ExhibitionFragment();
                    fm = getSupportFragmentManager();
                    fragmentTransaction=fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container,fr);
                    fragmentTransaction.commit();

                }else if(menuItemId == R.id.bottomBarItemThree){
                    fr = new MapFragment();
                    fm = getSupportFragmentManager();
                    fragmentTransaction=fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container,fr);
                    fragmentTransaction.commit();
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.bottomBarItemOne) {
                    // The user reselected item number one, scroll your content to top.
                    Toast.makeText(getApplicationContext(), getMessage(menuItemId, true), Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Setting colors for different tabs when there's more than three of them.
        // You can set colors for tabs in three different ways as shown below.
        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
        mBottomBar.mapColorForTab(1, "#000000");
        mBottomBar.mapColorForTab(2, "#000000");

// Use the dark theme.
        mBottomBar.useDarkTheme();

        mBottomBar.setActiveTabColor("#FFFFFF");
    }

    private String getMessage(int menuItemId, boolean isReselection) {
        String message = "Content for ";

        switch (menuItemId) {
            case R.id.bottomBarItemOne:
                message += "SEARCH";
                break;
            case R.id.bottomBarItemTwo:
                message += "EXHIBITION";
                break;
            case R.id.bottomBarItemThree:
                message += "MAP";
                break;
        }

        if (isReselection) {
            message += " It will be soon:)";
        }

        return message;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
    }

}
