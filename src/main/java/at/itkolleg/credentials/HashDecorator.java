package at.itkolleg.credentials;
/**
 * Diese abstrakte Klasse HashDecorator erweitert das Interface ExportCredentials
 */
public abstract class HashDecorator implements ExportCredentials{
    // Hält das Interface ExportCredentials
    protected ExportCredentials exportCredentials;

    /**
     * Konstruktur setzt das Datenfeld ExportCredentials mit dem übergebenen Interface ExportCredentials
     * @param exportCredentials ein Interface von ExportCredentials
     */
    public HashDecorator(ExportCredentials exportCredentials) {
        this.exportCredentials = exportCredentials;
    }
}
