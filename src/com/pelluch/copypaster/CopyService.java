package com.pelluch.copypaster;
import android.app.IntentService;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;


public class CopyService extends IntentService {

	public CopyService() {
		super("CopyService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		if(intent.hasExtra("copy")) {
			
			ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
			String content = intent.getStringExtra("copy");
			if(content != null) {
				clipboard.setPrimaryClip(ClipData.newPlainText("CopyService", content));
			}
		}
		
	}

}
