function eliminar(id){
	swal({
	  title: "¿Esta seguro?",
	  text: "¿Realmente desea eliminar este registro?",
	  icon: "warning",
	  buttons: true,
	  dangerMode: true,
	})
	.then((willDelete) => {
		if (willDelete) {
		  if (seccion === "empleados") {
			location.href = "/eliminarEmpleado/" + id;
		  } else if (seccion === "tareas") {
			location.href = "/eliminarTarea/" + id;
		  } else {
		  }
		} else {
		}
	});
}
