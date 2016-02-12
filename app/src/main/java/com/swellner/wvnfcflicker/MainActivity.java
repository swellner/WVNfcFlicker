package com.swellner.wvnfcflicker;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.tech.MifareUltralight;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private MyWebview myWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWebview = (MyWebview)findViewById(R.id.wvTest);
        myWebview.getSettings().setJavaScriptEnabled(true);
        myWebview.setWebViewClient(new WebViewClient());
        myWebview.loadUrl("http://google.com");
    }

    @Override
    protected void onResume() {
        super.onResume();
        myWebview.onResume();
        try {
            IntentFilter tag = new IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED);
            tag.addCategory("android.intent.category.DEFAULT");
            IntentFilter tech = new IntentFilter(NfcAdapter.ACTION_TECH_DISCOVERED);
            IntentFilter[] intentFiltersArray = new IntentFilter[] { tag, tech };

            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP),
                    0);

            String[][] techList = new String[][] { new String[] { MifareUltralight.class.getName() } };
            NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);

            if(nfcAdapter!=null)
            {
                nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFiltersArray, techList);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        myWebview.onPause();
    }
}
