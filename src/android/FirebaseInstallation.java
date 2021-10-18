package org.apache.cordova.firebase;

import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class FirebaseInstallation extends CordovaPlugin {

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    if (action.equals("getInstallationId")) {
      this.getInstallationId(callbackContext);
      return true;
	}
    return false;
  }

  private void getInstallationId(final CallbackContext callbackContext) {
    cordova.getThreadPool().execute(new Runnable() {
      public void run() {
        try {
          String id = FirebaseInstanceId.getInstance().getId();
          callbackContext.success(id);
        } catch (Exception e) {
          callbackContext.error(e.getMessage());
        }
      }
    });
  }

}