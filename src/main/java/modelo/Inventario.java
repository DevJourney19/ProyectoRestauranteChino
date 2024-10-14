package modelo;

public class Inventario {
    private int id;
    private int idCategoria;
    private String nombre;
    private String unidad;
    private double precioUnitario;
    private int inventarioInicial;
    private int stock;
    private int stockMin;
    private String caducidad;
    private int idTrabajador;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getInventarioInicial() {
        return inventarioInicial;
    }

    public void setInventarioInicial(int inventarioInicial) {
        this.inventarioInicial = inventarioInicial;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockMin() {
        return stockMin;
    }

    public void setStockMin(int stockMin) {
        this.stockMin = stockMin;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public Inventario() {
        super();
    }

    public Inventario(int id, int idCategoria, String nombre, String unidad, double precioUnitario,
                      int inventarioInicial, int stock, int stockMin, String caducidad, int idTrabajador) {
        super();
        this.id = id;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.unidad = unidad;
        this.precioUnitario = precioUnitario;
        this.inventarioInicial = inventarioInicial;
        this.stock = stock;
        this.stockMin = stockMin;
        this.caducidad = caducidad;
        this.idTrabajador = idTrabajador;
    }
}
