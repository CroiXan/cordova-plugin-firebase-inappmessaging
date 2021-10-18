var exec = require('cordova/exec');

var PLUGIN_NAME = 'FirebaseInstallation';

exports.getInstallationId = function (success, error) {
  exec(success, error, PLUGIN_NAME, "getInstallationId", []);
};


