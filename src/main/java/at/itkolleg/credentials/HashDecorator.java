package at.itkolleg.credentials;
/**
 * Diese abstrakte Klasse HashDecorator erweitert das Interface ExportCredentials
 */
public abstract class HashDecorator implements ExportCredentials{
    // Hält die zu dekorierende Export Variante
    protected ExportCredentials exportCredentials;

    /**
     * Konstruktur setzt das Datenfeld ExportCredentials mit der übergebenen zu dekorierenden ExportCredentials Variante
     * @param exportCredentials zu dekorierende Export Variante
     */
    public HashDecorator(ExportCredentials exportCredentials) {
        this.exportCredentials = exportCredentials;
    }
}
