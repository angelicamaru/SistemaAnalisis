window.onload = function () {
  const valores = window.location.search;

  var url = "http://localhost:8080/addUser";
  var data = "cuaderagenda";

  fetch(url, {
    method: "POST",
    body: JSON.stringify("11"),
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  })
    .then(function (response) {
      return response.json();
    })
    .then(function (datas) {
      console.log(datas);
      showDatos(datas.imagen, datas.nombre, datas.descripcion, datas.precio);
    });
};
