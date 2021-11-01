var fireBase = fireBase || firebase;
var hasInit = false;
var config = {
  /* apiKey: "AIzaSyAq5EuwGXS1vRpD8vdmvTQnRWHT3r8nIpA",
  authDomain: "aimhelper-8510a.firebaseapp.com",
  databaseURL: "https://aimhelper-8510a.firebaseio.com",
  projectId: "aimhelper-8510a",
  storageBucket: "aimhelper-8510a.appspot.com",
  messagingSenderId: "43997639659",*/
  apiKey: "AIzaSyD2ni0vgg_bpedfuoglvPtUac4U6-7Gq7w",
  authDomain: "analisis-2021-2.firebaseapp.com",
  projectId: "analisis-2021-2",
  storageBucket: "analisis-2021-2.appspot.com",
  messagingSenderId: "1009141707731",
  appId: "1:1009141707731:web:f4a10a65d367bb26ea3526",
};
if (!hasInit) {
  firebase.initializeApp(config);
  hasInit = true;
}
