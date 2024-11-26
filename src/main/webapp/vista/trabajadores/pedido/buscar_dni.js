let boton_buscar = document.getElementById("buscar_dni");
boton_buscar.addEventListener("click", async function(event) {
        event.preventDefault();
        let dni = document.getElementById("dniCliente").value;
        console.log(dni);

        // Validar el DNI
        if (!dni || dni.length !== 8 || isNaN(dni)) {
                alert("Por favor, ingrese un DNI válido.");
                return;
        }

        try {
                // Realizar la petición al backend
                const response = await fetch('http://localhost:8012/api/consulta-dni', {
                        method: 'POST',
                        headers: {
                                'Content-Type': 'application/x-www-form-urlencoded'
                        },
                        body: `dni=${dni}`
                });

                if (!response.ok) {
                        throw new Error('Error en la respuesta del servidor');
                }
                // Procesar la respuesta
                const data = await response.json();

                if (data.error) {
                        console.log("Error data.error: " + data.error);
                } else {
                        const nombres = data.nombres;
                        const apellidoPaterno = data.apellido_paterno;
                        const apellidoMaterno = data.apellido_materno;

                        let nombreCompletoMostrar = document.getElementById("nombreCompleto");
                        nombreCompletoMostrar.value = apellidoPaterno+" "+apellidoMaterno+", "+nombres;

                }
        } catch (error) {
                console.error('Error:', error);
        }


});
