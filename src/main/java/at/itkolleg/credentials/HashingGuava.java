package at.itkolleg.credentials;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.List;
/**
 * Diese konkrete Dekorierer Klasse HashingGuava gibt eine konkrete Hashing Variante vor
 */
public class HashingGuava extends HashDecorator{
    /**
     * Konstruktor überreicht die mitgegebene zu dekorierende Export Variante an die Mutterklasse HashDecorator
     * @param exportCredentials zu dekorierende Export Variante
     */
    public HashingGuava(ExportCredentials exportCredentials) {
        super(exportCredentials);
    }

    /**
     * Implementiert die konkrete Hash Export Strategie. Von der übergebenen Liste wird das klartext Passwort gehasht
     * Ruft die Mutterklassen Methode "export" auf und übergibt die Credentials Liste mit dem gehashten Passwort
     * @param credentialsList Liste von Credentials, mit noch im klartext stehendem Passwort
     */
    @Override
    public void export(List<Credentials> credentialsList) {
        for(Credentials credential : credentialsList){
            String sha256hex = Hashing.sha256()
                    .hashString(credential.getPwd(), StandardCharsets.UTF_8)
                    .toString();
            credential.setPwd(sha256hex);
        }
        exportCredentials.export(credentialsList);
    }
}
