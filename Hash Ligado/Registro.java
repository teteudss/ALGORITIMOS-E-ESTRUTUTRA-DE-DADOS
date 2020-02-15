package hashinglistaligada;

public class Registro {

    private String key;
    private String value;
    private int [] tabelaPeso;

    public Registro() {
        this.key = null;
        this.value = null;
        this.tabelaPeso = new int[50];
        calcularPesos();
    }

    public Registro(String key, String value) {
        this.key = key;
        this.value = value;
        this.tabelaPeso = new int[50];
        calcularPesos();
    }

    private void calcularPesos(){
        for (int i = 0; i < 50; i++) {
            tabelaPeso[i] = i + 1;
        }
    }
    
    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public int hashCode() {
        int codigo = 0;
        for (int i = 0; i < this.key.length(); i++) {
            codigo += this.key.charAt(i) * tabelaPeso[i];
        }
        return codigo % 367;
    }
}
