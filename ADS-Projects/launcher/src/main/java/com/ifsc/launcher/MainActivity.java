package com.ifsc.launcher;

import android.app.Application;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AppAdapter adapter;
    private List<AppInfo> appList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.apps);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        appList = getInstalledApps();
        adapter = new AppAdapter(this, appList);
        recyclerView.setAdapter(adapter);
    }

    public List<AppInfo> getInstalledApps() {
        List<ApplicationInfo> allApps = new ArrayList<>();
        PackageManager pm = getPackageManager();
        allApps = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> launchableApps = pm.queryIntentActivities(mainIntent, PackageManager.MATCH_ALL);

        List<AppInfo> apps = new ArrayList<>();
        for(ResolveInfo resolveInfo : launchableApps) {
            String packageManager = resolveInfo.activityInfo.packageName;
            String packageName = resolveInfo.activityInfo.packageName;
            String name = (String) resolveInfo.loadLabel(pm);;
            Drawable icon  = resolveInfo.loadIcon(pm);

            boolean isSystemApp = false;
            try {
                isSystemApp = (pm.getApplicationInfo(packageName, 0).flags & ApplicationInfo.FLAG_SYSTEM) != 0;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

            apps.add(new AppInfo(name, packageName, icon, isSystemApp, true));
        }

        return apps;
    }
}