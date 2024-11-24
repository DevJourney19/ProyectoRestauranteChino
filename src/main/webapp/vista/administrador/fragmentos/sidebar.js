const toggler = document.querySelector(".toggler-btn");
toggler.addEventListener("click", function () {
  document.querySelector("#sidebar").classList.toggle("collapsed");
  document.querySelector("#logo").classList.toggle("collapsed");
});

// Obtener path y colocar una clase active al side que corresponda

const links = document.querySelectorAll('.sidebar-link'); // Asegúrate de que el selector sea correcto

// Función para obtener el último segmento de la URL
const getLastSegment = () => {
    const segment = window.location.pathname.split('/');
    return segment[segment.length - 1];
};

// Activar el enlace correspondiente al cargar la página
const activateLink = () => {
    const currentPath = getLastSegment();
    links.forEach(link => {
        const linkPath = link.getAttribute('href').split('/').pop(); // Obtener el último segmento del href
        if (currentPath === linkPath) {
            link.classList.add('active');
        }
    });
};

// Activar el enlace al cargar la página
activateLink();

links.forEach(link => {
    link.addEventListener('click', (event) => {
        event.preventDefault();
        links.forEach(l => l.classList.remove('active'));
        window.history.pushState({}, '', link.getAttribute('href'));
        link.classList.add('active');
		window.location.href = link.getAttribute('href');
    });
});
