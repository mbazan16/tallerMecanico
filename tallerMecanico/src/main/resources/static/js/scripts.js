function mostrarContrasenas() {
    // Obtener todos los elementos de tipo contraseña en el formulario
    var contrasenas = document.querySelectorAll('input[type="password"]');

    // Iterar sobre cada campo de contraseña y cambiar su tipo a texto
    contrasenas.forEach(function(contrasena) {
        contrasena.type = "text";
    });

    // Después de 2 segundos, ocultar nuevamente las contraseñas
    setTimeout(function() {
        contrasenas.forEach(function(contrasena) {
            contrasena.type = "password";
        });
    }, 2000);
}

window.addEventListener('DOMContentLoaded', event => {

    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });
    }

});

var myModal = document.getElementById('myModal')
var myInput = document.getElementById('myInput')

myModal.addEventListener('shown.bs.modal', function () {
  myInput.focus()
})

window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
});
