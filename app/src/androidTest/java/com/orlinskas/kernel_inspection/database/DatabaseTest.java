package com.orlinskas.kernel_inspection.database;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.orlinskas.kernel_inspection.enums.LockingDevisesStatus;
import com.orlinskas.kernel_inspection.mvvm.model.Card;
import com.orlinskas.kernel_inspection.mvvm.model.Driver;
import com.orlinskas.kernel_inspection.mvvm.model.LockingDevise;
import com.orlinskas.kernel_inspection.mvvm.model.Trailer;
import com.orlinskas.kernel_inspection.mvvm.model.Vehicle;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {
    private LockingDevise lockingDevise = new LockingDevise("Mark", "Post", LockingDevisesStatus.CHEKED);
    private Driver driver = new Driver("Petro", "Koval", "null",  327632);

    private Collection<LockingDevise> devises = new ArrayList<>();
    private Collection<Long> trailerArrivals = new ArrayList<>();
    private Trailer trailer;

    private Collection<Long> vehicleArrivals = new ArrayList<>();
    private Vehicle vehicle = new Vehicle("Volvo", trailer, driver,"AX-321-AB", vehicleArrivals);

    private Card card = new Card(vehicle);

    private Database database;

    @Before
    public void setUp() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        database = OpenHelperManager.getHelper(context, Database.class);
        devises.add(lockingDevise);
        devises.add(lockingDevise);

        trailerArrivals.add(System.currentTimeMillis());
        vehicleArrivals.add(System.currentTimeMillis());
    }

    @Test
    public void insert() {
        try {
            trailer = new Trailer("AX-123-AB", devises);
            database.getTrailerDao().create(trailer);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Trailer testTrailer = null;
        try {
            testTrailer = database.getTrailerDao().findFrom(trailer.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertTrue(testTrailer.getLockingDevises().size() > 0);


        //try {
        //    database.getCardDAO().create(card);
        //} catch (SQLException e) {
        //    e.printStackTrace();
        //}
//
        //Card card = null;
        //try {
        //    card = database.getCardDAO().findFrom(this.card.getId());
        //} catch (SQLException e) {
        //    e.printStackTrace();
        //}
//
        //assertNotNull(card);
    }

}